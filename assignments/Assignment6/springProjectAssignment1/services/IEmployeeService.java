package cg.demo.springProjectAssignment1.services;

import java.util.Map;

import cg.demo.springProjectAssignment1.beans.Employee;

public interface IEmployeeService {
	boolean addEmployee(Employee e);
	Employee fetchById(int id);
	Map<Integer, Employee> getAllEmployees();   
	boolean updateEmployee(Employee e);           
	boolean deleteEmployee(int id); 

}
