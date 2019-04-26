package com.our.oa.serviceimpl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.our.oa.dao.InterviewerVisaHandleMapper;
import com.our.oa.dto.form.InterviewerVisaHandleDTO;
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

	@Override
	public boolean insertVisaInfo(InterviewerVisaHandleDTO visaHandleDTO,int getInterviewerId) {
		if(getInterviewerId == 0) {
			return false;
		}
		visaHandleDTO.setInterviewerId(getInterviewerId);
		visaHandleDTO.setCreateTime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		return InterviewerVisaHandleMapper.insertVisaInfo(visaHandleDTO) > 0;
	}




}
