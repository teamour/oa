package com.our.oa.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.swing.filechooser.FileSystemView;
import javax.validation.Valid;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFCreationHelper;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.Page;
import com.our.oa.dto.GridDTO;
import com.our.oa.dto.form.CustomerDTO;
import com.our.oa.dto.form.DocumentInvoiceDTO;
import com.our.oa.dto.form.EmployeeStudyDTO;
import com.our.oa.dto.list.DocumentInvoiceListDTO;
import com.our.oa.dto.list.DocumentInvoiceListQueryDTO;
import com.our.oa.entity.Customer;
import com.our.oa.service.CustomerService;
import com.our.oa.service.DocumentInvoiceService;
import com.our.oa.utils.PageInfoToGridDTOUtils;

@RestController
@RequestMapping(value="/document")
public class DocumentController {
	
	@Autowired
	private DocumentInvoiceService documentInvoiceService;
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping(value= {"/documentIndex"})
	public ModelAndView documentIndex(ModelAndView modelAndView) {
		modelAndView.setViewName("document/documentIndex");
		return modelAndView;
	}
	@GetMapping(value= {"/addinvoice"})
	public ModelAndView addinvoice(ModelAndView modelAndView) {
		modelAndView.setViewName("document/addinvoice");
		return modelAndView;
	}
	@PostMapping(value="/documentIndex")
	public GridDTO<DocumentInvoiceListDTO> listData(HttpServletRequest req,
			DocumentInvoiceListQueryDTO listQueryDTO) {
		
		Page<DocumentInvoiceListDTO> queryList = documentInvoiceService.getQueryList(listQueryDTO);
		return PageInfoToGridDTOUtils.getGridDataResult(queryList);
	}
	
	@PostMapping(value="/addinvoice")
	public ModelAndView save(@Valid DocumentInvoiceDTO documentInvoiceForm, 
			BindingResult bindingResult,ModelAndView modelAndView) {
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
	
	
	@RequestMapping(value = "/createTest" )
	public static void createExcel() throws IOException{
		  // 获取桌面路径
	    FileSystemView fsv = FileSystemView.getFileSystemView();
	    String desktop = fsv.getHomeDirectory().getPath();
	    String filePath = desktop + "/template.xls";

	    File file = new File(filePath);
	    OutputStream outputStream = new FileOutputStream(file);
	    HSSFWorkbook workbook = new HSSFWorkbook();
	    HSSFSheet sheet = workbook.createSheet("Sheet1");
	    HSSFRow row = sheet.createRow(0);
	    row.createCell(0).setCellValue("id");
	    row.createCell(1).setCellValue("订单号");
	    row.createCell(2).setCellValue("下单时间");
	    row.createCell(3).setCellValue("个数");
	    row.createCell(4).setCellValue("单价");
	    row.createCell(5).setCellValue("订单金额");
	    row.setHeightInPoints(30); // 设置行的高度

	    HSSFRow row1 = sheet.createRow(1);
	    row1.createCell(0).setCellValue("1");
	    row1.createCell(1).setCellValue("NO00001");

	    // 日期格式化
	    HSSFCellStyle cellStyle2 = workbook.createCellStyle();
	    HSSFCreationHelper creationHelper = workbook.getCreationHelper();
	    cellStyle2.setDataFormat(creationHelper.createDataFormat().getFormat("yyyy-MM-dd HH:mm:ss"));
	    sheet.setColumnWidth(2, 20 * 256); // 设置列的宽度

	    HSSFCell cell2 = row1.createCell(2);
	    cell2.setCellStyle(cellStyle2);
	    cell2.setCellValue(new Date());

	    row1.createCell(3).setCellValue(2);


	    // 保留两位小数
	    HSSFCellStyle cellStyle3 = workbook.createCellStyle();
	    cellStyle3.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00"));
	    HSSFCell cell4 = row1.createCell(4);
	    cell4.setCellStyle(cellStyle3);
	    cell4.setCellValue(29.5);


	    // 货币格式化
	    HSSFCellStyle cellStyle4 = workbook.createCellStyle();
	    HSSFFont font = workbook.createFont();
	    font.setFontName("华文行楷");
	    font.setFontHeightInPoints((short)15);
	    font.setColor(HSSFColor.RED.index);
	    cellStyle4.setFont(font);

	    HSSFCell cell5 = row1.createCell(5);
	    cell5.setCellFormula("D2*E2");  // 设置计算公式

	    // 获取计算公式的值
	    HSSFFormulaEvaluator e = new HSSFFormulaEvaluator(workbook);
	    cell5 = e.evaluateInCell(cell5);
	    System.out.println(cell5.getNumericCellValue());


	    workbook.setActiveSheet(0);
	    workbook.write(outputStream);
	    outputStream.close();
	}
}
