package com.our.oa.service;

import java.util.List;

import com.our.oa.entity.DictionaryDetail;

public interface DictionaryService {
	String getDetailName(Integer dictId, Integer v);
	List<DictionaryDetail> getDetailNames(Integer dictId);
}
