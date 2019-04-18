package com.our.oa.dao;

import com.our.oa.entity.Company;
import com.our.oa.entity.Interviewer;
import com.our.oa.entity.InterviewerResume;

import java.util.List;

/**
* Created by Mybatis Generator on 2019/03/31
*/
public interface InterviewerMapper {
	int deleteByPrimaryKey(Integer interviewerId);

    int addInfoCommit(Interviewer interviewer);

    Interviewer selectByPrimaryKey(Integer interviewerId);

    List<Interviewer> selectAll();

    int updateByPrimaryKey(Interviewer record);

	List<Company> getCompanyIdAndName();

	List<Interviewer> getInterviewerInfo();

	Interviewer checkCode(int code);

	Interviewer getDetailInfoById(int interviewerId);

	int updateInfoDo(Interviewer interviewer);

	int addResumeDo(InterviewerResume interviewerResume);

	Interviewer getInterviewerByInterviewerCode(int interviewerCode);

}