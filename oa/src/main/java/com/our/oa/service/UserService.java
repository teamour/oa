package com.our.oa.service;

import com.our.oa.entity.User;

public interface UserService {
	
	Integer selectByEmail(User user);
	
}
