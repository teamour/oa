package com.our.oa.dto.list;

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
public class OUR001SendMailCustomerInfoResponseDTO extends GridListDTO {
	private static final long serialVersionUID = 1L;
	//客户编号
	private Integer customerId;
	//客户公司名称
	private String customerName;
	//营业邮箱
	private String salesEmail;
	//营业担当
	private String salesStaff;
	//提案用邮箱1
	private String proposal1Email;
	//提案用担当1
	private String proposal1Handler;
	//提案用邮箱2
	private String proposal2Email;
	//提案用担当2
	private String proposal2Handler;
	//提案用邮箱3
	private String proposal3Email;
	//提案用担当3
	private String proposal3Handler;
	
}
