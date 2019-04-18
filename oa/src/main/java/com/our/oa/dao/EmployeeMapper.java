package com.our.oa.dao;

import com.our.oa.dto.form.EmployeeDTO;
import com.our.oa.dto.list.EmployeeListQueryDTO;
import com.our.oa.entity.Employee;
import java.util.List;


/**
* Created by Mybatis Generator on 2019/03/31
*/
public interface EmployeeMapper {
    int deleteByPrimaryKey(Integer employeeId);

    int insert(EmployeeDTO employee);

    Employee selectByPrimaryKey(Integer employeeId);

    List<Employee> selectAll();

    int updateByPrimaryKey(Employee record);
	
	int findNowId();
	
	List<Employee> selectQueryList(EmployeeListQueryDTO queryDTO);
	
}