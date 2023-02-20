package com.abin.demo.db.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * 部门表
 * @author 啊斌
 * @date 2023/02/13
 */
@Data
public class Dept implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 部门名称
     */
    private String deptName;

    private String tel;

    private String email;

    private String desc;

    private static final long serialVersionUID = 1L;
}