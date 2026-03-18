package cg.demo.springProjectAssignment1.services;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cg.demo.springProjectAssignment1.beans.Employee;
import cg.demo.springProjectAssignment1.repo.IEmployeeRepo;

@Service
public class EmployeeServiceImpl implements IEmployeeService{
	
	@Autowired
    private IEmployeeRepo repo;

    @Override
    public boolean addEmployee(Employee e) {
        return repo.addEmployee(e);
    }

	@Override
	public Employee fetchById(int id) {
		 return repo.fetchById(id);
		
	}

	@Override
	public Map<Integer, Employee> getAllEmployees() {
		return repo.getAllEmployees();
	}

	@Override
	public boolean updateEmployee(Employee e) {
		return repo.updateEmployee(e);
		
	}

	@Override
	public boolean deleteEmployee(int id) {
		return repo.deleteEmployee(id);
		
	}

	

}
