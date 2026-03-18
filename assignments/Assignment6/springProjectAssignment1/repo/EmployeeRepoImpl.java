package cg.demo.springProjectAssignment1.repo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cg.demo.springProjectAssignment1.beans.Employee;

@Repository
public class EmployeeRepoImpl  implements IEmployeeRepo{
	
	private Map<Integer,Employee> emp = new HashMap<>();
	

	
	@Override

	public boolean addEmployee(Employee e) {

	    int id = e.getEmpid();

	    if(emp.containsKey(id)) {
	        return false; 
	    }

	    emp.put(id, e);
	    return true;   
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
	public boolean updateEmployee(Employee e) {
		 int id = e.getEmpid();

		    if(emp.containsKey(id)) {
		        emp.put(id, e);
		        return true;
		       
		    } else {
		    	return false;
		        
		    }
		
	}



	@Override
	public boolean deleteEmployee(int id) {
		  if(emp.containsKey(id)) {
		        emp.remove(id);
		        return true;

		    } else {
		    	return false;
		    }
		
	}



	
}
