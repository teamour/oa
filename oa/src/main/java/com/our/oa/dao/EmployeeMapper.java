package com.our.oa.dao;

import com.our.oa.entity.Employee;
import java.util.List;

/**
* Created by Mybatis Generator on 2019/03/31
*/
public interface EmployeeMapper {
    int deleteByPrimaryKey(Integer employeeId);

    int insert(Employee record);

    Employee selectByPrimaryKey(Integer employeeId);

    List<Employee> selectAll();

    int updateByPrimaryKey(Employee record);
}