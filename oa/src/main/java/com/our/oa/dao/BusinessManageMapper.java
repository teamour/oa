package com.our.oa.dao;

import com.github.pagehelper.Page;
import com.our.oa.dto.form.SalesRecordDTO;
import com.our.oa.dto.list.BusinessManageListDTO;
import com.our.oa.dto.list.BusinessManageListQueryDTO;


/**
* Created by Mybatis Generator on 2019/03/31
*/
public interface BusinessManageMapper {
	
	Page<BusinessManageListDTO> selectQueryList(BusinessManageListQueryDTO queryDTO);
}