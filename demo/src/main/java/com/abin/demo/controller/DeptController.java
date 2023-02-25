package com.abin.demo.controller;

import cn.hutool.json.JSONUtil;
import com.abin.demo.common.util.PageUtils;
import com.abin.demo.common.util.R;
import com.abin.demo.controller.form.SearchDeptByPageForm;
import com.abin.demo.service.DeptService;
import io.swagger.v3.oas.annotations.Operation;
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
 * 部门Controller
 *
 * @author 啊斌
 * @date 2023/02/25
 */
@RestController
@Tag(name = "DeptController",description = "部门web接口")
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @PostMapping("/searchDeptByPage")
    @Operation(summary = "查询部门分页数据")
    public R searchDeptByPage(@Valid @RequestBody SearchDeptByPageForm form){
        int page = form.getPage();
        int length = form.getLength();
        int start = (page -1) * length;
        HashMap param = JSONUtil.parse(form).toBean(HashMap.class);
        param.put("start", start);
        PageUtils pageUtils = deptService.searchDeptByPage(param);
        return R.ok().put("page", pageUtils);
    }
}
