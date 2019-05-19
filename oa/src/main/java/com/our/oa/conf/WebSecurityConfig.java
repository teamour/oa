package com.our.oa.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.our.oa.service.UserService;
import com.our.oa.serviceimpl.LoginAuthenticationProvider;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true) //开启security注解
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	private static final String KEY = "kozen.com";

	@Autowired
	private UserService userService;
	
	@Override
	public void configure(WebSecurity web) {
		//解决静态资源被拦截的问题
		web.ignoring().antMatchers("/css/**","/js/**","/i18n/**");
	}

    @Override
    protected void configure(HttpSecurity http) throws Exception {
		
		  //允许所有用户访问"/"和"/home" 
    	http.authorizeRequests() //所有资源都拦截
    	 .antMatchers("/css/**", "/fonts/**", "/js/**").permitAll()
		 .anyRequest().authenticated() 
		 .and()
		 .formLogin() //指定登录页是"/login"
		 .loginPage("/user/login") //登录成功后默认跳转到 
		 .defaultSuccessUrl("/index")
		 .permitAll();
		 
		/*
		 * http.authorizeRequests() .antMatchers("/css/**",
		 * "/js/**","/","/fonts/**","/users").permitAll() // 都可以访问
		 * .antMatchers("/h2-console/**").permitAll() // 都可以访问
		 * .antMatchers("/admin/**").hasRole("ADMIN") // 需要相应的角色才能访问
		 * .antMatchers("/console/**").hasAnyRole("ADMIN","USER") // 需要相应的角色才能访问 .and()
		 * .formLogin() //基于 Form 表单登录验证 .defaultSuccessUrl("/") .loginPage("/login")
		 * //登录页面 .failureUrl("/login?error=true") // 登录错误页面 .and().logout()
		 * .and().rememberMe().key(KEY) // 启用 remember me
		 * .tokenValiditySeconds(1209600)//记住两周
		 * .and().exceptionHandling().accessDeniedPage("/403"); // 处理异常，拒绝访问就重定向到 403 页面
		 */    
    	}
    @Override
   	public void configure(AuthenticationManagerBuilder auth) throws Exception {
   		//auth.userDetailsService(userService);
   		auth.authenticationProvider(new LoginAuthenticationProvider(userService));
   	}

}
