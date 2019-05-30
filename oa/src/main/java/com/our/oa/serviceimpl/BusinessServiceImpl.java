package com.our.oa.serviceimpl;

import com.github.pagehelper.Page;
import com.our.oa.dao.BusinessManageMapper;
import com.our.oa.dao.CustomerMapper;
import com.our.oa.dao.EmployeeSiteMapper;
import com.our.oa.dao.ProjectMapper;
import com.our.oa.dao.SalesMapper;
import com.our.oa.dao.SalesRecordMapper;
import com.our.oa.dto.form.EmployeeSiteDTO;
import com.our.oa.dto.form.SalesRecordDTO;
import com.our.oa.dto.list.BusinessManageListDTO;
import com.our.oa.dto.list.BusinessManageListQueryDTO;
import com.our.oa.entity.Customer;
import com.our.oa.entity.Project;
import com.our.oa.entity.Sales;
import com.our.oa.entity.SalesRecord;
import com.our.oa.service.BusinessService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    private BusinessManageMapper businessMapper;
    @Autowired
    private SalesRecordMapper salesRecordMapper;
    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private ProjectMapper projectMapper;
    @Autowired
    private SalesMapper salesMapper;
    @Autowired
    private EmployeeSiteMapper employeeSiteMapper;
    @Override
    public Page<BusinessManageListDTO> getGridList(BusinessManageListQueryDTO bussManage) {
        Page<BusinessManageListDTO> queryList = businessMapper.selectQueryList(bussManage);
        if(!queryList.isEmpty()){
            return queryList;
        }
        return new Page<>();
    }

	@Override
	public void save(SalesRecordDTO salesRecord) {
		
		SalesRecord SalesR=new SalesRecord();
		Customer customer = new Customer();
		Project project = new Project();
		//EmployeeSiteDTO employeeSite=new EmployeeSiteDTO();
		String[] salesHandler = salesRecord.getSalesHandler();
		String[] interviewDate = salesRecord.getInterviewDate();
		String[] interviewTime = salesRecord.getInterviewTime();
		String[] interviewAddress = salesRecord.getInterviewAddress();
		String[] notice1 = salesRecord.getNotice1();
		String[] notice2 = salesRecord.getNotice2();
		
		String[] projectName = salesRecord.getProject().getProjectName();
		String[] projectDesc = salesRecord.getProject().getProjectDesc();
		
		String[] customerName = salesRecord.getCustomerName();
		String[] salesEmail = salesRecord.getSalesEmail();
		String[] salesStaff = salesRecord.getSalesStaff();
		String[] salesTelephone = salesRecord.getSalesTelephone();
		
		//String[] enterDate = salesRecord.getEmployeeSite().getEnterDate();
		System.out.println();
		for (int i = 0; i < salesHandler.length; i++) {
			if (salesHandler[i]!=null&&salesHandler[i]!="") {
				Integer salesHandler1=Integer.parseInt(salesHandler[i]);
				SalesR.setSalesHandler(salesHandler1);
			}
			if (interviewDate[i]!=null&&interviewDate[i]!="") {
				SalesR.setInterviewDate(interviewDate[i]);
			}
			if (interviewTime[i]!=null&&interviewTime[i]!="") {
				SalesR.setInterviewTime(interviewTime[i]);
			}
			SalesR.setInterviewAddress(interviewAddress[i]);
			SalesR.setNotice1(notice1[i]);
			SalesR.setNotice2(notice2[i]);
			
			project.setProjectName(projectName[i]);
			project.setProjectDesc(projectDesc[i]);
			
			customer.setCustomerName(customerName[i]);
			customer.setSalesEmail(salesEmail[i]);
			customer.setSalesStaff(salesStaff[i]);
			customer.setSalesTelephone(salesTelephone[i]);
			
			/*
			 * if (enterDate[i]!=null&&enterDate[i]!="") {
			 * employeeSite.setEnterDate(enterDate); }
			 */
			salesRecordMapper.insert(SalesR);
			projectMapper.insert(project);//向项目表中添加项目名称和项目详细
			customerMapper.insert(customer);
			//employeeSiteMapper.insert(employeeSite);
		}
		
	}

	@Override
	public Sales findByEmployeeSiteId(Integer id) {
		
		return salesMapper.findByEmployeeSiteId(id);
	}

	@Override
	public void updateByPrimaryKey(Sales form) {
		salesMapper.updateByPrimaryKey(form);
		
	}
	
	
    
}