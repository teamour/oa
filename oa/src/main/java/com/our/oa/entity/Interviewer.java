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
public class Interviewer implements Serializable {
    private Integer interviewerId;

    private String interviewerCode;

    private String interviewerName;

    private Boolean interviewResult;

    private Date interview1Time;

    private Boolean interview1Result;

    private Integer interview1Handler;

    private Byte gender;

    private Byte age;

    private String city;

    private Integer japaneseSocre;

    private String graduatedSchool;

    private String profession;

    private Date graduatedDate;

    private Integer education;

    private String certificate;

    private Byte manner;

    private String familySituation;

    private Integer serviceSituation;

    private String nationality;

    private String birthplace;

    private Integer maritalStatus;

    private Integer expectSalary;

    private String friendshipSituationInJapan;

    private Date interview2Time;

    private Boolean interview2Result;

    private Integer interview2Handler;

    private String internshipExperience;

    private Integer skillScore;

    private Date interview3Time;

    private Boolean interview3Result;

    private Integer interview3Handler;

    private String prev1CompanyName;

    private String prev2CompanyName;

    private String prev3CompanyName;

    private String prev4CompanyName;

    private String prev5CompanyName;

    private Integer workIntent;

    private Integer companyId;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;

    private Boolean deleteFlag;

    private String japaneseConversationAbility;

    private String personnelDeptFeedback;

    private String interview1Desc;

    private String personalSituation;

    private String workingSituation;

    private String interview2Desc;

    private String technicalDepartmentFeedback;

    private String interview3Desc;

    private static final long serialVersionUID = 1L;
}