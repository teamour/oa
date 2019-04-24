package com.our.oa.service;

import org.apache.maven.surefire.shade.org.apache.commons.lang3.StringUtils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.our.oa.dto.GridListDTO;
import com.our.oa.dto.GridListQueryBaseDTO;

public interface ListQueryService<G extends GridListDTO,Q extends GridListQueryBaseDTO> {
	
	/*
	 * 分页/条件 查询
	 */
	default Page<G> getQueryList(Q q){
		String orderBy = "";
		if(StringUtils.isNotBlank(q.getSord()) && StringUtils.isNotBlank(q.getSidx())) {
			orderBy = q.getSidx() + " " + q.getSord();
		}
		PageHelper.startPage(q.getPage(), q.getRows(),orderBy);
		return getGridList(q);		
	}
	
	/*
	 * 列表查询
	 */
	Page<G> getGridList(Q g);
}
