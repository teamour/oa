package com.our.oa.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.filechooser.FileSystemView;
import javax.validation.Valid;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.Page;
import com.our.oa.dto.GridDTO;
import com.our.oa.dto.form.CustomerDTO;
import com.our.oa.dto.form.DocumentInvoiceDTO;
import com.our.oa.dto.list.DocumentInvoiceListDTO;
import com.our.oa.dto.list.DocumentInvoiceListQueryDTO;
import com.our.oa.entity.DocumentInvoice;
import com.our.oa.entity.DocumentTemplate;
import com.our.oa.service.CustomerService;
import com.our.oa.service.DocumentInvoiceService;
import com.our.oa.service.DocumentTemplateService;
import com.our.oa.utils.PageInfoToGridDTOUtils;

@RestController
@RequestMapping(value="/document")
public class DocumentController {
	
	@Autowired
	private DocumentInvoiceService documentInvoiceService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private DocumentTemplateService documentTemplateService;
	
	@GetMapping(value= {"/documentIndex"})
	public ModelAndView documentIndex(ModelAndView modelAndView) {
		UUID uuid = UUID.randomUUID(); 
		  System.out.println (uuid);
		modelAndView.setViewName("document/documentIndex");
		return modelAndView;
	}
	@GetMapping(value= {"/addinvoice"})
	public ModelAndView addinvoice(ModelAndView modelAndView) {
		modelAndView.setViewName("document/addinvoice");
		return modelAndView;
	}
	@GetMapping(value= {"/editinvoice"})
	public ModelAndView editinvoice(ModelAndView modelAndView) {
		modelAndView.setViewName("document/editinvoice");
		return modelAndView;
	}
	
	@PostMapping(value="/documentIndex")
	public GridDTO<DocumentInvoiceListDTO> listData(HttpServletRequest req,
			DocumentInvoiceListQueryDTO listQueryDTO) {
		
		Page<DocumentInvoiceListDTO> queryList = documentInvoiceService.getQueryList(listQueryDTO);
		return PageInfoToGridDTOUtils.getGridDataResult(queryList);
	}
	//add
	@PostMapping(value="/addinvoice")
	public ModelAndView save(@Valid DocumentInvoiceDTO documentInvoiceForm, 
			BindingResult bindingResult,ModelAndView modelAndView) {
		System.out.println(documentInvoiceForm);
		documentInvoiceService.insert(documentInvoiceForm);
		modelAndView.setViewName("redirect:documentIndex");
        return modelAndView;
	}
	
	@PostMapping(value ="/checkCustomer")
	public String checkCustomer(@RequestParam("customerId") int customerId) {
		try {
			CustomerDTO dto = customerService.getByPrimaryKey(customerId);
			String customerString = "客户公司名："+dto.getCustomerName()+";客户地址："+dto.getAddress();
			System.out.println(customerString);
			return customerString;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("无法找到对应的客户公司");
			return "无法找到对应的客户公司";
		}
		
	}
	
	//edit
	@GetMapping(value = "/editinvoice/{id}")
	public ModelAndView view(@PathVariable(name="id",required=false)Integer id, ModelAndView modelAndView) {
		DocumentInvoiceDTO dto = new DocumentInvoiceDTO();
		if (id != null) {
			
			DocumentInvoice documentInvoice = documentInvoiceService.getByPrimaryKey(id);
			ModelMapper mapper = new ModelMapper();
			dto = mapper.map(documentInvoice, DocumentInvoiceDTO.class);
			System.out.println(dto);
			
		}
		modelAndView.addObject("documentInvoice",dto);
		modelAndView.setViewName("document/editinvoice");
		return modelAndView;
	}
	@PostMapping(value = "/editinvoice/{id}")
	public ModelAndView Update(@Valid DocumentInvoiceDTO documentInvoice,
			BindingResult bindingResult,ModelAndView modelAndView,
			@PathVariable(name="id",required=false)Integer id) {
		documentInvoice.setInvoiceDocumentId(id);
		documentInvoiceService.update(documentInvoice);
			if (bindingResult.hasErrors()) {
				System.out.println("error!");
	        	
	        	List<FieldError>  err=bindingResult.getFieldErrors();
	            FieldError fe;
	            String field;
	            String errorMessage;
	            for (int i = 0; i < err.size(); i++) {
	                fe=err.get(i);
	                field=fe.getField();//得到那个字段验证出错
	                errorMessage=fe.getDefaultMessage();//得到错误消息
	                System.out.println("错误字段消息："+field +" : "+errorMessage);
			}
			}
        // 保存成功后返回列表页
        modelAndView.setViewName("redirect:/document/documentIndex");
        return modelAndView;
	}
	
	//create excel
	@GetMapping(value = "/createinvoice/{id}")
	public ModelAndView createview(@PathVariable(name="id",required=false)Integer id, ModelAndView modelAndView) {
		DocumentInvoiceDTO dto = new DocumentInvoiceDTO();
		if (id != null) {
			
			DocumentInvoice documentInvoice = documentInvoiceService.getByPrimaryKey(id);
			ModelMapper mapper = new ModelMapper();
			dto = mapper.map(documentInvoice, DocumentInvoiceDTO.class);
			
		}
		modelAndView.addObject("documentInvoice",dto);
		modelAndView.setViewName("document/createinvoice");
		return modelAndView;
	}
	
