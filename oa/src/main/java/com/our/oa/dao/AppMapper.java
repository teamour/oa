package com.our.oa.dao;

import com.our.oa.entity.App;
import java.util.List;

/**
* Created by Mybatis Generator on 2019/03/31
*/
public interface AppMapper {
    int deleteByPrimaryKey(Integer appId);

    int insert(App record);

    App selectByPrimaryKey(Integer appId);

    List<App> selectAll();

    int updateByPrimaryKey(App record);
}