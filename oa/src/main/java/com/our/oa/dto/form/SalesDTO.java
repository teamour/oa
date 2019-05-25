package com.our.oa.dto.form;


import com.our.oa.dto.GridListDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper=true)
@EqualsAndHashCode(callSuper=true)
public class SalesDTO extends GridListDTO{
    private String expectEnteryDate1;

    private String expectEnteryDate2;

    private String firstProject;

    private String secondProject;

    private String thirdProject;
    
    private Integer employeeId;
    
    private Integer employeeSiteId;
    
    private static final long serialVersionUID = 1L;
}
