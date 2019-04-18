package com.our.oa.serviceimpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.our.oa.dao.EmployeeMapper;
import com.our.oa.dao.EmployeeSiteMapper;
import com.our.oa.entity.Employee;
import com.our.oa.entity.EmployeeSite;
import com.our.oa.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	
	@Autowired
	private EmployeeMapper employeeMapper;
	@Autowired
	private EmployeeSiteMapper employeeSiteMapper;
	
	@Override
	public Integer insert(Employee employee, EmployeeSite employeeSite) {
		  	 employeeMapper.insert(employee);
			 int lastId = employeeMapper.findNowId();//employee表添加的最新id
			 employeeSite.setEmployeeId(lastId);
			 int rows = employeeSiteMapper.insert(employeeSite);
			return rows;
	}

	
	
	

}
