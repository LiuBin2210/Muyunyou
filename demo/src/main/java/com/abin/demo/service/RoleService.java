package com.abin.demo.service;

import com.abin.demo.common.util.PageUtils;
import com.abin.demo.db.pojo.Role;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 角色服务
 *
 * @author 啊斌
 * @Author: 啊斌
 * @Data:2023/2/21 15:29
 * @date 2023/02/21
 */
public interface RoleService {

    /**
     * 搜索角色页面
     *
     * @param param 参数
     * @return {@link PageUtils}
     */
    PageUtils searchRoleByPage(HashMap param);

    /**
     * 插入
     *
     * @param role 角色
     * @return int
     */
    int insert(Role role);

    /**
     * 按角色id搜索用户id
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
}
