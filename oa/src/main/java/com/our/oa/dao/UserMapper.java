package com.our.oa.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.our.oa.dto.form.UserDTO;
import com.our.oa.entity.User;

/**
* Created by Mybatis Generator on 2019/03/31
*/
public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    User selectByPrimaryKey(Integer userId);

    List<User> selectAll();

    int updateByPrimaryKey(User record);
    
    int findByEP(UserDTO user);
    
    int insert(UserDTO user);
    
    int findCheckUser(@Param("cloumn")String cloumn,@Param("param")String param);
    
    User queryByUserName(String username);
}