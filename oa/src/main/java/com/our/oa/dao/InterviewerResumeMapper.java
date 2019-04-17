package com.our.oa.dao;

import com.our.oa.entity.InterviewerResume;
import java.util.List;

/**
* Created by Mybatis Generator on 2019/03/31
*/
public interface InterviewerResumeMapper {
    int deleteByPrimaryKey(Integer resumeId);

    int insert(InterviewerResume record);

    InterviewerResume selectByPrimaryKey(Integer resumeId);

    List<InterviewerResume> selectAll();

    int updateByPrimaryKey(InterviewerResume record);
}