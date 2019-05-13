package com.our.oa.serviceimpl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.our.oa.dao.DocumentInvoiceMapper;
import com.our.oa.dto.form.DocumentInvoiceDTO;
import com.our.oa.dto.form.EmployeeStudyDTO;
import com.our.oa.dto.list.DocumentInvoiceListDTO;
import com.our.oa.dto.list.DocumentInvoiceListQueryDTO;
import com.our.oa.entity.DocumentInvoice;
import com.our.oa.entity.EmployeeStudy;
import com.our.oa.service.DocumentInvoiceService;

@Service
public class DocumentInvoiceServiceImpl implements DocumentInvoiceService{

	@Autowired
	private DocumentInvoiceMapper documentInvoiceMapper;
	
	@Override
	public List<DocumentInvoice> getDocumentInvoice() {
		return documentInvoiceMapper.selectAll();
	}
	
	@Override
	public Page<DocumentInvoiceListDTO> getGridList(DocumentInvoiceListQueryDTO g) {
		// TODO Auto-generated method stub
		Page<DocumentInvoiceListDTO> queryResult = documentInvoiceMapper.selectQueryList(g);
		if(!queryResult.isEmpty()) {
			return queryResult;
		}
		return new Page<>();
	}
	
	@Override
	public int insert(DocumentInvoiceDTO dto) {
		// TODO Auto-generated method stub
		ModelMapper modelMapper = new  ModelMapper();
		DocumentInvoice record = modelMapper.map(dto, DocumentInvoice.class);
		return documentInvoiceMapper.insert(record);
	}

	@Override
	public int deleteByUpdate(Integer invoiceDocumentId) {
		// TODO Auto-generated method stub
		documentInvoiceMapper.deleteByUpdate(invoiceDocumentId);
		return 0;
	}

	@Override
	public int update(DocumentInvoiceDTO dto) {
		// TODO Auto-generated method stub
		ModelMapper modelMapper = new  ModelMapper();
		DocumentInvoice record = modelMapper.map(dto, DocumentInvoice.class);
		return documentInvoiceMapper.updateByPrimaryKey(record);
	
	}

	@Override
	public DocumentInvoice getByPrimaryKey(Integer invoiceDocumentId) {
		// TODO Auto-generated method stub
		return documentInvoiceMapper.selectByPrimaryKey(invoiceDocumentId);
	}


}
