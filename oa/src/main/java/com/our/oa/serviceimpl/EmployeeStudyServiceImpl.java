package com.our.oa.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.our.oa.dao.EmployeeStudyMapper;
import com.our.oa.dto.form.EmployeeStudyDTO;
import com.our.oa.dto.list.EmployeeStudyListDTO;
import com.our.oa.dto.list.EmployeeStudyListQueryDTO;
import com.our.oa.entity.EmployeeStudy;
import com.our.oa.service.EmployeeStudyService;
import com.our.oa.utils.ModelMapperUtils;

@Service
public class EmployeeStudyServiceImpl implements EmployeeStudyService{
	@Autowired
	private EmployeeStudyMapper employeeStudyMapper;
	
	@Override
	public List<EmployeeStudy> getEmployeeStudy(){
		return employeeStudyMapper.selectAll();
	}

	@Override
	public Page<EmployeeStudyListDTO> getGridList(EmployeeStudyListQueryDTO g) {
		//Page<EmployeeStudyListDTO> queryResult = employeeStudyMapper.selectQueryList(g);
		Page<EmployeeStudyListDTO> queryResult = employeeStudyMapper.selectQueryList(g);
		if(!queryResult.isEmpty()) {
			return queryResult;
		}
		return new Page<>();
	}

	@Override
	public EmployeeStudy getByPrimaryKey(Integer employeeStudyId) {
		// TODO Auto-generated method stub
		return employeeStudyMapper.selectByPrimaryKey(employeeStudyId);
	}

	@Override
	public EmployeeStudy getByEmployeeId(Integer employeeId) {
		// TODO Auto-generated method stub
		return employeeStudyMapper.selectByEmployeeId(employeeId);
	}
	
	@Override
	public int insert(EmployeeStudyDTO dto) {
		// TODO Auto-generated method stub
		ModelMapper modelMapper = new  ModelMapper();
		EmployeeStudy record = modelMapper.map(dto, EmployeeStudy.class);
		return employeeStudyMapper.insert(record);
	}

	@Override
	public int update(EmployeeStudyDTO dto) {
		// TODO Auto-generated method stub
		ModelMapper modelMapper = new  ModelMapper();
		EmployeeStudy record = modelMapper.map(dto, EmployeeStudy.class);
		return employeeStudyMapper.updateByPrimaryKey(record);
	}

	@Override
	public int deleteByPrimaryKey(Integer employeeStudyId) {
		// TODO Auto-generated method stub
		return employeeStudyMapper.deleteByPrimaryKey(employeeStudyId);
	}

	@Override
	public int deleteBydIds(Integer... Ids) {
		int rows = 0;
		for (Integer employeeStudyId : Ids) {
			employeeStudyMapper.deleteByPrimaryKey(employeeStudyId);
			//rows= employeeSiteMapper.deleteByPrimaryKey(employeeId);
		}
		return rows;
	}

	@Override
	public int updateForDelete(Integer employeeStudyId) {
		// TODO Auto-generated method stub
		employeeStudyMapper.updateForDelete(employeeStudyId);
		return 0;
	}



	
}
