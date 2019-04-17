package com.our.oa.dao;

import com.our.oa.entity.Role;
import java.util.List;

/**
* Created by Mybatis Generator on 2019/03/31
*/
public interface RoleMapper {
    int deleteByPrimaryKey(Integer roleId);

    int insert(Role record);

    Role selectByPrimaryKey(Integer roleId);

    List<Role> selectAll();

    int updateByPrimaryKey(Role record);
}