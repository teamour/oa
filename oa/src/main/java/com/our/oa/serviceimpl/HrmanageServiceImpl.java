package com.our.oa.serviceimpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.our.oa.dao.InterviewerMapper;
import com.our.oa.entity.Company;
import com.our.oa.entity.Interviewer;
import com.our.oa.entity.InterviewerResume;
import com.our.oa.service.HrmanageService;

@Service
public class HrmanageServiceImpl implements HrmanageService{

	@Autowired
	private InterviewerMapper interviewerMapper;

	@Override
	public boolean addInfoCommit(Interviewer interviewer) {
		interviewer.setCreateTime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		return interviewerMapper.addInfoCommit(interviewer) > 0;
	}

	@Override
	public List<Company> getCompanyIdAndName() {
		return interviewerMapper.getCompanyIdAndName();
	}

	@Override
	public List<Interviewer> getInterviewerInfo() {
		return interviewerMapper.getInterviewerInfo();
	}

	@Override
	public int getCode() {
		Random random = new Random();
		int code = random.nextInt(89999)+10000;
		while(interviewerMapper.checkCode(code) != null) {
			code = random.nextInt(89999)+10000;
		}
		return  code;
	}

	@Override
	public Interviewer getDetailInfoById(int interviewerId) {
		return interviewerMapper.getDetailInfoById(interviewerId);
	}

	@Override
	public boolean updateInfoDo(Interviewer interviewer) {
		return interviewerMapper.updateInfoDo(interviewer) > 0;
	}

	@Override
	public boolean addResumeDo(int interviewerId, String resume) {
		InterviewerResume interviewerResume = new InterviewerResume();
		interviewerResume.setInterviewerId(interviewerId);
		interviewerResume.setCreateTime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		return interviewerMapper.addResumeDo(interviewerResume) > 0;
	}

	@Override
	public boolean getInterviewerByInterviewerCode(int interviewerCode) {
		return interviewerMapper.getInterviewerByInterviewerCode(interviewerCode) != null;
	}
	

}
