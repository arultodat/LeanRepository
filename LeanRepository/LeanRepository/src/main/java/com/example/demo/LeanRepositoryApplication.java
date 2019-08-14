package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.model.Employee;
import com.example.service.EmployeeService;

@SpringBootApplication
public class LeanRepositoryApplication implements CommandLineRunner {
	
	@Autowired
	EmployeeService employeeService; 

	public static void main(String[] args) {
		SpringApplication.run(LeanRepositoryApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Employee em = new Employee(1, "Krishna", "software");
		System.out.println(employeeService.insert(em));
		/* employeerepository.save(em); */
		
		
	}

}
