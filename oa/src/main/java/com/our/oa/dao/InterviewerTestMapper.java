package com.our.oa.dao;

import com.our.oa.entity.InterviewerTest;
import java.util.List;

/**
* Created by Mybatis Generator on 2019/03/31
*/
public interface InterviewerTestMapper {
    int deleteByPrimaryKey(Integer testId);

    int insert(InterviewerTest record);

    InterviewerTest selectByPrimaryKey(Integer testId);

    List<InterviewerTest> selectAll();

    int updateByPrimaryKey(InterviewerTest record);
}