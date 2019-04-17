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
public class Company implements Serializable {
    private Integer companyId;

    private String companyName;

    private String companyCode;

    private String address;

    private String zipCode;

    private String email;

    private String telephone;

    private String website;

    private Boolean isBp;

    private String bankName;

    private String branchBank;

    private String bankNumber;

    private String bankDesc;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;

    private Boolean deleteFlag;

    private static final long serialVersionUID = 1L;
}