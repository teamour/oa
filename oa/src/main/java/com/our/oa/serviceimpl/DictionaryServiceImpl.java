package com.our.oa.serviceimpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.our.oa.dao.DictionaryMapper;
import com.our.oa.dto.form.DictionaryDTO;
import com.our.oa.entity.Dictionary;
import com.our.oa.service.DictionaryService;

@Service
public class DictionaryServiceImpl implements DictionaryService {

	@Autowired
	private DictionaryMapper mapper;
	
	@Override
	public DictionaryDTO getByPrimaryKey(Integer id) {
		ModelMapper modelMapper = new ModelMapper();
		Dictionary entity = mapper.selectByPrimaryKey(id);
		DictionaryDTO record = modelMapper.map(entity, DictionaryDTO.class);
		return record;
	}

}
