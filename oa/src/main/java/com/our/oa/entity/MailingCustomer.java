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
public class MailingCustomer implements Serializable {
    private Integer mailingId;

    private Integer customerId;

    private Date sendTime;

    private Boolean sendResult;

    private static final long serialVersionUID = 1L;
}