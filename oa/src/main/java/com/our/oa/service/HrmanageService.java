package com.our.oa.service;

import java.util.List;

import com.our.oa.entity.Company;
import com.our.oa.entity.Interviewer;

public interface HrmanageService {

	boolean addInfoCommit(Interviewer interviewer);

	List<Company> getCompanyIdAndName();

	List<Interviewer> getInterviewerInfo();

	int getCode();

	Interviewer getDetailInfoById(int interviewerId);

	boolean updateInfoDo(Interviewer interviewer);

	boolean addResumeDo(int interviewerId, String resume);

	boolean getInterviewerByInterviewerCode(int interviewerCode);

	
}