	@PostMapping(value = "/createinvoice/{id}")
	public ModelAndView createup(@Valid DocumentInvoice documentInvoice, DocumentTemplate documentTemplate,
			BindingResult bindingResult,ModelAndView modelAndView,MultipartFile file,HttpServletResponse response,
			HttpServletRequest request,
			@PathVariable(name="id",required=false)Integer id) {
		int  templateId =Integer.parseInt(request.getParameter("template"));
		documentTemplate = documentTemplateService.getByPrimaryKey(templateId);
		String url = documentTemplate.getTemplateFile();
		System.out.println("url="+url);
		System.out.println(System.getProperty("user.dir"));
		documentInvoice = documentInvoiceService.getByPrimaryKey(id);
		//documentInvoiceService.update(documentInvoice);
		String customerName = documentInvoice.getCustomerName();
		String companyName = documentInvoice.getCompanyName();
		String companyZipCode = documentInvoice.getCompanyZipCode();
		String companyAddress = documentInvoice.getCompanyAddress();
		String[] compAddress = companyAddress.split("\\s+");//这样写就可以了
		String companyTelephone = documentInvoice.getCompanyTelephone();
		String payDeadline = documentInvoice.getPayDeadline();
		Calendar cal=Calendar.getInstance();    
	    int y=cal.get(Calendar.YEAR);    
	    int m=cal.get(Calendar.MONTH);    
	    int d=cal.get(Calendar.DATE); 
		String value="";
		//EXCEL操作
	    try {
	    	 //获取桌面路径
		    FileSystemView fsv = FileSystemView.getFileSystemView();
		    String desktop = fsv.getHomeDirectory().getPath();
		    File excelFile = new File(url); // 创建文件对象  
		    InputStream fs = new FileInputStream(excelFile);
		    HSSFWorkbook wb = new HSSFWorkbook(fs);//excel
		    HSSFSheet sheet = wb.getSheetAt(0);//sheet,下标从0开始
		    
//		    HSSFRow row = sheet.getRow(0);
//		    int rowNum=sheet.getLastRowNum();
//		    for(int i=0;i<=rowNum;i++) {
//		    	row= sheet.getRow(i);
//		    	if(row!=null)
//		    		continue;
//		    }
//		   
//		    int columnNum= row.getPhysicalNumberOfCells();
		    
//		    System.out.println("rownum="+rowNum+";columnnum="+columnNum);
		    for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
                // HSSFRow表示行
                HSSFRow hssfRow = sheet.getRow(rowNum);
                if(hssfRow == null) {
                	continue;
                }
                int minColIx = hssfRow.getFirstCellNum();
                int maxColIx = hssfRow.getLastCellNum();
                // 遍历改行，获取处理每个cell元素
                for (int colIx = minColIx; colIx < maxColIx; colIx++) {
                    // HSSFCell 表示单元格
                    HSSFCell cell = hssfRow.getCell(colIx, Row.RETURN_BLANK_AS_NULL);
                    if (cell == null) {
                        continue;
                    }
		        try {//应对迷之空指针异常（明明是空cell却能获取数值的情况）
		        	 cell.setCellType(Cell.CELL_TYPE_STRING);
		        	 value = cell.getStringCellValue();
		        }catch (Exception e) {
					// TODO: handle exception
		        	continue;
				}
		        System.out.println(value);
		        switch (value) {
				case "$COMPANY-NAME" :
					cell.setCellValue(companyName);
					break;
				case "$POST-CODE" :
					cell.setCellValue("〒"+companyZipCode);
					break;
				case "$ADDR1" :
					cell.setCellValue(compAddress[0]);
					break;
				case "$ADDR2" :
					cell.setCellValue(compAddress[1]);
					break;
				case "$TEL" :
					cell.setCellValue("TEL "+companyTelephone);
					break;
				case "$CUSTOMER 御中" :
					cell.setCellValue(customerName+" 御中");
					break;
				case "$PAY-END-DATE" :
					cell.setCellValue(payDeadline);
					break;
				case "$日付" :
				    cell.setCellValue(y+"/"+m+"/"+d);
				    break;
				default:
					break;
				}
		        	
		      }
		    }
		    
		    String fileName = "請求書_"+customerName+"_"+y+m+d+".xls"; 
		    FileOutputStream fileOut = new FileOutputStream(desktop +"/"+ fileName);//另存文件  
            wb.write(fileOut);  
            fileOut.close();  
	    }catch (Exception e) {
			// TODO: handle exception
	    	System.out.println(e);
		}

        // 保存成功后返回列表页
        modelAndView.setViewName("redirect:/document/documentIndex");
        return modelAndView;
	}
	
	
	//delete
	@RequestMapping(value = "/deleteInvoiceByIds" )
	public String deleteInvoice( Integer... ids) {
		for (Integer id : ids) {
			documentInvoiceService.deleteByUpdate(id);
			System.out.println(id);
		}
		System.out.println(ids);
		return "delete ok";
	}

}
