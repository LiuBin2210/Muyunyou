package com.abin.demo.service;

import com.abin.demo.common.util.PageUtils;
import com.abin.demo.db.pojo.Dept;

import java.util.HashMap;

/**
 * 部门服务
 *
 * @author 啊斌
 * @date 2023/02/25
 */
public interface DeptService {

    /**
     * 查询部门分页数据
     *
     * @param param 参数
     * @return {@link PageUtils}
     */
    PageUtils searchDeptByPage(HashMap param);

    /**
     * 插入
     *
     * @param dept 部门
     * @return int
     */
    int insert(Dept dept);
}
