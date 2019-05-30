package com.our.oa.dao;

import com.github.pagehelper.Page;
import com.our.oa.dto.form.UserDTO;
import com.our.oa.dto.list.UserListDTO;
import com.our.oa.dto.list.UserListQueryDTO;
import com.our.oa.entity.User;

/**
* Created by Mybatis Generator on 2019/03/31
*/
public interface UserMapper {
    
    Page<UserListDTO> selectQueryList(UserListQueryDTO queryDTO);

	void insert(UserDTO form);
    
	int checkByUserName(String username);
	
	User findByUserName(String username);
}