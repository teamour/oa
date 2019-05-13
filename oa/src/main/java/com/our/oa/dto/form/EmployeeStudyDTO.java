package com.our.oa.dto.form;

import java.util.Date;

import com.our.oa.dto.FormDTO;

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
public class EmployeeStudyDTO extends FormDTO{
private static final long serialVersionUID = 1L;
	
	private Integer employeeStudyId;

	private Integer employeeId;

	private String studyContent;

	private String beginDate;

	private String studyTime;

	private Integer handler;

	private String learnCotent;

	private String evaluation;

	private Date createTime;

    private Date updateTime;

    private Date deleteTime;

    private Boolean deleteFlag;

}
