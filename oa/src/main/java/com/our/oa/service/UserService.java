package com.our.oa.service;


import com.our.oa.dto.form.UserDTO;

public interface UserService {
	
	Integer selectByEmail(UserDTO user);
	
	Integer save(UserDTO user);
	
	boolean valid(String param,Integer type);
}
