package com.our.oa.entity;

import java.io.Serializable;
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
public class Role implements Serializable {
    private Integer roleId;

    private String roleName;

    private String description;

    private Integer sortOrder;

    private Boolean status;

    private static final long serialVersionUID = 1L;
}