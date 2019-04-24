package com.our.oa.serviceimpl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.our.oa.dao.EmployeeMapper;
import com.our.oa.dao.EmployeeSiteMapper;
import com.our.oa.dto.form.EmployeeDTO;
import com.our.oa.dto.form.EmployeeSiteDTO;
import com.our.oa.dto.list.AnnouncementListDTO;
import com.our.oa.dto.list.EmployeeListDTO;
import com.our.oa.dto.list.EmployeeListQueryDTO;
import com.our.oa.entity.Employee;
import com.our.oa.entity.EmployeeSite;
import com.our.oa.service.EmployeeService;
import com.our.oa.utils.ModelMapperUtils;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	
	@Autowired
	private EmployeeMapper employeeMapper;
	@Autowired
	private EmployeeSiteMapper employeeSiteMapper;
	
	@Override
	public int insert(EmployeeDTO employee,EmployeeSiteDTO employeeSite) {
		  	 int rows = employeeMapper.insert(employee);
		  	 int lastId = employeeMapper.findNowId();//employee表添加的最新id
		  	 employeeSite.setEmployeeId(lastId);
		  	 employeeSiteMapper.insert(employeeSite);
			 return rows;
	}

	@Override
	public List<Employee> findAll() {
		List<Employee> list = employeeMapper.selectAll();
		return list;
	}

	@Override
	public Page<EmployeeListDTO> getGridList(EmployeeListQueryDTO g) {
		/*
		 * List<Employee> queryResult = employeeMapper.selectQueryList(g);
		 * if(!queryResult.isEmpty()) { return
		 * ModelMapperUtils.mapCollection(queryResult, EmployeeListDTO.class); } return
		 * new ArrayList<EmployeeListDTO>();
		 */
		 Page<EmployeeListDTO> queryResult = employeeMapper.selectQueryList(g);
		 if(!queryResult.isEmpty()) {
			 return queryResult;
		 }	 
		 return new Page<>();
	}
	@Override
	public Employee getByPrimaryKey(Integer employeeId) {
		return employeeMapper.selectByPrimaryKey(employeeId);
	}

	@Override
	public EmployeeSite getByEmployeeId(Integer employeeId) {
		 return employeeSiteMapper.selectByPrimaryKey(employeeId);
	}

	@Override
	public void update(EmployeeDTO employee , EmployeeSiteDTO emplyoeeSite ) {
		
		 employeeMapper.updateByEmployeeId(employee);
		 employeeSiteMapper.updateByEmployeeId(emplyoeeSite);
	}

	@Override
	public List<Employee> getEmployeeForSyudy(){
		return employeeMapper.selectForStudy();
	}

	@Override
	public void deleteBydIds(Integer id) {
		employeeMapper.deleteById(id);
		employeeSiteMapper.deleteById(id);
	}
	

}
