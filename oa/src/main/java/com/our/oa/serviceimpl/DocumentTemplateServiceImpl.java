package com.our.oa.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.our.oa.dao.DocumentTemplateMapper;
import com.our.oa.entity.DocumentTemplate;
import com.our.oa.service.DocumentTemplateService;

@Service
public class DocumentTemplateServiceImpl implements DocumentTemplateService{
	@Autowired
	private DocumentTemplateMapper documentTemplateMapper;
	
	
	@Override
	public DocumentTemplate getByPrimaryKey(Integer templateId) {
		// TODO Auto-generated method stub
		return documentTemplateMapper.selectByPrimaryKey(templateId);
	}

}
