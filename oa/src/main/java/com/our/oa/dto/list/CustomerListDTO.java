package com.our.oa.dto.list;

import java.util.Date;

import com.our.oa.dto.GridListDTO;
import com.our.oa.dto.list.CompanyListDTO.CompanyListDTOBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper=true)
@EqualsAndHashCode(callSuper=true)
public class CustomerListDTO extends GridListDTO {
	
	private static final long serialVersionUID = 1L;
	
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


}
