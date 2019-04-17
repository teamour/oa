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
public class Sales implements Serializable {
    private Integer salesId;

    private Integer employeeSiteId;

    private String expectEnteryDate1;

    private String expectEnteryDate2;

    private String firstProject;

    private String secondProject;

    private String thirdProject;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;

    private Boolean deleteFlag;

    private static final long serialVersionUID = 1L;
}