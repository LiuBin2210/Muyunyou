package com.abin.demo.service;

import com.abin.demo.common.util.PageUtils;
import com.abin.demo.db.pojo.User;

import java.util.HashMap;
import java.util.Set;

/**
 * @Author: 啊斌
 * @Data:2023/2/8 21:14
 */
public interface UserService {

    /**
     * 搜索用户权限
     *
     * @param userId 用户id
     * @return {@link Set}<{@link String}>
     */
    Set<String> searchUserPermissions(int userId);

    /**
     * 注册
     *
     * @param user 用户
     */
    void register(User user);

    /**
     * 登录
     *
     * @param param 参数
     * @return {@link Integer}
     */
    Integer login(HashMap param);

    /**
     * 更新密码
     *
     * @param param 参数
     * @return int
     */
    int updatePassword(HashMap param);

    /**
     * 搜索用户页面
     *
     * @param param 参数
     * @return {@link PageUtils}
     */
    PageUtils searchUserPage(HashMap param);

    /**
     * 插入
     *
     * @param user 用户
     * @return int
     */
    int insert(User user);

    /**
     * 更新
     *
     * @param param 参数
     * @return int
     */
    int update(HashMap param);

    /**
     * 删除用户id
     *
     * @param ids id
     * @return int
     */
    int deleteUserByIds(Integer[] ids);
}
