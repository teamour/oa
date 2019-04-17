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
public class InterviewerTest implements Serializable {
    private Integer testId;

    private Integer interviewerId;

    private Integer handler1;

    private Integer handler2;

    private Integer testScore;

    private Boolean isPass;

    private String japaneseCertificate;

    private String englishCertificate;

    private String computerCertificate;

    private Integer japaneseListen;

    private Integer japaneseSpeak;

    private Integer japaneseRead;

    private Integer japaneseWrite;

    private Integer englishListen;

    private Integer englishSpeak;

    private Integer englishRead;

    private Integer englishWrite;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;

    private Boolean deleteFlag;

    private String skillAbility;

    private String description;

    private static final long serialVersionUID = 1L;
}