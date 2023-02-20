package com.abin.demo.config;

import cn.dev33.satoken.stp.StpInterface;
import com.abin.demo.db.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @Author: 啊斌
 * @Data:2023/2/13 17:17
 *
 * 自定义权限接口扩展
 */
@Component //保证此类被springboot扫描，完成Sa-token的自定义权限验证扩展
public class StpInterfaceImpl implements StpInterface {

    @Autowired
    private UserDao userDao;
    /**
     * 返回一个用户所拥有的权限
     */
    @Override
    public List<String> getPermissionList(Object loginId, String loginKey) {
        int userId = Integer.parseInt(loginId.toString());
        Set<String> permissions = userDao.searchUserPermissions(userId);
        ArrayList list = new ArrayList();
        list.addAll(permissions);
        return list;
    }
    /*
    * 返回一个账号所拥有的角色标识集合
    * */
    @Override
    public List<String> getRoleList(Object o, String s) {
        return null;
    }
}
