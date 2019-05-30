package com.our.oa.dto.form;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

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
public class UserDTO implements Serializable{
	 	private Integer userId;
	 	
	 	//@ApiModelProperty
	 	@NotBlank(message="用户名不能为空")
	 	private String userName;
	 	
	 	@NotBlank(message="密码不能为空")
	 	//@Pattern(regexp="^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$",message="密码请输入6-16位")
	    private String userPwd;
	 	
	 	@NotBlank(message="邮箱不能为空")
	 	@Pattern(regexp="^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$",message="邮箱格式不正确")
	    private String email;

	    private Date loginTime;

	    private Integer errorNumber;

	    private String emailVerificationCode;

	    private Date verificationCodeSendTime;

	    private Integer employeeId;

	    private Date createTime;

	    private Date updateTime;

	    private Date deleteTime;

	    private Boolean deleteFlag;

	    private static final long serialVersionUID = 1L;
}
