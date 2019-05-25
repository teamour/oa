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
public class SalesRecord implements Serializable {
    private Integer salesRecordId;

    private Integer salesId;

    private Integer salesHandler;

    private String interviewDate;

    private String interviewTime;

    private Byte priority;

    private String interviewAddress;

    private Integer interviewFrequency;

    private Integer projectId;

    private Date enterDate;

    private String notice1;

    private String notice2;

    private Boolean isDone;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;

    private Boolean deleteFlag;
    
    private Customer customer;
    
    private Project project;

    private static final long serialVersionUID = 1L;
}