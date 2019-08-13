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
public class Mailing implements Serializable {
    private Integer mailingId;

    private String mailingAimSummary;

    private String beginTime;

    private String endTime;

    private Integer operator;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;

    private Boolean deleteFlag;
    
    private Integer mailStats;
    
    private Integer mailNumber;

    private String mailingTempleteContent;

    private static final long serialVersionUID = 1L;
}