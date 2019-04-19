package com.our.oa.service;

import java.util.List;

import com.our.oa.dto.form.EmployeeDTO;
import com.our.oa.dto.form.EmployeeSiteDTO;
import com.our.oa.dto.list.EmployeeListDTO;
import com.our.oa.dto.list.EmployeeListQueryDTO;
import com.our.oa.entity.Employee;
import com.our.oa.entity.EmployeeSite;

public interface EmployeeService extends ListQueryService<EmployeeListDTO,EmployeeListQueryDTO>{
	
	int insert(EmployeeDTO emplyoee,EmployeeSiteDTO employeeSite);
	
	Employee getByPrimaryKey(Integer EmployeeId);
	
	EmployeeSite getByEmployeeId(Integer EmployeeId);
	
	List<Employee> findAll();
	
	int deleteBydIds(Integer... Ids);
	
	void update(EmployeeDTO employee ,EmployeeSiteDTO employeeSite );
	
	List<Employee> getEmployeeForSyudy();
}
