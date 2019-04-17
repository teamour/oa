package com.our.oa.dao;

import com.our.oa.entity.Project;
import java.util.List;

/**
* Created by Mybatis Generator on 2019/03/31
*/
public interface ProjectMapper {
    int deleteByPrimaryKey(Integer projectId);

    int insert(Project record);

    Project selectByPrimaryKey(Integer projectId);

    List<Project> selectAll();

    int updateByPrimaryKey(Project record);
}