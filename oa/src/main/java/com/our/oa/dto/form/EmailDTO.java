package com.our.oa.dto.form;

import java.util.Date;

import com.our.oa.dto.FormDTO;
import com.our.oa.dto.form.EmployeeStudyDTO.EmployeeStudyDTOBuilder;

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
public class EmailDTO extends FormDTO{
	private String emailtitle;
	
	private String emailcontext;

}
