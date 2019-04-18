package com.our.oa.dto;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/*
 * 列表显示基类
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GridDTO<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int page;
	private int total;
	private long records;
	private List<T> rows;
}
