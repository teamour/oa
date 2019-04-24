package com.our.oa.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.our.oa.dao.InterviewerVisaHandleMapper;
import com.our.oa.dto.list.InterviewerVisaHandleListDTO;
import com.our.oa.dto.list.InterviewerVisaHandleListQueryDTO;
import com.our.oa.service.VisaHandleService;

@Service
public class VisaHandleServiceImpl implements VisaHandleService{

	@Autowired
	private InterviewerVisaHandleMapper InterviewerVisaHandleMapper;

	@Override
	public Page<InterviewerVisaHandleListDTO> getGridList(InterviewerVisaHandleListQueryDTO g) {
		Page<InterviewerVisaHandleListDTO> queryResult = InterviewerVisaHandleMapper.selectAll();
		if(!queryResult.isEmpty()) {
			return queryResult;
		}
		return new Page<>();
	}




}
