package com.our.oa.dao;

import com.our.oa.entity.DictionaryDetail;

import java.util.List;

/**
* Created by Mybatis Generator on 2019/03/31
*/
public interface DictionaryDetailMapper {
    List<DictionaryDetail> getDicListByDictId(Integer id);
    
    List<DictionaryDetail> getAll();
}