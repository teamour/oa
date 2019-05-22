package com.our.oa.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.our.oa.dao.EmployeeSiteMapper;
import com.our.oa.dto.form.EmployeeSiteDTO;
import com.our.oa.service.EmployeeSiteService;

@Service
public class EmployeeSiteServiceImpl implements EmployeeSiteService {
	
	@Autowired
	private EmployeeSiteMapper employeeMapper;
	@Override
	public void update(EmployeeSiteDTO emplyoeeSite) {
		 employeeMapper.updateByEmployeeId(emplyoeeSite);

	}
	@Override
	public List<Integer> getIds() {
		List<Integer> list=employeeMapper.NoNeedSalesStaffIds();
		return list;
	}

}
