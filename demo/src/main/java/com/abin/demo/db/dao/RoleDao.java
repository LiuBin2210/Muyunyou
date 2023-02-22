package com.abin.demo.db.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Author: 啊斌
 * @Data:2023/2/21 14:30
 */
@Mapper
public interface RoleDao {

    /**
     * 搜索角色页面
     *
     * @param param 参数
     * @return {@link ArrayList}<{@link HashMap}>
     */
    ArrayList<HashMap> searchRoleByPage(HashMap param);

    /**
     * 搜索角色数
     *
     * @param param 参数
     * @return {@link Long}
     */
    Long searchRoleCount(HashMap param);
}



