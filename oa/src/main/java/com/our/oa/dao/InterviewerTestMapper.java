package com.our.oa.dao;

import java.util.List;

import com.our.oa.dto.form.InterviewerTestDTO;
import com.our.oa.entity.InterviewerTest;

/**
* Created by Mybatis Generator on 2019/03/31
*/
public interface InterviewerTestMapper {
    int deleteByPrimaryKey(Integer testId);

    int insert(InterviewerTest record);

    InterviewerTest selectByPrimaryKey(Integer testId);

    int updateByPrimaryKey(InterviewerTest record);

	List<InterviewerTestDTO> getAll();
}