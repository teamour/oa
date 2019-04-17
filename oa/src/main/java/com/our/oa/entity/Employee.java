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
public class Employee implements Serializable {
    private Integer employeeId;

    private String employeeName;

    private Byte gender;

    private Byte age;

    private Date birthday;

    private Integer maritalStatus;

    private Integer companyId;

    private Integer deptId;

    private Date enterDate;

    private Integer position;

    private String address;

    private String theNearestStation;

    private String telephone;

    private Byte workingYears;

    private Integer skill1;

    private Byte skill1Years;

    private Integer skill2;

    private Byte skill2Years;

    private Integer skill3;

    private Byte skill3Years;

    private Byte skillScore;

    private Integer skillLevel;

    private Integer japaneseLevel;

    private Integer salary;

    private String bankName;

    private String branchBank;

    private String bankNumber;

    private String bankDesc;

    private String domesticAddress;

    private Byte familySupport;

    private Integer contractFormat;

    private Boolean employmentInsurance;

    private Boolean annuity;

    private Boolean healthInsurance;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;

    private Boolean deleteFlag;

    private String skillAnalysis;

    private String skillGrowth;

    private static final long serialVersionUID = 1L;
}