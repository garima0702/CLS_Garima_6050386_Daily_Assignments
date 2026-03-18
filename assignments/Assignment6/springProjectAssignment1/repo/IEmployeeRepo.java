package cg.demo.springProjectAssignment1.repo;

import java.util.Map;

import cg.demo.springProjectAssignment1.beans.Employee;

public interface IEmployeeRepo {
	boolean addEmployee(Employee e);
	Employee fetchById(int id);
	Map<Integer, Employee> getAllEmployees();   
	boolean updateEmployee(Employee e);           
	boolean deleteEmployee(int id); 
}
