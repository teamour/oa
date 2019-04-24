package com.our.oa.dto.list;

import com.our.oa.dto.GridListQueryBaseDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
* Created by Mybatis Generator on 2019/03/31
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper=true)
@EqualsAndHashCode(callSuper=true)
public class InterviewerVisaHandleListQueryDTO extends GridListQueryBaseDTO {

	private int interviewerId; 
	
    private static final long serialVersionUID = 1L;
}