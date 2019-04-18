package com.our.oa.entity;

import java.io.Serializable;

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

    private int interviewResult;

    private String interview1Time;

    private int interview1Result;

    private String interview1Handler;

    private int gender;

    private int age;

    private String city;

    private int japaneseSocre;

    private String graduatedSchool;

    private String profession;

    private String graduatedDate;

    private int education;

    private String certificate;

    private int manner;

    private String familySituation;

    private int serviceSituation;

    private String nationality;

    private String birthplace;

    private int maritalStatus;

    private int expectSalary;

    private String friendshipSituationInJapan;

    private String interview2Time;

    private int interview2Result;

    private String interview2Handler;

    private String internshipExperience;

    private int skillScore;

    private String interview3Time;

    private int interview3Result;

    private String interview3Handler;

    private String prev1CompanyName;

    private String prev2CompanyName;

    private String prev3CompanyName;

    private String prev4CompanyName;

    private String prev5CompanyName;

    private int workIntent;

    private int companyId;

    private String createTime;

    private String updateTime;

    private String deleteTime;

    private int deleteFlag;

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