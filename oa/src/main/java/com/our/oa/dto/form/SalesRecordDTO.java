package com.our.oa.dto.form;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.our.oa.dto.GridListDTO;
import com.our.oa.entity.Customer;
import com.our.oa.entity.EmployeeSite;
import com.our.oa.entity.Project;

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
public class SalesRecordDTO extends GridListDTO{
    private Integer salesRecordId;

    private Integer salesId;

    private String[] salesHandler;
    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    private String[] interviewDate;

    private String[] interviewTime;

    private Byte priority;

    private String[] interviewAddress;

    private Integer interviewFrequency;

    private Integer projectId;

    private Date enterDate;

    private String[] notice1;

    private String[] notice2;

    private Boolean isDone;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;

    private Boolean deleteFlag;
    
    //private CustomerDTO customer;
    
    private String[] customerName;
    
    private String[] salesStaff;
    
    private String[] salesEmail;
    
    private String[] salesTelephone;
    
    private ProjectDTO project;
    
    private EmployeeSiteDTO employeeSite;

    private static final long serialVersionUID = 1L;
}
