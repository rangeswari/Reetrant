package com.infotech.book.ticket.app.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.infotech.book.ticket.app.model.Employee;

@RunWith(SpringRunner.class)
//@SpringBootTest
@DataJpaTest
public class EmployeeRepositoryTest 
{
	
	@Autowired
	private TestEntityManager entityManager;
	@Autowired
	private EmployeeRepository employeeRepository;

	@Test
	public void saveTest()
	{
		Employee employee=getEmployee();
		
		Employee saved=entityManager.persist(employee);
		Employee gets=employeeRepository.getOne(saved.getId());
		assertThat(gets).isEqualTo(saved);
	}
	
	

	public Employee getEmployee()
	{
		Employee employee=new Employee();
		employee.setFirstname("A");
		employee.setLastname("xyz");
		employee.setSalary("2800");
		employee.setCity("Bangalore");
		return employee;
	}

}
