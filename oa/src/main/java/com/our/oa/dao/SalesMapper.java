package com.our.oa.dao;

import com.our.oa.entity.Sales;
import java.util.List;

/**
* Created by Mybatis Generator on 2019/03/31
*/
public interface SalesMapper {
    int deleteByPrimaryKey(Integer salesId);

    int insert(Sales record);

    Sales selectByPrimaryKey(Integer salesId);

    List<Sales> selectAll();

    int updateByPrimaryKey(Sales record);
}