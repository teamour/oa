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
public class DocumentInvoice implements Serializable {
    private Integer invoiceDocumentId;

    private Integer customerId;

    private String customerAddress;

    private String customerCharge;

    private Integer companyId;

    private String payDeadline;

    private Integer unitPrice;

    private Integer templateId;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;

    private Boolean deleteFlag;

    private static final long serialVersionUID = 1L;
}