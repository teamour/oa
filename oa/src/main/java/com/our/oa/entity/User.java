package com.our.oa.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

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
public class User implements Serializable{
    private Integer userId;

    private String userName;

    private String userPwd;

    private String email;

    private Date loginTime;

    private Integer errorNumber;

    private String emailVerificationCode;

    private Date verificationCodeSendTime;

    private Integer employeeId;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;

    private Boolean deleteFlag;

    private static final long serialVersionUID = 1L;

}