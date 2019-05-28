package com.our.oa.serviceimpl;
  
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.our.oa.service.UserService;

import sun.security.provider.MD5;
  

@Component
public class LoginAuthenticationProvider extends DaoAuthenticationProvider {
  
	@Autowired
    private UserService userService;
 
    /**
     * 自定义验证方式
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();
        System.out.println("前端传过来的明文密码:" + password);
        BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
        String hashPass = bcryptPasswordEncoder.encode(password);
        System.out.println("加密后的密码:" + hashPass);
        UserDetails user = userService.loadUserByUsername(username);
 
        //加密过程在这里体现
        System.out.println("结果CustomUserDetailsService后，已经查询出来的数据库存储密码:" + user.getPassword());
        if (!user.getPassword().equals(hashPass)) {
            throw new DisabledException("Wrong password.");
        }
 
        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
        return new UsernamePasswordAuthenticationToken(user, password, authorities);
    }
    public LoginAuthenticationProvider(UserDetailsService userDetailsService) {
    	  super(); // 这个地方一定要对userDetailsService赋值，不然userDetailsService是null (这个坑有点深)
    	  setUserDetailsService(userDetailsService); }
    @Override
    public boolean supports(Class<?> arg0) {
        return true;
    }
}
 