package com.our.oa;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@MapperScan("com.our.oa.dao")
@ComponentScan(basePackages="com.our.oa.serviceimpl,com.our.oa.controller,com.our.oa.conf")
public class OaApplication {

	@RequestMapping(value= "/")
	public String login() {
		return "index";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(OaApplication.class, args);
	}

}
