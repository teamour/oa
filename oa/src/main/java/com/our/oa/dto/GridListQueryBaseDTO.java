package com.our.oa.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/*
 * 列表查询DTO基类
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GridListQueryBaseDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	/*
	 * 模糊查询
	 */
	@Builder.Default
	private boolean fuzzyQuery = false;
	/*
	 * 查询时间
	 */
	@Builder.Default
	private Long nd = new Date().getTime();
	/*
	 * 页面显示记录数
	 */
	@Builder.Default
	private Integer rows = 10;
	/*
	 * 第几页
	 */
	@Builder.Default
	private Integer page = 1;
	/*
	 * 排序字段名称
	 */
	private String sidx;
	/*
	 * asc/desc
	 */
	private String sord;
}
