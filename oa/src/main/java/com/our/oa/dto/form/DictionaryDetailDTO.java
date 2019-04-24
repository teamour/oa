package com.our.oa.dto.form;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
* Created by Mybatis Generator on 2019/03/31
*/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DictionaryDetailDTO implements Serializable {
    private Integer detailId;

    private String detailName;

    private String detailCode;

    private Integer dictId;

    private Integer sortOrder;

    private static final long serialVersionUID = 1L;
}