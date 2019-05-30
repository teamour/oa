package com.our.oa.dto.list;

import java.util.Date;

import com.our.oa.dto.GridListQueryBaseDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper=true)
@EqualsAndHashCode(callSuper=true)
public class UserListQueryDTO extends GridListQueryBaseDTO {
	
	private Date createTime;
	
	private static final long serialVersionUID = 1L;
}
