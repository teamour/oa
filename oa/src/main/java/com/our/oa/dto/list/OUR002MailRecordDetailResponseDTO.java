package com.our.oa.dto.list;

import java.util.Date;

import javax.mail.search.IntegerComparisonTerm;

import com.our.oa.dto.GridListQueryBaseDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper=true)
@EqualsAndHashCode(callSuper=true)
public class OUR002MailRecordDetailResponseDTO extends GridListQueryBaseDTO{
	
	private static final long serialVersionUID = 1L;
	
	private Integer mailingId;

    private Integer customerId;

    private Date sendTime;

    private Boolean sendResult;
    
    //公司名字
    private String customerName;
    
    private String sendMailAddress;
    
    
    private String sendCustomerName;
}
