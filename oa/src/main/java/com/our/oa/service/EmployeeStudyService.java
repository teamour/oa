package com.our.oa.service;

import java.util.List;
import com.our.oa.dto.form.EmployeeStudyDTO;
import com.our.oa.dto.list.EmployeeStudyListDTO;
import com.our.oa.dto.list.EmployeeStudyListQueryDTO;
import com.our.oa.entity.EmployeeStudy;

public interface EmployeeStudyService extends ListQueryService<EmployeeStudyListDTO,EmployeeStudyListQueryDTO>{
	List<EmployeeStudy> getEmployeeStudy();
	
	EmployeeStudy getByPrimaryKey(Integer employeeStudyId);
	
	EmployeeStudy getByEmployeeId(Integer employeeId);
	
	int insert(EmployeeStudyDTO dto);
	
	int update(EmployeeStudyDTO dto);
	
	int deleteByPrimaryKey(Integer employeeStudyId);
	
	int deleteBydIds(Integer... Ids);
	

	int updateForDelete(Integer employeeStudyId);
}
