package com.our.oa.service;

import java.util.List;

import com.our.oa.dto.form.InterviewerDTO;
import com.our.oa.dto.list.InterviewerListDTO;
import com.our.oa.dto.list.InterviewerListQueryDTO;
import com.our.oa.entity.Company;
import com.our.oa.entity.Interviewer;
import com.our.oa.entity.InterviewerVisaHandle;

public interface HrmanageService extends ListQueryService<InterviewerListDTO, InterviewerListQueryDTO>{

	boolean addInfoCommit(InterviewerDTO interviewerInfoForm);

	List<Company> getCompanyIdAndName();

	List<Interviewer> getInterviewerInfo();

	String getCode();

	Interviewer getDetailInfoById(int interviewerId);

	boolean updateInfoDo(Interviewer interviewer);

	boolean addResumeDo(int interviewerId, String resume);

	Interviewer getInterviewerByInterviewerCode(String interviewerCode);

	InterviewerVisaHandle getInterviewerVisaHandleByInterviewerId(int interviewerId);

	
}
