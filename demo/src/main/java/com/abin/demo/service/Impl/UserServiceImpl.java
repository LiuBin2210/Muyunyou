package com.abin.demo.service.Impl;

import com.abin.demo.common.util.PageUtils;
import com.abin.demo.db.dao.UserDao;
import com.abin.demo.db.pojo.User;
import com.abin.demo.exception.HandleException;
import com.abin.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * @Author: 啊斌
 * @Data:2023/2/8 21:14
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    /**
     * 搜索用户权限
     *
     * @param userId 用户id
     * @return {@link Set}<{@link String}>
     */
    @Override
    public Set<String> searchUserPermissions(int userId) {
       return userDao.searchUserPermissions(userId);
    }

    /**
     * 注册
     */
    @Override
    public void register(User user) {
        int rows = userDao.register(user);
        if (rows !=1){
            throw  new HandleException("注册失败！");
        }
    }


    /**
     * 登录
     *
     * @param param 参数
     * @return {@link Integer}
     */
    @Override
    public Integer login(HashMap param) {
        return userDao.login(param);
    }

    /**
     * 更新密码
     *
     * @param param 参数
     * @return int
     */
    @Override
    public int updatePassword(HashMap param) {
        return userDao.updatePassword(param);
    }

    /**
     * 查询用户数据（分页）
     *
     * @param param 参数
     * @return {@link PageUtils}
     */
    @Override
    public PageUtils searchUserPage(HashMap param) {
        ArrayList<HashMap> list = userDao.searchUserByPage(param);
        Long count = userDao.searchUserCount(param);
        int start =(Integer) param.get("start");
        int length = (Integer) param.get("length");
        return new PageUtils(list, count, start, length);
    }

    /**
     * 插入
     *
     * @param user 用户
     * @return int
     */
    @Override
    public int insert(User user) {
       return userDao.insert(user);
    }

    /**
     * 更新
     *
     * @param param 参数
     * @return int
     */
    @Override
    public int update(HashMap param) {
        return userDao.update(param);
    }
}
