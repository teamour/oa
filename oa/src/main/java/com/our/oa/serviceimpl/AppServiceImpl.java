package com.our.oa.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.our.oa.dao.AppMapper;
import com.our.oa.entity.App;
import com.our.oa.service.AppService;

@Service
public class AppServiceImpl implements AppService {
	
	@Autowired
	private AppMapper appMapper;

	@Override
	public List<App> getAllApp() {
		return appMapper.selectAll();
	}

}
