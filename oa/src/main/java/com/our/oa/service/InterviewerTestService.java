package com.our.oa.service;

import com.our.oa.dto.form.InterviewerTestDTO;
import com.our.oa.dto.list.InterviewerTestListDTO;
import com.our.oa.dto.list.InterviewerTestListQueryDTO;

public interface InterviewerTestService extends ListQueryService<InterviewerTestListDTO, InterviewerTestListQueryDTO>{

	InterviewerTestDTO selectInterviewerTestInfoByInterviewerCode(String interviewerCode);

	InterviewerTestDTO selectInterviewerTestInfoByTestId(int testId);

}
