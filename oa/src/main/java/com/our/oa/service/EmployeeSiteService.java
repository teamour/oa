package com.our.oa.service;

import java.util.List;

import com.our.oa.dto.form.EmployeeSiteDTO;

public interface EmployeeSiteService {
	void update(EmployeeSiteDTO emplyoeeSite);
	
	List<Integer> getIds();
}
