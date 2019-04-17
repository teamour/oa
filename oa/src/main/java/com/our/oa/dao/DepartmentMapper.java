package com.our.oa.dao;

import com.our.oa.entity.Department;
import java.util.List;

/**
* Created by Mybatis Generator on 2019/03/31
*/
public interface DepartmentMapper {
    int deleteByPrimaryKey(Integer deptId);

    int insert(Department record);

    Department selectByPrimaryKey(Integer deptId);

    List<Department> selectAll();

    int updateByPrimaryKey(Department record);
}