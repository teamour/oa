package com.our.oa.dao;

import com.our.oa.entity.Dictionary;
import java.util.List;

/**
* Created by Mybatis Generator on 2019/03/31
*/
public interface DictionaryMapper {
    int deleteByPrimaryKey(Integer dictId);

    int insert(Dictionary record);

    Dictionary selectByPrimaryKey(Integer dictId);

    List<Dictionary> selectAll();

    int updateByPrimaryKey(Dictionary record);
}