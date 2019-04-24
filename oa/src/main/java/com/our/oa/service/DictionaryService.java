package com.our.oa.service;

import com.our.oa.dto.form.DictionaryDTO;

public interface DictionaryService {
	DictionaryDTO getByPrimaryKey(Integer id);
}
