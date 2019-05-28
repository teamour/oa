package com.our.oa.service;

import com.our.oa.dto.form.SalesRecordDTO;
import com.our.oa.dto.list.BusinessManageListDTO;
import com.our.oa.dto.list.BusinessManageListQueryDTO;
import com.our.oa.entity.Sales;

public interface BusinessService extends ListQueryService<BusinessManageListDTO,BusinessManageListQueryDTO>{
    
	void save(SalesRecordDTO salesRecord);
	
	Sales findByEmployeeSiteId(Integer id);
	
	void updateByPrimaryKey(Sales form);
}