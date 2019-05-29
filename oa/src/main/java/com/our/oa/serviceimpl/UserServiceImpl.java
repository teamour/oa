package com.our.oa.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.our.oa.dao.UserMapper;
import com.our.oa.dto.form.UserDTO;
import com.our.oa.entity.User;
import com.our.oa.service.UserService;

@Service
public class UserServiceImpl implements UserService{
//	 @Autowired
//	    private UserMapper userMapper;
//	 
//	 
//	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//	        User user = userMapper.queryByUserName(username);
//	        System.out.println("User : "+user.getUserName());
//	        if(user==null){
//	            System.out.println("User not found");
//	            throw new UsernameNotFoundException("Username not found");
//	        }else {
//	return new  org.springframework.security.core.userdetails.User(username, username, false, false, false, false, null);}
//	        
//	    }
	 

}
