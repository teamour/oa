package com.our.oa.service;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.our.oa.dto.GridListDTO;
import com.our.oa.dto.GridListQueryBaseDTO;

public interface ListQueryService<G extends GridListDTO,Q extends GridListQueryBaseDTO> {
	
	/*
	 * 分页/条件 查询
	 */
	default PageInfo<G> getQueryList(Q q){
		PageHelper.startPage(q.getPage(), q.getRows());
		List<G> result = getGridList(q);
		return new PageInfo<G>(result);
	}
	
	/*
	 * 列表查询
	 */
	List<G> getGridList(Q g);

}
