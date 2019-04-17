package com.our.oa.dao;

import com.our.oa.entity.Action;
import java.util.List;

/**
* Created by Mybatis Generator on 2019/03/31
*/
public interface ActionMapper {
    int deleteByPrimaryKey(Integer actionId);

    int insert(Action record);

    Action selectByPrimaryKey(Integer actionId);

    List<Action> selectAll();

    int updateByPrimaryKey(Action record);
}