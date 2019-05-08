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
public class DocumentInvoiceListDTO extends GridListDTO{
	private static final long serialVersionUID = 1L;
	
	private Integer invoiceDocumentId;

	private Integer customerId;

	private String customerAddress;

	private String customerCharge;

	private Integer companyId;

	private String payDeadline;

	private Integer unitPrice;

	private Integer templateId;

}
