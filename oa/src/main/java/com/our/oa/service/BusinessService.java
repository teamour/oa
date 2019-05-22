package com.our.oa.service;

import com.our.oa.dto.form.SalesRecordDTO;
import com.our.oa.dto.list.BusinessManageListDTO;
import com.our.oa.dto.list.BusinessManageListQueryDTO;

public interface BusinessService extends ListQueryService<BusinessManageListDTO,BusinessManageListQueryDTO>{
    
	void save(SalesRecordDTO salesRecord);
	
}