package com.our.oa.entity;

import java.io.Serializable;
import java.util.Date;

import com.our.oa.entity.User.UserBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Sender implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//发件人id
	private Integer senderId;
	//发件人姓名
	private String senderName;
	
	//发件人mail地址
	private String senderMailAddress;
	
	//邮箱密码
	private String senderMailPassword;
	
}
