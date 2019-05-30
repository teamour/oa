package com.our.oa.serviceimpl;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.our.oa.dao.UserMapper;
import com.our.oa.dto.form.UserDTO;
import com.our.oa.dto.list.UserListDTO;
import com.our.oa.dto.list.UserListQueryDTO;
import com.our.oa.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	 	@Autowired
	    private UserMapper userMapper;
	 
	 
//	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//	        User user = userMapper.findByUserName(username);
//		
//	        System.out.println("User : "+user.getUserName());
//	        username=user.getUserName();
//	        
//	       return new  org.springframework.security.core.userdetails.User(username, user.getUserPwd(), true, true, true, true, null);
//	        	
//	    }


		@Override
		public Page<UserListDTO> getGridList(UserListQueryDTO g) {
			Page<UserListDTO> queryResult = userMapper.selectQueryList(g);
			 if(!queryResult.isEmpty()) {
				 return queryResult;
			 }	 
			 return new Page<>();
		}


		@Override
		public String save(UserDTO form) {
			
			int rows = userMapper.checkByUserName(form.getUserName());
			if(rows==0) {
				
				String md5Password = DigestUtils.md5Hex(form.getUserPwd());
				form.setUserPwd(md5Password);
//				BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
//		        String hashPass = bcryptPasswordEncoder.encode(form.getUserPwd());
//		        form.setUserPwd(hashPass);
				userMapper.insert(form);
			}else {
				return "用户已存在";
			}
			return "用户添加成功";
		}
	 

}
