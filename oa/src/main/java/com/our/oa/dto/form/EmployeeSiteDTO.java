package com.our.oa.dto.form;

import java.io.Serializable;
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
public class EmployeeSiteDTO implements Serializable{
		private static final long serialVersionUID = 1L;

		private Integer employeeSiteId;

	    private Integer employeeId;

	    private Integer projectId;

	    private Date expectEnterDate;

	    private Date enterDate;

	    private Date endDate;

	    private String salesStaff;

	    private String salesContact;

	    private String salesEmail;

	    private String officeClerk;

	    private String officeEmail;

	    private String settlementRange;

	    private Integer unitPrice;

	    private Boolean isNeedSalesStaff;

	    private String purchaseOrderFile;

	    private String invoiceFile;

	    private String paymentSite;

	    private String headOfficeClerk;

	    private Integer enterHandler;

	    private Boolean isEnd;

	    private Date createTime;

	    private Date updateTime;

	    private Date deleteTime;

	    private Boolean deleteFlag;

	    private String enterRecord;

	    private String description;

}
