package com.our.oa.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.our.oa.dao.InterviewerVisaHandleMapper;
import com.our.oa.dto.form.InterviewerVisaHandleDTO;
import com.our.oa.dto.list.InterviewerVisaHandleListDTO;
import com.our.oa.dto.list.InterviewerVisaHandleListQueryDTO;
import com.our.oa.service.VisaHandleService;
import com.our.oa.utils.ModelMapperUtils;

@Service
public class VisaHandleServiceImpl implements VisaHandleService{

	@Autowired
	private InterviewerVisaHandleMapper InterviewerVisaHandleMapper;

	@Override
	public List<InterviewerVisaHandleListDTO> getGridList(InterviewerVisaHandleListQueryDTO g) {
		List<InterviewerVisaHandleDTO> list = InterviewerVisaHandleMapper.selectAll();
		if(!list.isEmpty()) {
			return ModelMapperUtils.mapCollection(list, InterviewerVisaHandleListDTO.class);
		}
		return new ArrayList<InterviewerVisaHandleListDTO>();
	}




}
