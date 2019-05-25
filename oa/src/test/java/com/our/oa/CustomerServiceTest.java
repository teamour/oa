package com.our.oa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.our.oa.dto.form.CustomerDTO;
import com.our.oa.service.CustomerService;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration
public class CustomerServiceTest {
	
	@Autowired
	private CustomerService service;
	
	Integer id = 6;
	String testName = "test customer";
	String testName2 = "test customer2";
	
	@Before
	public void before() {
		System.out.println("in before");
	}

	@After
	public void after() {
		System.out.println("in after");
	}
	
	@Test
	public void testInsert() {
		CustomerDTO nDto = new CustomerDTO();
		//nDto.setCustomerName(testName);
		service.insert(nDto);
	}
	
	@Test
	public void testSelect() {
		CustomerDTO dto = service.getByPrimaryKey(id);
		assertNotNull(dto);
	}
	
	@Test
	public void testUpdate() {
		CustomerDTO dto = service.getByPrimaryKey(id);
		assertNotNull(dto);
		System.out.println(dto.getCustomerName());
		
		//String tName = dto.getCustomerName();
		//dto.setCustomerName(tName + "T");
		service.updateByPrimaryKey(dto);
		
		CustomerDTO dto2 = service.getByPrimaryKey(id);
		//assertEquals(tName + "T", dto2.getCustomerName());
	}
	
}
