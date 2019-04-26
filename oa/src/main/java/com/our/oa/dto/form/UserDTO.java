package com.our.oa.dto.form;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;

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

	    private String userPwd;

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
