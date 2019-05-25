package com.our.oa.dto.form;

import com.our.oa.dto.GridListDTO;
import com.our.oa.dto.form.SalesDTO.SalesDTOBuilder;

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
public class ProjectDTO extends GridListDTO{
	private String[] projectName;
	
	private String[] projectDesc;
	
	private static final long serialVersionUID = 1L;
}
