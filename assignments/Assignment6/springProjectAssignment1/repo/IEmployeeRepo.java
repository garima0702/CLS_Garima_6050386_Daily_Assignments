package cg.demo.springProjectAssignment1.repo;

import java.util.Map;

import cg.demo.springProjectAssignment1.beans.Employee;

public interface IEmployeeRepo {
	void addEmployee(Employee e);
	Employee fetchById(int id);
	Map<Integer, Employee> getAllEmployees();   
	void updateEmployee(Employee e);           
	void deleteEmployee(int id); 
}
