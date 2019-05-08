package com.our.oa.service;

import java.util.List;

import javax.validation.Valid;

import com.our.oa.dto.form.DocumentInvoiceDTO;
import com.our.oa.dto.list.DocumentInvoiceListDTO;
import com.our.oa.dto.list.DocumentInvoiceListQueryDTO;
import com.our.oa.entity.DocumentInvoice;


public interface DocumentInvoiceService  extends ListQueryService<DocumentInvoiceListDTO,DocumentInvoiceListQueryDTO>{
	
	List<DocumentInvoice> getDocumentInvoice();

	int insert( DocumentInvoiceDTO dto);

}
