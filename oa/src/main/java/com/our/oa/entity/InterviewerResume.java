package com.our.oa.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
* Created by Mybatis Generator on 2019/03/31
*/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class InterviewerResume implements Serializable {
    private Integer resumeId;

    private Integer interviewerId;

    private String resumeTitle;

    private String resumeFile;

    private String createTime;

    private String updateTime;

    private String deleteTime;

    private Boolean deleteFlag;

    private static final long serialVersionUID = 1L;
}