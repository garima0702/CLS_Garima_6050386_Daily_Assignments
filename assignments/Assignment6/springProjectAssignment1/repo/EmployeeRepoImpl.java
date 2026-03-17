package cg.demo.springProjectAssignment1.repo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cg.demo.springProjectAssignment1.beans.Employee;

@Repository
public class EmployeeRepoImpl  implements IEmployeeRepo{
	
	private Map<Integer,Employee> emp = new HashMap<>();
	

	
	@Override
	public void addEmployee(Employee e) {

	    int id = e.getEmpid();

	   
	    if(emp.containsKey(id)) {
	        System.out.println("Employee with ID " + id + " already exists!");
	        return;
	    }

	   
	    emp.put(id, e);

	    System.out.println("Employee added successfully!");

	    
	    System.out.println("ID: " + e.getEmpid());
	    System.out.println("Name: " + e.getEname());
	    System.out.println("Salary: " + e.getSalary());
	}



	@Override
	public Employee fetchById(int id) {
		if(emp.containsKey(id)) {
	        return emp.get(id);
	    } else {
	        return null;
	    }
	}



	@Override
	public Map<Integer, Employee> getAllEmployees() {
		return emp;
	}



	@Override
	public void updateEmployee(Employee e) {
		 int id = e.getEmpid();

		    if(emp.containsKey(id)) {
		        emp.put(id, e);
		        System.out.println("Employee updated successfully!");
		    } else {
		        System.out.println("Employee not found!");
		    }
		
	}



	@Override
	public void deleteEmployee(int id) {
		  if(emp.containsKey(id)) {
		        emp.remove(id);
		        System.out.println("Employee deleted successfully!");
		    } else {
		        System.out.println("Employee not found!");
		    }
		
	}



	
}
