package com.abin.demo.service.Impl;

import com.abin.demo.common.util.PageUtils;

import com.abin.demo.db.dao.DeptDao;
import com.abin.demo.db.pojo.Dept;
import com.abin.demo.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 部门服务impl
 *
 * @author 啊斌
 * @date 2023/02/25
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;
    @Override
    public PageUtils searchDeptByPage(HashMap param) {
        ArrayList<HashMap> list = deptDao.searchDeptByPage(param);
        long count = deptDao.searchDeptCount(param);
        int start = (Integer) param.get("start");
        int length = (Integer) param.get("length");
        return new PageUtils(list,count,start,length);
    }

    /**
     * 插入
     *
     * @param dept 部门
     * @return int
     */
    @Override
    public int insert(Dept dept) {
        return deptDao.insert(dept);
    }
}
