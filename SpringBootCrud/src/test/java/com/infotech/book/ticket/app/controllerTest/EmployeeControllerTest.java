package com.infotech.book.ticket.app.controllerTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infotech.book.ticket.app.controller.EmployeeController;
import com.infotech.book.ticket.app.model.Employee;
import com.infotech.book.ticket.app.repository.EmployeeRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(value=EmployeeController.class,secure=false)
public class EmployeeControllerTest 
{
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private EmployeeRepository employeeRepository;
	
	@Test
	public void TestAdd()throws Exception
	{
		Employee employee=new Employee();
		employee.setId(1);
		employee.setFirstname("Abdur");
		employee.setLastname("Rouf");
		employee.setSalary("2500");
		employee.setCity("Bangalore");
		
		String inputInJson=this.mapToJson(employee);
		
		String uri="/company/employees";
		Mockito.when(Mockito.any(Employee.class)).thenReturn(employee);
		RequestBuilder requestBuilder=MockMvcRequestBuilders
				.post(uri)
				.accept(MediaType.APPLICATION_JSON).content(inputInJson)
				.contentType(MediaType.APPLICATION_JSON);
		
		MvcResult mvcResult=mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response=mvcResult.getResponse();
		
		String outputInJson=response.getContentAsString();
		
		assertThat(outputInJson).isEqualTo(inputInJson);
		assertEquals(HttpStatus.OK.value(),response.getStatus());
		
		
		
		
	}

	private String mapToJson(Object object)throws JsonProcessingException 
	{
		
		ObjectMapper objectMapper=new ObjectMapper(); 
		// TODO Auto-generated method stub
		return objectMapper.writeValueAsString(object);
	}
	
	
	
	@Test
	public void TestGetEmployeeById()throws Exception
	{
		Employee employee=new Employee();
		employee.setId(1);
		employee.setFirstname("Abdur");
		employee.setLastname("Rouf");
		employee.setSalary("2500");
		employee.setCity("Bangalore");
		
		Mockito.when(Mockito.anyInt()).thenReturn(employee.getId());
		String uri="/company/employees/1";
		RequestBuilder requestBuilder=MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON);
		
		MvcResult result=mockMvc.perform(requestBuilder).andReturn();
		
		String expectedjson=this.mapToJson(employee);
		String outputInJson=result.getResponse().getContentAsString();
		
		assertThat(outputInJson).isEqualTo(expectedjson);
		
	}

}
