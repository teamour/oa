package com.our.oa.dto.list;

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
public class InterviewerListQueryDTO extends GridListQueryBaseDTO {
	private static final long serialVersionUID = 1L;
	
    private String interviewerName;
    
    private String interview1Time;
    
    private String interview1Handler;
    
    private String interview2Handler;
    
    private String interview3Handler;
}
