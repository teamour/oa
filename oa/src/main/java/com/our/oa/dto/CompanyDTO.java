package com.our.oa.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

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
public class CompanyDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Integer companyId;
	
	@NotEmpty
	@Size(max=100)
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
}
