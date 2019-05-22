package com.our.oa.dto.list;

import java.util.List;

import com.our.oa.dto.GridListQueryBaseDTO;
import com.our.oa.entity.EmployeeSite;

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
public class EmployeeListQueryDTO extends GridListQueryBaseDTO {
	private static final long serialVersionUID = 1L;
	
	private Integer age;
	
	private String employeeName;
	
	private List<Integer> employeeIds;
	
}
