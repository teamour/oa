package com.our.oa.dto.form;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

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
public class CustomerDTO implements Serializable {
	
	private Integer customerId;

	private String customerName;

	private String website;

	private Integer registeredCapital;

	private Integer employeeNumber;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date establishDate;

	private Integer companyType;
	
	private String companyTypeStr;

	private String address;

	private String zipCode;

	private String ceo;

	private String mainBusiness;

	private String cooperationDirection;

	private Integer cooperationIntention;
	
	private String cooperationIntentionStr;

	private Boolean isUpper;
	
	private String isUpperStr;

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

	private static final long serialVersionUID = 1L;
}
