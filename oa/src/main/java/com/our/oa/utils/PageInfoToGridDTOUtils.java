package com.our.oa.utils;

import com.github.pagehelper.PageInfo;
import com.our.oa.dto.GridDTO;

public class PageInfoToGridDTOUtils{

	private PageInfoToGridDTOUtils() {}
	
    public static <T> GridDTO<T> getGridDataResult(PageInfo<T> pageObj) {
    	GridDTO<T> gridDTO = new GridDTO<>();
    	gridDTO.setPage(pageObj.getPageNum());
    	gridDTO.setTotal(pageObj.getPages());
    	gridDTO.setRecords(pageObj.getTotal());
    	gridDTO.setRows(pageObj.getList());
    	return gridDTO;
	}
}
