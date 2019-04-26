package com.our.oa.dao;

import com.github.pagehelper.Page;
import com.our.oa.dto.form.InterviewerVisaHandleDTO;
import com.our.oa.dto.list.InterviewerVisaHandleListDTO;
import com.our.oa.entity.InterviewerVisaHandle;

/**
* Created by Mybatis Generator on 2019/03/31
*/
public interface InterviewerVisaHandleMapper {
    int deleteByPrimaryKey(Integer visaHandleId);

    int insert(InterviewerVisaHandle record);

    InterviewerVisaHandle selectByPrimaryKey(Integer visaHandleId);

    Page<InterviewerVisaHandleListDTO> selectAll();

    int updateByPrimaryKey(InterviewerVisaHandle record);

	InterviewerVisaHandle getInterviewerVisaHandleByInterviewerId(int interviewerId);

	int modifyVisaInfo(InterviewerVisaHandleDTO interviewerVisaHandleDTO);

	int insertVisaInfo(InterviewerVisaHandleDTO visaHandleDTO);
	
}