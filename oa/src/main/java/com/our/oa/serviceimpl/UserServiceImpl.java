package com.our.oa.serviceimpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.our.oa.dao.UserMapper;
import com.our.oa.dto.form.UserDTO;
import com.our.oa.entity.User;
import com.our.oa.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	 	private String salt;
		//private PasswordEncoder passwordEncoder;
		@Autowired
		private UserMapper userMapper;
		
		@Override
		public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
			    //List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
			   
			User user = userMapper.queryByUserName(userName);
			if (user == null) {
			      throw new UsernameNotFoundException("User not found");
			}
			//authorities.add(new SimpleGrantedAuthority(user.getUserId().toString()));
			System.out.println(user.getUserPwd()); 
			return new org.springframework.security.core.userdetails.User(userName, user.getUserPwd(), AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
		}
		@Override
		public void saveUser(UserDTO user) {
			int i = 0;
			String password = user.getUserPwd() ;
			String hashedPassword =null;
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			while(i <5){
				hashedPassword= passwordEncoder.encode(password);
				i++;
			}
			System.out.println(hashedPassword);
			user.setUserPwd(hashedPassword);
			userMapper.insert(user);
		}

	

}
