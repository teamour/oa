package com.our.oa.dao;

import com.our.oa.entity.DictionaryDetail;
import java.util.List;

/**
* Created by Mybatis Generator on 2019/03/31
*/
public interface DictionaryDetailMapper {
    int deleteByPrimaryKey(Integer detailId);

    int insert(DictionaryDetail record);

    DictionaryDetail selectByPrimaryKey(Integer detailId);

    List<DictionaryDetail> selectAll();

    int updateByPrimaryKey(DictionaryDetail record);
}