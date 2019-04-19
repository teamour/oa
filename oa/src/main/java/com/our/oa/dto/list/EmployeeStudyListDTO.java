package com.our.oa.dto.list;

import java.util.Date;

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
public class EmployeeStudyListDTO extends GridListDTO{
	private static final long serialVersionUID = 1L;
	
	private Integer employeeStudyId;

	private Integer employeeId;

	private String studyContent;

	private Date beginDate;

	private String studyTime;

	private Integer handler;

	private String learnCotent;

	private String evaluation;
	

}
