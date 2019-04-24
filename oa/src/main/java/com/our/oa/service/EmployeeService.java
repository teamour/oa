package com.our.oa.service;

import java.util.List;

import com.github.pagehelper.Page;
import com.our.oa.dto.form.EmployeeDTO;
import com.our.oa.dto.form.EmployeeSiteDTO;
import com.our.oa.dto.list.EmployeeListDTO;
import com.our.oa.dto.list.EmployeeListQueryDTO;
import com.our.oa.entity.Employee;
import com.our.oa.entity.EmployeeSite;

public interface EmployeeService extends ListQueryService<EmployeeListDTO,EmployeeListQueryDTO>{
	
	 int insert(EmployeeDTO employee,EmployeeSiteDTO employeeSite) ;

	 List<Employee> findAll();

	 Page<EmployeeListDTO> getGridList(EmployeeListQueryDTO g) ;
	
	 Employee getByPrimaryKey(Integer employeeId) ;

	 EmployeeSite getByEmployeeId(Integer employeeId);

	 void update(EmployeeDTO employee ) ;

	 List<Employee> getEmployeeForSyudy();

	 void deleteBydIds(Integer id) ;
	 
}
