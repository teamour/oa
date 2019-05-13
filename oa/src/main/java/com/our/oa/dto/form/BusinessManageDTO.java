package com.our.oa.dto.form;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

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
public class BusinessManageDTO implements Serializable{
    //来源于表t_employee
    private Integer employeeId;//employeeid

    private String employeeName;//姓名

    private Byte workingYears;//工作年数
    
    private Integer japaneseLevel;//日语等级
    
    private String skillLevel;//技术等级

    private String skill1;//工作1

    private String skill2;//工作2

    private String skill3;//工作3

    private String theNearestStation;//最寄り駅

    private int skillScore;//技术评价（1-5星）

    private String skillAnalysis;//技术分析

    private String skillGrowth;//技术发展
    //来源于表t_project
    private Integer projectId;//项目id

    private String siteAddress;//現場場所

    private String projectName;//案件名

    private String projectDesc;//案件详细d

    //来源于表t_sales
    private String expectEnteryDate1;//希望入场日1

    private String expectEnteryDate2;//希望入场日2

    private String firstProject;//优先项目1

    private String secondProject;//优先项目2

    private String thirdProject;//优先项目3
    //来源于表t_sales_record
    private String salesHandler;//营业担当

    private Date interviewDate;//面试日期

    private Timestamp interviewTime;//面试时间

    private Byte priority;//优先度(1:低 2:中 3:高)

    private Integer interviewFrequency;//面试次数（对应字典表）

    private String interviewAddress;//面试地点

    private Date enterDate;//入场日

    private String notice1;//注意事项1

    private String notice2;//注意事项2
    //来源于表t_customer
    private Integer customerId;//客户编号

    private String customerName;//客户公司名称

    private String salesStaff;//客户营业担当

    private String salesTelephone;//客户营业电话

    private String salesEmail;//客户营业邮箱

    private static final long serialVersionUID = 1L;
}