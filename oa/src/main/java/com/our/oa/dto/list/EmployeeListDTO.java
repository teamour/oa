package com.our.oa.dto.list;

import java.util.Date;

import com.our.oa.dto.GridListDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper=true)
@EqualsAndHashCode(callSuper=true)
public class EmployeeListDTO extends GridListDTO{
private static final long serialVersionUID = 1L;
	
private Integer employeeId;

private String employeeName;

private Byte age;


private Integer maritalStatus;

private Integer companyId;

private Integer deptId;

private Integer position;

private String address;

private String theNearestStation;

private String telephone;

private Byte workingYears;

private Byte skill1Years;


private Byte skill2Years;


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


private Date createTime;


private String skillAnalysis;

private String skillGrowth;
}
