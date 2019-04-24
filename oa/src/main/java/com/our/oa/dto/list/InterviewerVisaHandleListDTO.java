package com.our.oa.dto.list;

import com.our.oa.dto.GridListDTO;
import com.our.oa.entity.Interviewer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
* Created by Mybatis Generator on 2019/03/31
*/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper=true)
@EqualsAndHashCode(callSuper=true)
public class InterviewerVisaHandleListDTO extends GridListDTO {
    private Integer visaHandleId;

    private Integer interviewerId;
    
    private Interviewer interviewer;

    private Byte materialPrepareSituation;

    private Byte mailingSituation;

    private Boolean applicationMaterial;

    private Boolean selfJapaneseResume;

    private Boolean checkResume;

    private String expectSubmitDate;

    private String actualSubmitDate;

    private Integer visaHandleHandler;

    private Integer noticeHandler;

    private Integer otherHandlerf;

    private Boolean isCompleted;

    private String createTime;

    private String updateTime;

    private String deleteTime;

    private Boolean deleteFlag;

    private String description;

    private static final long serialVersionUID = 1L;
}