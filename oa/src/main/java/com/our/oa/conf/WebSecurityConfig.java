//package com.our.oa.conf;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import com.our.oa.service.UserService;
//
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true) // 开启security注解 public
//class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//	
//	@Autowired
//	private UserService userService;
//	
//	
//	@Override
//	public void configure(WebSecurity web) { // 解决静态资源被拦截的问题
//		web.ignoring().antMatchers("/css/**", "/js/**");
//	}
//
//	@Override protected void configure(HttpSecurity http) throws Exception {
//  
//  //允许所有用户访问"/"和"/home" 
//		
//		  http.authorizeRequests() //所有资源都拦截 
//		  .antMatchers("/css/**", "/fonts/**","/js/**").permitAll() 
//		  .anyRequest().authenticated() 
//		  .and() 
//		  .formLogin()
//		  //指定登录页是"/login" 
//		  .loginPage("/user/login") //登录成功后默认跳转到
//		  .defaultSuccessUrl("/index") .permitAll();
//		 
////	  http.formLogin()                    //  定义当需要用户登录时候，转到的登录页面。
////      .loginPage("/user/login")           // 设置登录页面
////      .and()
////      .authorizeRequests()        // 定义哪些URL需要被保护、哪些不需要被保护
////      .antMatchers("/user/login","/css/**", "/fonts/**","/js/**","/emp/**")
////      .permitAll()     // 设置所有人都可以访问登录页面
////      .anyRequest()               // 任何请求,登录后可以访问
////      .authenticated()
////      .and()
////      .csrf().disable()			//关闭csrf防护
////      .headers().frameOptions().sameOrigin();			
//  }
//	 @Autowired
//	    public void configureAuth(AuthenticationManagerBuilder auth) throws Exception {
//	        auth
//	            .inMemoryAuthentication()
//	                .withUser("thomas")
//	                .password("password")
//	                .roles("USER")
//	            .and()
//	                .withUser("joe")
//	                .password("password")
//	                .roles("USER");
//	    }
//	
//	 
//}
