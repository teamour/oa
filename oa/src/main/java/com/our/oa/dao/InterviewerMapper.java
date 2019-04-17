package com.our.oa.dao;

import com.our.oa.entity.Interviewer;
import java.util.List;

/**
* Created by Mybatis Generator on 2019/03/31
*/
public interface InterviewerMapper {
    int deleteByPrimaryKey(Integer interviewerId);

    int insert(Interviewer record);

    Interviewer selectByPrimaryKey(Integer interviewerId);

    List<Interviewer> selectAll();

    int updateByPrimaryKey(Interviewer record);
}