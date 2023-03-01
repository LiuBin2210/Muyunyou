package com.abin.demo.db.dao;

import com.abin.demo.db.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 部门
 *
 * @author 啊斌
 * @date 2023/02/25
 */
@Mapper
public interface DeptDao {

    /**
     * 搜索部门页面
     *
     * @param param 参数
     * @return {@link ArrayList}<{@link HashMap}>
     */
    ArrayList<HashMap> searchDeptByPage(HashMap param);

    /**
     * 搜索部门数
     *
     * @param param 参数
     * @return long
     */
    long searchDeptCount(HashMap param);

    /**
     * 插入
     *
     * @param dept 部门
     * @return int
     */
    int insert(Dept dept);

}
