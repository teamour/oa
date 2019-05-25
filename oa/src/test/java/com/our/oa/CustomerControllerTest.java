package com.our.oa;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.our.oa.dto.form.CustomerDTO;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class CustomerControllerTest {

	@Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void testCustomerListGet() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/customer/list"))
        		.andDo(print()).andReturn();
        
        System.out.println(result.getResponse().getContentAsString());
    }
    
    @Test
    public void testCustomerListPost() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/customer/list"))
        		.andDo(print()).andReturn();
        
        System.out.println(result.getResponse().getContentAsString());
    }
    
    @Test
    public void testCustomerAddGet() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/customer/add"))
        		.andDo(print()).andReturn();
        
        System.out.println(result.getResponse().getContentAsString());
    }
    
    @Test
    public void testCustomerAddPost() throws Exception {
    	CustomerDTO dto = new CustomerDTO();
    	//dto.setCustomerName("testAdd");
    	
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/customer/add", dto))
        		.andDo(print()).andReturn();
        
        System.out.println(result.getResponse().getContentAsString());
    }
    
    @Test
	  public void testCustomerEditGet() throws Exception {
	      MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/customer/edit"))
	      		.andDo(print()).andReturn();
	      
	      System.out.println(result.getResponse().getContentAsString());
	  }
    
	  @Test
	  public void testCustomerEditPost() throws Exception {
	      MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/customer/edit"))
	      		.andDo(print()).andReturn();
	      
	      System.out.println(result.getResponse().getContentAsString());
	  }
}
