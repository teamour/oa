package com.our.oa.serviceimpl;

import com.github.pagehelper.Page;
import com.our.oa.dao.BusinessManageMapper;
import com.our.oa.dao.CustomerMapper;
import com.our.oa.dao.ProjectMapper;
import com.our.oa.dao.SalesRecordMapper;
import com.our.oa.dto.form.SalesRecordDTO;
import com.our.oa.dto.list.BusinessManageListDTO;
import com.our.oa.dto.list.BusinessManageListQueryDTO;
import com.our.oa.entity.Customer;
import com.our.oa.entity.Project;
import com.our.oa.service.BusinessService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    private BusinessManageMapper businessMapper;
    @Autowired
    private SalesRecordMapper salesRecordMapper;
    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private ProjectMapper projectMapper;
    
    @Override
    public Page<BusinessManageListDTO> getGridList(BusinessManageListQueryDTO bussManage) {
        Page<BusinessManageListDTO> queryList = businessMapper.selectQueryList(bussManage);
        if(!queryList.isEmpty()){
            return queryList;
        }
        return new Page<>();
    }

	@Override
	public void save(SalesRecordDTO salesRecord) {
		
		Customer customer = salesRecord.getCustomer();
		Project project = salesRecord.getProject();
		salesRecordMapper.insert(salesRecord);
		customerMapper.insert(customer);
		projectMapper.insert(project);//向项目表中添加项目名称和项目详细
		
	}
    
}