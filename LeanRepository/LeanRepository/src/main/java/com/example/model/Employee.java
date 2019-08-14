package com.example.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;


@Entity
@NamedQuery(name ="employee.findAll", query = "select * from employee")
public class Employee implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="empid")
	private Integer empid;
	
	@Column(name="name")
	private String name;
	
	
	@Column(name="designation")
	private String designation;
	
	public Employee()
	{
		
	}
	public Employee(Integer empid, String name, String designation) {
		super();
		this.empid = empid;
		this.name = name;
		this.designation = designation;
	}
	public Integer getEmpid() {
		return empid;
	}
	public void setEmpid(Integer empid) {
		this.empid = empid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", name=" + name + ", designation=" + designation + "]";
	}	

}
