package com.our.oa.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.our.oa.dao.InterviewerTestMapper;
import com.our.oa.dto.form.InterviewerTestDTO;
import com.our.oa.dto.list.InterviewerTestListDTO;
import com.our.oa.dto.list.InterviewerTestListQueryDTO;
import com.our.oa.entity.InterviewerTest;
import com.our.oa.service.InterviewerTestService;
import com.our.oa.utils.ModelMapperUtils;

@Service
public class InterviewerTestServiceImpl implements InterviewerTestService{

	@Autowired
	private InterviewerTestMapper interviewerTestMapper;
	
	@Override
	public List<InterviewerTestListDTO> getGridList(InterviewerTestListQueryDTO g) {
		List<InterviewerTest> list = interviewerTestMapper.getAll();
		if(!list.isEmpty()) {
			return ModelMapperUtils.mapCollection(list, InterviewerTestListDTO.class);
		}
		return new ArrayList<InterviewerTestListDTO>();
	}

	@Override
	public InterviewerTestDTO selectInterviewerTestInfoByInterviewerCode(String interviewerCode) {
		return new ModelMapper().map(interviewerTestMapper.selectInterviewerTestInfoByInterviewerCode(interviewerCode), InterviewerTestDTO.class);
	}

	@Override
	public InterviewerTestDTO selectInterviewerTestInfoByTestId(int testId) {
		return new ModelMapper().map(interviewerTestMapper.selectInterviewerTestInfoByTestId(testId), InterviewerTestDTO.class);
	}

}
