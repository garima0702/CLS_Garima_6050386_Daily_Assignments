package cg.demo.jpahibernate;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import cg.demo.jpahibernate.entities.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class EmpDAO {


	 EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
	 EntityManager em = emf.createEntityManager();


    // INSERT
    
    	public Employee addEmployee(Employee emp) {

    		        em.getTransaction().begin();
    		        em.persist(emp);
    		        em.getTransaction().commit();
    		        return emp;
    		
    	}
    	
    	//READ BY ID
        public Employee viewEmployeeById(int id)  {
        	
        	em.getTransaction().begin();
        	Employee emp = em.find(Employee.class, id);
	        em.getTransaction().commit();

            return emp;
        }
        


    // READ ALL
    public List<Employee> viewEmployees()  {


        List<Employee> list = new ArrayList<>();
        
        TypedQuery <Employee> tquery=em.createQuery("SELECT e FROM Employee e", Employee.class);
        list= tquery.getResultList();
        return list;
       
    }
    
    //Total employee in each dept
    public List<Object[]> totalEmployeesInEachDept() {

        TypedQuery<Object[]> query =
                em.createQuery(
                        "SELECT e.department, COUNT(e) FROM Employee e GROUP BY e.department",
                        Object[].class
                );

        return query.getResultList();
    }
    
    
    
    //Employees Getting Same Salary
    public List<Employee> employeesWithSameSalary() {

        TypedQuery<Employee> query =
                em.createQuery(
                    "SELECT e FROM Employee e WHERE e.salary IN " +
                    "(SELECT e2.salary FROM Employee e2 GROUP BY e2.salary HAVING COUNT(e2) > 1)",
                    Employee.class
                );

        return query.getResultList();
    }
    
    
    
    
    //Find Employee by Mobile Number (ElementCollection)
    public Employee findEmployeeByMobile(Long mobile) {

        TypedQuery<Employee> query =
                em.createQuery(
                    "SELECT e FROM Employee e JOIN e.phone p WHERE p = :mobile",
                    Employee.class
                );

        query.setParameter("mobile", mobile);

        return query.getSingleResult();
    }
    
    //findall
    //total no. of emp working in each dept.
    //list of emp. who are getting same sal
    //record of emp on basis of mobile number, make set of mobno as element collection, make id as auto generated
    // do all this using pdql
    
    
    
    
    
    
    
    


    // UPDATE the salary
    public Employee updateSalary(int id, int salary) {
   	 em.getTransaction().begin();
        Employee e = em.find(Employee.class,id);
        if(e!=null) {
       	 e.setSalary(salary);
       	 em.merge(e);
        }
        em.getTransaction().commit();
        return e;
    }


    // DELETE
    
    	public Employee deleteEmployee(int id) {
    		Employee emp1= new Employee();
    		emp1.setId(id);
//    		emp1.setDepartment("IT");
//    		emp1.setName("Ronit");
//    		emp1.setSalary(45000);
//    		emp1.setPhone(0);
    		
//    		em.getTransaction().begin();
//            em.remove(emp1);
//            em.getTransaction().commit();

    		 Employee emp = em.find(Employee.class, id);

    	        if (emp != null) {
    	            em.getTransaction().begin();
    	            em.remove(emp);
    	            em.getTransaction().commit();

    	    
    	}
    	        return emp1;
    	}
}
