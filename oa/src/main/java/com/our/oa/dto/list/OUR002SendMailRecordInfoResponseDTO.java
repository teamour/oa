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
public class OUR002SendMailRecordInfoResponseDTO extends GridListDTO {
	private static final long serialVersionUID = 1L;
	
	private Integer customerId;
	
	private Integer mailStats;
	
	private Date beginTime;
	
	private Date endTime;
	
	private String mailingAimSummary;
	
	private String mailingTempleteContent;
}
