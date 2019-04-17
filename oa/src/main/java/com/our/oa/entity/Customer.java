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
public class Customer implements Serializable {
    private Integer customerId;

    private String customerName;

    private String website;

    private Integer registeredCapital;

    private Integer employeeNumber;

    private Date establishDate;

    private Integer companyType;

    private String address;

    private String zipCode;

    private String ceo;

    private String mainBusiness;

    private String cooperationDirection;

    private Integer cooperationIntention;

    private Boolean isUpper;

    private String contactChannel;

    private String salesStaff;

    private String salesTelephone;

    private String salesEmail;

    private String skillRequire;

    private String proposal1Email;

    private String proposal1Handler;

    private String proposal2Email;

    private String proposal2Handler;

    private String proposal3Email;

    private String proposal3Handler;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;

    private Boolean deleteFlag;

    private static final long serialVersionUID = 1L;
}