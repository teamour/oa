package com.our.oa.dto.list;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import com.our.oa.dto.GridListDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper=true)
@EqualsAndHashCode(callSuper=true)
public class UserListDTO extends GridListDTO{
 	
 	//@ApiModelProperty
 	@NotBlank(message="用户名不能为空")
 	private String userName;

    private String userPwd;

    private String email;

    private Integer employeeId;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;

    private Boolean deleteFlag;

    private static final long serialVersionUID = 1L;
}
