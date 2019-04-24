package com.our.oa.serviceimpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.our.oa.dao.InterviewerMapper;
import com.our.oa.dao.InterviewerVisaHandleMapper;
import com.our.oa.dto.form.InterviewerDTO;
import com.our.oa.dto.form.InterviewerVisaHandleDTO;
import com.our.oa.dto.list.InterviewerListDTO;
import com.our.oa.dto.list.InterviewerListQueryDTO;
import com.our.oa.entity.Company;
import com.our.oa.entity.Interviewer;
import com.our.oa.entity.InterviewerResume;
import com.our.oa.service.HrmanageService;
import com.our.oa.utils.ModelMapperUtils;

@Service
public class HrmanageServiceImpl implements HrmanageService{

	@Autowired
	private InterviewerMapper interviewerMapper;
	
	@Autowired
	private InterviewerVisaHandleMapper InterviewerVisaHandleMapper;

	@Override
	public boolean addInfoCommit(InterviewerDTO interviewerInfoForm) {
		Interviewer interviewer = ModelMapperUtils.getModelMapper().map(interviewerInfoForm, Interviewer.class);
		interviewer.setCreateTime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		return interviewerMapper.addInfoCommit(interviewer) > 0;
	}

	@Override
	public List<Company> getCompanyIdAndName() {
		return interviewerMapper.getCompanyIdAndName();
	}

	@Override
	public String getCode() {
		Random random = new Random();
		int num = random.nextInt(899)+100;
		String nowtime = new SimpleDateFormat("yyyyMMdd").format(new Date());
		String code = nowtime + num;
		while(interviewerMapper.checkCode(code) != null) {
			num = random.nextInt(899)+100;
			code = nowtime + num;
		}
		return  code;
	}

	@Override
	public Interviewer getDetailInfoById(int interviewerId) {
		return interviewerMapper.getDetailInfoById(interviewerId);
	}

	@Override
	public boolean updateInfoDo(Interviewer interviewer) {
		interviewer.setUpdateTime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
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
	public Interviewer getInterviewerByInterviewerCode(String interviewerCode) {
		return interviewerMapper.getInterviewerByInterviewerCode(interviewerCode);
	}

	@Override
	public InterviewerVisaHandleDTO getInterviewerVisaHandleByInterviewerId(int interviewerId) {
		return new ModelMapper().map(InterviewerVisaHandleMapper.getInterviewerVisaHandleByInterviewerId(interviewerId), InterviewerVisaHandleDTO.class);
	}

	@Override
	public Page<InterviewerListDTO> getGridList(InterviewerListQueryDTO g) {
		Page<InterviewerListDTO> queryResult = null;
		if(g.getInterviewerName() == null || g.getInterviewerName() == "") {
			queryResult = interviewerMapper.getAllInterviewers();
		}else{
			queryResult = interviewerMapper.getInterviewerBySearch(g);
		}
		if(!queryResult.isEmpty()) {
			return queryResult;
		}
		return new Page<>();
	}

	@Override
	public boolean modifyVisaInfo(InterviewerVisaHandleDTO interviewerVisaHandleDTO) {
		interviewerVisaHandleDTO.setUpdateTime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		return InterviewerVisaHandleMapper.modifyVisaInfo(interviewerVisaHandleDTO) > 0;
	}


}
