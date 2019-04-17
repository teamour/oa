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
public class Project implements Serializable {
    private Integer projectId;

    private String projectName;

    private Integer customerId;

    private String settlementRange;

    private String siteAddress;

    private String payDeadline;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;

    private Boolean deleteFlag;

    private String projectDesc;

    private static final long serialVersionUID = 1L;
}