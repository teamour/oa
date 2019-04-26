package com.our.oa.service;

import com.our.oa.dto.form.InterviewerVisaHandleDTO;
import com.our.oa.dto.list.InterviewerVisaHandleListDTO;
import com.our.oa.dto.list.InterviewerVisaHandleListQueryDTO;

public interface VisaHandleService extends ListQueryService<InterviewerVisaHandleListDTO, InterviewerVisaHandleListQueryDTO>{

	boolean insertVisaInfo(InterviewerVisaHandleDTO visaHandleDTO, int getInterviewerId);

}
