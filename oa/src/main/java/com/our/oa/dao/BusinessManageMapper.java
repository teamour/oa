package com.our.oa.dao;

import com.github.pagehelper.Page;
import com.our.oa.dto.form.EmployeeDTO;
import com.our.oa.dto.list.BusinessManageListDTO;
import com.our.oa.dto.list.BusinessManageListQueryDTO;
import com.our.oa.entity.Employee;
import java.util.List;


/**
* Created by Mybatis Generator on 2019/03/31
*/
public interface BusinessManageMapper {
    // int deleteByPrimaryKey(Integer employeeId);

    // int insert(EmployeeDTO employee);

    // Employee selectByPrimaryKey(Integer employeeId);

    // List<BusinessManageListDTO> selectAll();

    // int updateByPrimaryKey(Employee record);
	
	// int findNowId();
	
	Page<BusinessManageListDTO> selectQueryList(BusinessManageListQueryDTO queryDTO);
	
	// int updateByEmployeeId(EmployeeDTO employee);
	
	// // create BY wangjiaqin
	// List<Employee> selectForStudy();
	
	// int deleteById(Integer id);
	
	// int getEmployeeId(Integer employeeId);
}