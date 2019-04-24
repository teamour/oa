package com.our.oa.dto.form;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DictionaryDTO implements Serializable {
	
	private Integer dictId;

	private String dictName;

	private String description;
	
	private static final long serialVersionUID = 1L;
}
