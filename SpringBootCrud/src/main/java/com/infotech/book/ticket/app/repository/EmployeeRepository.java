package com.infotech.book.ticket.app.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Component;

import com.infotech.book.ticket.app.model.Employee;


@Component
public interface EmployeeRepository extends JpaRepository<Employee,Integer>
{

	List<Employee> findByCity(String city);

	List<Employee> findByfirstname(String firstname);

	List<Employee> findByLastnameOrderByFirstnameDesc(String lastname);

	List<Employee> findByLastnameOrderByFirstnameAsc(String lastname);

	
	@Query("SELECT max(e.salary) from Employee e")
	int MaxSalary();


}
