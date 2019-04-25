package com.our.oa.service;


import com.our.oa.entity.User;

public interface UserService {
	
	Integer selectByEmail(User user);
	
	Integer save(User user);
	
	boolean valid(String param,Integer type);
}
