package com.our.oa.dao;

import com.our.oa.entity.InterviewerVisaHandle;
import java.util.List;

/**
* Created by Mybatis Generator on 2019/03/31
*/
public interface InterviewerVisaHandleMapper {
    int deleteByPrimaryKey(Integer visaHandleId);

    int insert(InterviewerVisaHandle record);

    InterviewerVisaHandle selectByPrimaryKey(Integer visaHandleId);

    List<InterviewerVisaHandle> selectAll();

    int updateByPrimaryKey(InterviewerVisaHandle record);

	InterviewerVisaHandle getInterviewerVisaHandleByInterviewerId(int interviewerId);
	
}