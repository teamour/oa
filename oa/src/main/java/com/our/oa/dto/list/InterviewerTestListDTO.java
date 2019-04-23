package com.our.oa.dto.list;

import com.our.oa.dto.GridListDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
* Created by Mybatis Generator on 2019/03/31
*/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper=true)
@EqualsAndHashCode(callSuper=true)
public class InterviewerTestListDTO extends GridListDTO {
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

    private String createTime;

    private Boolean deleteFlag;

    private String skillAbility;

    private String description;

    private static final long serialVersionUID = 1L;
}