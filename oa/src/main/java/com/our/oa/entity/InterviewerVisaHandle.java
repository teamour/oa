package com.our.oa.entity;

import java.io.Serializable;
import java.util.Date;
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
public class InterviewerVisaHandle implements Serializable {
    private Integer visaHandleId;

    private Integer interviewerId;

    private Byte materialPrepareSituation;

    private Byte mailingSituation;

    private Boolean applicationMaterial;

    private Boolean selfJapaneseResume;

    private Boolean checkResume;

    private Date expectSubmitDate;

    private Date actualSubmitDate;

    private Integer visaHandleHandler;

    private Integer noticeHandler;

    private Integer otherHandlerf;

    private Boolean isCompleted;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;

    private Boolean deleteFlag;

    private String description;

    private static final long serialVersionUID = 1L;
}