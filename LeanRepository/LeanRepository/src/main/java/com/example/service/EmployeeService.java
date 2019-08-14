package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Employee;
import com.example.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
private  EmployeeRepository  employeeRepository;
	
	public String insert(Employee em)
	{
		if(employeeRepository.exists(em.getEmpid())
		{
			return "Emplyee Data Already Exit";
		}
		else
		{
			employeeRepository.save(em);
			return "Emplyee Data Added Succesfully";
		}
	}

}
