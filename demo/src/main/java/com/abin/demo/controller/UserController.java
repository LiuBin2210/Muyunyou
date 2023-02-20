package com.abin.demo.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.annotation.SaMode;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.json.JSONUtil;
import com.abin.demo.common.util.JsonUtils;
import com.abin.demo.common.util.MD5Utils;
import com.abin.demo.common.util.PageUtils;
import com.abin.demo.common.util.R;
import com.abin.demo.controller.form.*;
import com.abin.demo.db.pojo.User;
import com.abin.demo.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;

/**
 * @Author: 啊斌
 * @Data:2023/2/12 13:18
 */
@RestController
@RequestMapping("user")
@Tag(name = "UserController" ,description = "用户web接口")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    @Operation(summary = "用户注册")
    public R register(@Valid @RequestBody UserForm form) throws Exception {
        User user = new User();
        user.setUsername(form.getUsername());
        user.setPassword(MD5Utils.getMD5Str(form.getPassword()));
        user.setCreateTime(new Date());
        user.setStatus((byte) 1);
        user.setRoot(false);
        user.setRole(JsonUtils.objectToJson(2));
        userService.register(user);
        return R.ok();
    }

    @PostMapping("/login")
    @Operation(summary = "用户登录")
    public R login(@Valid @RequestBody LoginForm form) throws Exception {
        String md5Str = MD5Utils.getMD5Str(form.getPassword());
        HashMap<String, String> param = new HashMap<>();
        param.put("username",form.getUsername());
        param.put("password",md5Str);
        Integer userId = userService.login(param);
        R r = R.ok().put("result",userId != null ? true : false);
        if (userId != null){
            StpUtil.setLoginId(userId);
            Set<String> permissions = userService.searchUserPermissions(userId);
            String token = StpUtil.getTokenInfo().getTokenValue();
            r.put("permissions",permissions).put("token",token);
        }
        return r;
    }

    @GetMapping("logout")
    @Operation(summary = "退出登录")
    public R logout(){
        StpUtil.logout();
        return R.ok();
    }

    @PostMapping("/updatePassword")
    @SaCheckLogin
    @Operation(summary = "修改密码")
    public R updatePassword(@Valid @RequestBody UpdatePasswordForm form) throws Exception {
        int userId = StpUtil.getLoginIdAsInt();
        HashMap param = new HashMap(){{
            put("userId",userId);
            put("password",MD5Utils.getMD5Str(form.getPassword()));
            put("newPassword",MD5Utils.getMD5Str(form.getNewPassword()));
        }};
        int rows = userService.updatePassword(param);
        if (rows !=1){
            return R.error("密码修改失败!");
        }
        return R.ok().put("rows",rows);
    }

    @PostMapping("/searchUserByPage")
    @Operation(summary = "查询用户分页记录")
    @SaCheckPermission(value = {"ROOT","USER:SELECT"},mode = SaMode.OR)
    public R searchUserByPage(@Valid @RequestBody SearchUserByPageForm form){
        Integer page = form.getPage();
        Integer length = form.getLength();
        int start = (page - 1) * length;
        HashMap param = JSONUtil.parse(form).toBean(HashMap.class);
        param.put("start",start);
        PageUtils pageUtils = userService.searchUserPage(param);
        return R.ok().put("page",pageUtils);
    }

    @PostMapping("/insert")
    @Operation(summary = "添加用户")
    @SaCheckPermission(value = {"ROOT","USER:INSERT"},mode = SaMode.OR)
    public R insert(@Valid @RequestBody InsertUserForm form){
        User user = JSONUtil.parse(form).toBean(User.class);
        user.setStatus((byte)1);
        user.setRole(JSONUtil.parseArray(form.getRole()).toString());
        user.setCreateTime(new Date());
        int rows = userService.insert(user);
        return R.ok().put("rows",rows);
    }
}
