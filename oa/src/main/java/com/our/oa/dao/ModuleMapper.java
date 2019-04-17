package com.our.oa.dao;

import com.our.oa.entity.Module;
import java.util.List;

/**
* Created by Mybatis Generator on 2019/03/31
*/
public interface ModuleMapper {
    int deleteByPrimaryKey(Integer moduleId);

    int insert(Module record);

    Module selectByPrimaryKey(Integer moduleId);

    List<Module> selectAll();

    int updateByPrimaryKey(Module record);
}