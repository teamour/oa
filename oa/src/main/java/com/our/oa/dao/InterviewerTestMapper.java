package com.our.oa.dao;

import com.github.pagehelper.Page;
import com.our.oa.dto.form.InterviewerTestDTO;
import com.our.oa.dto.list.InterviewerTestListDTO;
import com.our.oa.entity.InterviewerTest;

/**
* Created by Mybatis Generator on 2019/03/31
*/
public interface InterviewerTestMapper {
    int deleteByPrimaryKey(Integer testId);

    int insert(InterviewerTest record);

    InterviewerTest selectByPrimaryKey(Integer testId);

    int updateByPrimaryKey(InterviewerTest record);

	Page<InterviewerTestListDTO> getAll();

	InterviewerTest selectInterviewerTestInfoByInterviewerCode(String interviewerCode);

	InterviewerTest selectInterviewerTestInfoByTestId(int testId);

	int modifyTestInfo(InterviewerTestDTO testInfo);

	int addTestInfo(InterviewerTestDTO testDTO);

}