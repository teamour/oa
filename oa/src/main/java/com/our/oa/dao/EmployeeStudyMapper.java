package com.our.oa.dao;

import com.github.pagehelper.Page;
import com.our.oa.dto.form.EmployeeStudyDTO;
import com.our.oa.dto.list.EmployeeStudyListDTO;
import com.our.oa.dto.list.EmployeeStudyListQueryDTO;
import com.our.oa.entity.EmployeeStudy;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

/**
* Created by Mybatis Generator on 2019/03/31
*/

public interface EmployeeStudyMapper {
    int deleteByPrimaryKey(Integer employeeStudyId);

    int insert(EmployeeStudy record);

    EmployeeStudy selectByPrimaryKey(Integer employeeStudyId);

    List<EmployeeStudy> selectAll();
    
    Page<EmployeeStudyListDTO> selectQueryList(EmployeeStudyListQueryDTO queryDTO); 

    int updateByPrimaryKey(EmployeeStudy record);
    
    int setDeleteFleg(Integer employeeStudyId);
    
    int updateForDelete(Integer employeeStudyId);
}