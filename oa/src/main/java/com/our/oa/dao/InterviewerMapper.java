package com.our.oa.dao;

import java.util.List;

import com.our.oa.dto.list.InterviewerListQueryDTO;
import com.our.oa.entity.Company;
import com.our.oa.entity.Interviewer;
import com.our.oa.entity.InterviewerResume;

/**
* Created by Mybatis Generator on 2019/03/31
*/
public interface InterviewerMapper {
	int addInfoCommit(Interviewer interviewer);

	int deleteByPrimaryKey(Integer interviewerId);

    Interviewer selectByPrimaryKey(Integer interviewerId);

    List<Interviewer> selectAll();

    int updateByPrimaryKey(Interviewer record);

	List<Company> getCompanyIdAndName();

	List<Interviewer> getAllInterviewers();

	Interviewer checkCode(String code);

	Interviewer getDetailInfoById(int interviewerId);

	int updateInfoDo(Interviewer interviewer);

	int addResumeDo(InterviewerResume interviewerResume);

	Interviewer getInterviewerByInterviewerCode(String interviewerCode);

	List<Interviewer> getInterviewerBySearch(InterviewerListQueryDTO listqueryDTO);


}