package com.our.oa.service;

import java.util.List;
import java.util.Map;

import com.our.oa.dto.list.OUR001SendMailCustomerInfoRequestDTO;
import com.our.oa.dto.list.OUR001SendMailCustomerInfoResponseDTO;

public interface OUR001MailOperationService extends ListQueryService<OUR001SendMailCustomerInfoResponseDTO, OUR001SendMailCustomerInfoRequestDTO>{

	List<OUR001SendMailCustomerInfoResponseDTO> getSendMailCustomerInfoOUR001(OUR001SendMailCustomerInfoRequestDTO requestDTO);
	
	boolean sendMailToCustomerOUR001(Map<String, Object> requestDTO);
	
}
