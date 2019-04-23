package com.our.oa.dao;

import com.our.oa.entity.User;
import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
* Created by Mybatis Generator on 2019/03/31
*/
public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    User selectByPrimaryKey(Integer userId);

    List<User> selectAll();

    int updateByPrimaryKey(User record);
    
    int findByEP(@Param(value="email") String email,@Param(value="userPwd") String userPwd);
}