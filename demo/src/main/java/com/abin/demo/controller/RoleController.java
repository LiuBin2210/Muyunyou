package com.abin.demo.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.annotation.SaMode;
import cn.hutool.json.JSONUtil;
import com.abin.demo.common.util.PageUtils;
import com.abin.demo.common.util.R;
import com.abin.demo.controller.form.SearchRoleByPageForm;
import com.abin.demo.service.RoleService;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;

/**
* @Author: 啊斌
* @Data:2023/2/21 15:31
*/
@RestController
@Tag(name = "RoleController",description = "用户权限web接口")
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/searchRoleByPage")
    @Schema(description = "查询用户角色")
    @SaCheckPermission(value = {"ROOT","USER:SELECT"}, mode = SaMode.OR)
    public R searchRoleByPage(@Valid @RequestBody SearchRoleByPageForm form){
        int page = form.getPage();
        int length = form.getLength();
        int start = (page -1) *length;
        HashMap param = JSONUtil.parse(form).toBean(HashMap.class);
        param.put("start",start);
        PageUtils pageUtils = roleService.searchRoleByPage(param);
        return R.ok().put("page",pageUtils);
    }
}
