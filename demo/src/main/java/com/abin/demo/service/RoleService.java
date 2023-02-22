package com.abin.demo.service;

import com.abin.demo.common.util.PageUtils;

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
}
