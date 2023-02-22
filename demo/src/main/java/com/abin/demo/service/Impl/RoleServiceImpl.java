package com.abin.demo.service.Impl;

import com.abin.demo.common.util.PageUtils;
import com.abin.demo.db.dao.RoleDao;
import com.abin.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

/**
* @Author: 啊斌
* @Data:2023/2/21 15:30
*/
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    /**
     * 搜索角色页面
     *
     * @param param 参数
     * @return {@link PageUtils}
     */
    @Override
    public PageUtils searchRoleByPage(HashMap param) {
        ArrayList<HashMap> list = roleDao.searchRoleByPage(param);
        Long count = roleDao.searchRoleCount(param);
        int start = (Integer) param.get("start");
        int length = (Integer) param.get("length");
        return new PageUtils(list, count, start, length);

    }
}
