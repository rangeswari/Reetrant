package com.infotech.book.ticket.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infotech.book.ticket.app.model.Employee;
import com.infotech.book.ticket.app.repository.EmployeeRepository;

import java.util.*;


@RestController
@RequestMapping("/company")
public class EmployeeController 
{
				
				@Autowired
				private EmployeeRepository employeeRepository;
/*................................................................................................*/
				
				@PostMapping(value="/employees",produces="application/JSON")
				public Employee ADD(@Valid @RequestBody Employee employee)
				{
					
					return employeeRepository.save(employee);
				}
/*................................................................................................*/
				@GetMapping(value="/employees")
				public List<Employee>getAll()
				{
					return employeeRepository.findAll();
				}
/*................................................................................................*/
				@DeleteMapping(value="/employees/{id}",produces="application/JSON")
				 
				public void delete(@PathVariable(value="id") int id)
				{
					
					 employeeRepository.deleteById(id);
	
				}
/*................................................................................................*/
				@GetMapping(value="/employees/{city}")
				public List<Employee>getByCity(@PathVariable(value="city")String city)
				{
					return employeeRepository.findByCity(city);
				}
/*................................................................................................*/
 
 				@GetMapping(value="/employees/{id}")
				public Optional<Employee> getById(@PathVariable(value="id")int id)
				{
					return employeeRepository.findById(id);
				}
 
/*................................................................................................*/
				@GetMapping(value="/employee/{firstname}")
				public List<Employee> findByLastname(@PathVariable(value="firstname")String firstname, Sort sort)
				{
					return employeeRepository.findByfirstname(firstname);
				}
/*................................................................................................*/
				@GetMapping(value="/employees/asc/{lastname}")
				public List<Employee>getAllDSC(@PathVariable(value="lastname")String lastname)
				{
						 return employeeRepository.findByLastnameOrderByFirstnameAsc(lastname);
				}
/*................................................................................................*/	
				
				@PutMapping(value="/employees/update")
				public Employee update(@RequestParam(value="param1")int para1,@RequestParam(value="param2")String para2)
				{
					Employee emp=employeeRepository.getOne(para1);
					
					emp.setFirstname(para2);
					return employeeRepository.save(emp);
					
					
				}
/*...................................................................................................*/
				
				@GetMapping(value="/employees/salary")
				public int aggregate_function()
				{
							
							
								return employeeRepository.MaxSalary();
	
				}
				
}
