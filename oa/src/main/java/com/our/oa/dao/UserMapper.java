package com.our.oa.dao;

import com.our.oa.entity.User;

/**
* Created by Mybatis Generator on 2019/03/31
*/
public interface UserMapper {
	
    User queryByUserName(String username);
    
}