package com.infotech.book.ticket.app.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;

@Entity
@Table(name="rouf")
public class Employee 
{
	
			
		
			@Id
			@GeneratedValue(strategy=GenerationType.AUTO)
			private int id;
			@Column(name="firstname")
			
			private String firstname;
			@Column(name="lastname")
			private String lastname;
			@Column(name="salary")
			private String salary;
			@Column(name="city")
			private String city;
			
			
			public Employee() 
			{
				super();
			}
			
			
			
			public int getId() {
				return id;
			}
			public void setId(int id) {
				this.id = id;
			}
			public String getFirstname() {
				return firstname;
			}
			public void setFirstname(String firstname) {
				this.firstname = firstname;
			}
			public String getLastname() {
				return lastname;
			}
			public void setLastname(String lastname) {
				this.lastname = lastname;
			}
			public String getSalary() {
				return salary;
			}
			public void setSalary(String salary) {
				this.salary = salary;
			}
			public String getCity() {
				return city;
			}
			public void setCity(String city) {
				this.city = city;
			}
			
			
			
			
			
			

}
