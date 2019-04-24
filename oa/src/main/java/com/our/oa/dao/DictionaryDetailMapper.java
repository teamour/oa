package com.our.oa.dao;

import com.our.oa.entity.DictionaryDetail;

import java.util.List;

/**
* Created by Mybatis Generator on 2019/03/31
*/
public interface DictionaryDetailMapper {
    List<DictionaryDetail> getListByPrimaryKey(Integer id);
}