package com.our.oa.dto.form;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmployeeDTO implements Serializable{
	private Integer employeeId;

    private String employeeName;

    private Byte gender;

    private Byte age;

    private Date birthday;

    private Integer maritalStatus;//婚姻状况

    private Integer companyId;//所属公司

    private Integer deptId;//部门ID
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date enterDate;

    private Integer position;//职称

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
    
    private String skillScoreStr;

    private String skillLevel;

    private String japaneseLevel;

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
