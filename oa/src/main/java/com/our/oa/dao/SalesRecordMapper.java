package com.our.oa.dao;

import com.our.oa.entity.SalesRecord;
import java.util.List;

/**
* Created by Mybatis Generator on 2019/03/31
*/
public interface SalesRecordMapper {
    int deleteByPrimaryKey(Integer salesRecordId);

    int insert(SalesRecord record);

    SalesRecord selectByPrimaryKey(Integer salesRecordId);

    List<SalesRecord> selectAll();

    int updateByPrimaryKey(SalesRecord record);
}