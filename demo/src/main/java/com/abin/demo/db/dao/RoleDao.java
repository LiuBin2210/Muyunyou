package com.abin.demo.db.dao;

import com.abin.demo.db.pojo.Role;
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

    /**
     * 插入
     *
     * @param role 角色
     * @return int
     */
    int insert(Role role);

    /**
     * 搜索用户id角色id
     *
     * @param roleId 角色id
     * @return {@link ArrayList}<{@link Integer}>
     */
    ArrayList<Integer> searchUserIdRoleId(int roleId);

    /**
     * 更新
     *
     * @param role 角色
     * @return int
     */
    int update(Role role);

    /**
     * 搜索可以删除
     *
     * @param ids id
     * @return boolean
     */
    boolean searchCanDelete(Integer[] ids);

    /**
     * 根据id删除角色
     *
     * @param ids id
     * @return int
     */
    int deleteRoleByIds(Integer[] ids);


}



