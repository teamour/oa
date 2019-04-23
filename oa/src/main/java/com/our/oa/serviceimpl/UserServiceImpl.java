package com.our.oa.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.our.oa.dao.UserMapper;
import com.our.oa.entity.User;
import com.our.oa.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public Integer selectByEmail(User user) {
		//根据email和password去数据库查询
		int rows = userMapper.findByEP(user);
		return rows;
	}

}
