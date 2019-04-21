package com.our.oa.dto.list;

import java.util.Date;

import com.our.oa.dto.GridListDTO;

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
public class CompanyListDTO extends GridListDTO {

	private static final long serialVersionUID = 1L;
	
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

}
