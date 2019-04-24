package com.our.oa.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.our.oa.dao.DictionaryDetailMapper;
import com.our.oa.entity.DictionaryDetail;
import com.our.oa.service.DictionaryDetailService;

@Service
public class DictionaryDetailServiceImpl implements DictionaryDetailService {

	@Autowired
	private DictionaryDetailMapper mapper;
	
	@Override
	public String getListByPrimaryKey(Integer id, Integer v) {
		List<DictionaryDetail> list = mapper.getListByPrimaryKey(id);
		return list.get(v - 1).getDetailName();
	}
}
