package com.our.oa.serviceimpl;

import java.util.HashMap;
import java.util.Map;

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

	@Override
	public Integer save(User user) {
		int rows = userMapper.insert(user);
		return rows;
	}

	@Override
	public boolean valid( String param, Integer type) {
		//将类型转化为具体的字段名称
				String cloumn = null;
				switch (type) {
					case 1:
						cloumn = "user_name"; break;
					case 2:
						cloumn = "user_pwd";  break;
					case 3:
						cloumn = "email";  break;
				}
				//如果结果为0 返回false  如果不为0 返回true
				int count = userMapper.findCheckUser(cloumn,param);
				
				return count == 0 ? false : true;
	}
	

}
