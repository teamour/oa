package com.our.oa.serviceimpl;

import com.github.pagehelper.Page;
import com.our.oa.dao.BusinessManageMapper;
import com.our.oa.dto.list.BusinessManageListDTO;
import com.our.oa.dto.list.BusinessManageListQueryDTO;
import com.our.oa.service.BusinessManageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessManageServiceImpl implements BusinessManageService {

    @Autowired
    private BusinessManageMapper businessManageMapper;

    @Override
    public Page<BusinessManageListDTO> getGridList(BusinessManageListQueryDTO bussManage) {
        Page<BusinessManageListDTO> queryList = businessManageMapper.selectQueryList(bussManage);
        if(!queryList.isEmpty()){
            return queryList;
        }
        return new Page<>();
    }
    
}