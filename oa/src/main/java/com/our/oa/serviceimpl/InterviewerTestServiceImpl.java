package com.our.oa.serviceimpl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.our.oa.dao.InterviewerTestMapper;
import com.our.oa.dto.form.InterviewerTestDTO;
import com.our.oa.dto.list.InterviewerTestListDTO;
import com.our.oa.dto.list.InterviewerTestListQueryDTO;
import com.our.oa.service.InterviewerTestService;

@Service
public class InterviewerTestServiceImpl implements InterviewerTestService{

	@Autowired
	private InterviewerTestMapper interviewerTestMapper;
	
	@Override
	public Page<InterviewerTestListDTO> getGridList(InterviewerTestListQueryDTO g) {
		Page<InterviewerTestListDTO> queryResult = interviewerTestMapper.getAll();
		if(!queryResult.isEmpty()) {
			return queryResult;
		}
		return new Page<>();
	}

	@Override
	public InterviewerTestDTO selectInterviewerTestInfoByInterviewerCode(String interviewerCode) {
		return new ModelMapper().map(interviewerTestMapper.selectInterviewerTestInfoByInterviewerCode(interviewerCode), InterviewerTestDTO.class);
	}

	@Override
	public InterviewerTestDTO selectInterviewerTestInfoByTestId(int testId) {
		return new ModelMapper().map(interviewerTestMapper.selectInterviewerTestInfoByTestId(testId), InterviewerTestDTO.class);
	}

	@Override
	public boolean modifyTestInfo(InterviewerTestDTO testInfo) {
		testInfo.setUpdateTime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		return interviewerTestMapper.modifyTestInfo(testInfo) > 0;
	}

	@Override
	public boolean addTestInfo(InterviewerTestDTO testDTO) {
		testDTO.setCreateTime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		return interviewerTestMapper.addTestInfo(testDTO) > 0;
	}

}
