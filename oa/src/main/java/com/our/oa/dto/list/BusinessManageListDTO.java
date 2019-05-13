package com.our.oa.dto.list;

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
public class BusinessManageListDTO extends GridListDTO{
    private static final long serialVersionUID = 1L;

    private Integer employeeId;

    private String employeeName;//雇员姓名

    private Byte workingYears;//工作年数

    private Integer japaneseLevel;//日语等级

    private Integer skillLevel;//技术等级

    private String skill1;//工作1

    private String skill2;//工作2

    private String skill3;//工作3

}