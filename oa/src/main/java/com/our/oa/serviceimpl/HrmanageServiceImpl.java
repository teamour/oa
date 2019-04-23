package com.our.oa.serviceimpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.our.oa.dao.InterviewerMapper;
import com.our.oa.dao.InterviewerVisaHandleMapper;
import com.our.oa.dto.form.InterviewerDTO;
import com.our.oa.dto.form.InterviewerVisaHandleDTO;
import com.our.oa.dto.list.InterviewerListDTO;
import com.our.oa.dto.list.InterviewerListQueryDTO;
import com.our.oa.entity.Company;
import com.our.oa.entity.Interviewer;
import com.our.oa.entity.InterviewerResume;
import com.our.oa.entity.InterviewerVisaHandle;
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
	public InterviewerVisaHandle getInterviewerVisaHandleByInterviewerId(int interviewerId) {
		return InterviewerVisaHandleMapper.getInterviewerVisaHandleByInterviewerId(interviewerId);
	}

	@Override
	public List<InterviewerListDTO> getGridList(InterviewerListQueryDTO g) {
		List<Interviewer> list = null;
		if(g.getInterviewerName() == null || g.getInterviewerName() == "") {
			 list = interviewerMapper.getAllInterviewers();
		}else{
			list = interviewerMapper.getInterviewerBySearch(g);
		}
		if(!list.isEmpty()) {
			return ModelMapperUtils.mapCollection(list, InterviewerListDTO.class);
		}
		return new ArrayList<InterviewerListDTO>();
	}

	@Override
	public boolean modifyVisaInfo(InterviewerVisaHandleDTO interviewerVisaHandleDTO) {
		interviewerVisaHandleDTO.setUpdateTime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		return InterviewerVisaHandleMapper.modifyVisaInfo(interviewerVisaHandleDTO) > 0;
	}


}
