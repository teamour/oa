package com.our.oa.dto.form;

import java.util.Date;

import com.our.oa.dto.FormDTO;
import com.our.oa.dto.form.EmployeeStudyDTO.EmployeeStudyDTOBuilder;

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
public class DocumentInvoiceDTO extends FormDTO{
	private static final long serialVersionUID = 1L;
	private Integer invoiceDocumentId;

    private Integer customerId;

    private String customerName;
    
    private String customerAddress;

    private String customerCharge;

    private Integer companyId;
    
    private String companyAddress;

    private String companyName;
    
    private String companyZipCode;
    
    private String companyTelephone;
    
    private String payDeadline;

    private Integer unitPrice;

    private Integer templateId;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;

    private Boolean deleteFlag;
}
