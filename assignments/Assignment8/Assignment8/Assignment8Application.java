package com.example.Assignment8;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.Assignment8.controller.EmployeeController;

@SpringBootApplication
public class Assignment8Application {

//	@Autowired
//	EmployeeController traineeController; 

	public static void main(String[] args) {
		System.out.println("Application Context is Loaded!!!");
		SpringApplication.run(Assignment8Application.class, args);
	}

}




		
		
	


