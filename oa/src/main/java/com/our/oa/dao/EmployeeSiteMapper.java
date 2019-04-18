package com.our.oa.dao;

import com.our.oa.entity.EmployeeSite;
import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
* Created by Mybatis Generator on 2019/03/31
*/
public interface EmployeeSiteMapper {
    int deleteByPrimaryKey(Integer employeeSiteId);

    int insert(EmployeeSite record);

    EmployeeSite selectByPrimaryKey(Integer employeeSiteId);

    List<EmployeeSite> selectAll();

    int updateByPrimaryKey(EmployeeSite record);
    
    List<EmployeeSite> findPageObjects(
			 @Param("employee_site_id")String username,
			 @Param("startIndex")Integer startIndex,
			 @Param("pageSize")Integer pageSize);
	
	int getRowCount(@Param("employee_site_id")String username);
}