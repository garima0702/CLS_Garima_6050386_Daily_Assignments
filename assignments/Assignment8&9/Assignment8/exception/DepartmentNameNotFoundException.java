package com.example.Assignment8.exception;



public class DepartmentNameNotFoundException extends RuntimeException{
	public DepartmentNameNotFoundException() {
		super("There is not department with such name!");
	}

}
