package cg.demo.AssociationMapping;

import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;

/**
 * Hello world!
 *
 */
public class OneToManyDAO
{
    
    	
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
   	 	EntityManager em = emf.createEntityManager();
   	 	
   	 	//em.getTransaction().begin();
   	 
   	 	//------------unidirectional mapping-----------------------
//	   	Employee e1 = new Employee();
//	   	e1.setName("Kusha");
//	   	e1.setSal(40000);
//	
//	   	Employee e2 = new Employee();
//	   	e2.setName("disha");
//	   	e2.setSal(90000);
//	   	
//	   	Department d1 = new Department();
//	   	d1.setName("IT");
//	   	d1.setManagername("Kunal");
//	
//	   	List<Employee> empList = new ArrayList<>();
//	   	empList.add(e1);
//	   	empList.add(e2);
//	   	
//	
//	   	d1.setEmp(empList);
//	
//	   	em.persist(d1);
//	   	
//	   	
//	   	Employee e3 = new Employee();
//	   	e3.setName("natasha");
//	   	e3.setSal(50000);
//	
//	   	Employee e4 = new Employee();
//	   	e4.setName("katha");
//	   	e4.setSal(50000);
//	   	
//	   	Department d2 = new Department();
//	   	d2.setName("sales");
//	   	d2.setManagername("aditi");
//	
//	   	List<Employee> empList1 = new ArrayList<>();
//	   	empList1.add(e3);
//	   	empList1.add(e4);
//	   	
//	
//	   	d2.setEmp(empList1);
//	
//	   	em.persist(d2);
	   	
	   	
	   	
	   	
	   	//-----------Bidirectional mapping------------
//   	 Employee e1 = new Employee();
//	   	e1.setName("daksh");
//	   	e1.setSal(40000);
//	
//	   
//	   	
//	   	Department d1 = new Department();
//	   	d1.setName("IT");
//	   	d1.setManagername("Kunal");
//	
//	   	List<Employee> empList = new ArrayList<>();
//	   	empList.add(e1);
//	   	
//	   	
//	   	e1.setDept(d1);
//	   	d1.setEmp(empList);
//	
//	   	em.persist(e1);
//	   	
//	    Employee e2 = new Employee();
//	   	e2.setName("kartik");
//	   	e2.setSal(50000);
//	
//	   
//	   	
//	   	
//	   	d1.setName("IT");
//	   	d1.setManagername("Kunal");
//	
//	   	List<Employee> empList1 = new ArrayList<>();
//	   	empList1.add(e2);
//	   	
//	   	
//	   	e2.setDept(d1);
//	   	d1.setEmp(empList1);
//	
//	   	em.persist(e2);
//	   	
//	   	
//	   	Employee e3 = new Employee();
//	   	e3.setName("tarun");
//	   	e3.setSal(30000);
//	
//	   
//	   	
//	   	Department d2 = new Department();
//	   	d2.setName("sales");
//	   	d2.setManagername("Tilak");
//	
//	   	List<Employee> empList2 = new ArrayList<>();
//	   	empList2.add(e3);
//	   	
//	   	
//	   	e3.setDept(d2);
//	   	d2.setEmp(empList2);
//	
//	   	em.persist(e3);
   	 	
	//em.getTransaction().commit();
   	 	

   	 	
   	 	 //1. Insert Employees
	   	 public Employee InsertEmployee(Employee e) {
	
	   	    Department d = e.getDept();   // get department from employee
	
	   	    if(d.getEmp() == null) {
	   	        d.setEmp(new ArrayList<>());
	   	    }
	
	   	    d.getEmp().add(e);   // maintain second side
	
	   	    em.getTransaction().begin();
	   	    em.persist(e);       // employee is owning side
	   	    em.getTransaction().commit();
	
	   	    return e;
	   	}

   	 	
   	 	//1.a. Find department by name
   	 	public Department findDeptByName(String name) {
//   	 	TypedQuery <Department> tquery = em.createQuery("Select d from Department d where d.name=:name ", Department.class);
//   	 	tquery.setParameter("name", name);
//	   	 	List<Department> list = tquery.getResultList();
//	
//	   	    if(list.isEmpty()) {
//	   	        return null;
//	   	    }
//	
//	   	    return list.get(0);
   	 	

	   	     CriteriaBuilder cb = em.getCriteriaBuilder();
	
	   	     CriteriaQuery<Department> cq = cb.createQuery(Department.class);
	
	   	     Root<Department> dept = cq.from(Department.class);
	
	   	     cq.select(dept).where(cb.equal(dept.get("name"), name));
	
	   	     TypedQuery<Department> query = em.createQuery(cq);
	
	   	     List<Department> list = query.getResultList();
	
	   	     if(list.isEmpty()) {
	   	         return null;
	   	     }
	
	   	     return list.get(0);
   	 	 }
   	 				
   	 	
   	 	
   	 	//2. find all employees and with department details
   	 	public List<Employee> viewAllWithDept(){
   	 		
   	 		//JPQL
   	 		//TypedQuery <Employee> tq= em.createQuery("select e  from Employee e JOIN e.dept d ", Employee.class);
   	 		//List<Employee> list =tq.getResultList();
	 		//return list;
   	 		
   	 		CriteriaBuilder cb= em.getCriteriaBuilder();
   	 		CriteriaQuery <Employee> cq= cb.createQuery(Employee.class);
   	 		Root<Employee> root = cq.from(Employee.class);
   	 		
   	 		cq.select(root);
   	 		TypedQuery <Employee> tq= em.createQuery(cq);
   	 		
   	 		List<Employee> list =tq.getResultList();
   	 		return list;
   	 		
   	 	}
   	 	
   	 	//3. number of employees working in each department
	   	 public List<Object[]> employeesInEachDepartment() {
	
	   		//JPQL
	   	    //TypedQuery<Object[]> tq = em.createQuery("SELECT d.name, COUNT(e) FROM Employee e JOIN e.dept d GROUP BY d.name" , Object[].class);
     		//TypedQuery <Employee> tq= em.createQuery(cq);	 		
			//List<Employee> list =tq.getResultList();
			//return list;

	   	    
	   		CriteriaBuilder cb= em.getCriteriaBuilder();
	 		CriteriaQuery <Object[]> cq= cb.createQuery(Object[].class);
	 		Root<Employee> root = cq.from(Employee.class);
	 		Join<Employee, Department> deptjoin= root.join("dept");
	 		cq.multiselect(
	 	            deptjoin.get("name"),cb.count(root));

	 	    cq.groupBy(deptjoin.get("name"));

	 	    TypedQuery<Object[]> tq = em.createQuery(cq);

	 	    return tq.getResultList();
	 	}
	 		
	 		
	 		
	   	
	   	 
	   	//4. find employees by department
	   	public List<Employee> findEmployeesByDepartment(String deptName){
	   		
	   		//JPQL
	   	    //TypedQuery<Employee> tq = em.createQuery("SELECT e FROM Employee e JOIN e.dept d WHERE d.name = :deptName",Employee.class);
	   		//tq.setParameter("deptName", deptName);
	   	    //return tq.getResultList();
	   		
	   		CriteriaBuilder cb = em.getCriteriaBuilder();

	   	    CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);

	   	    Root<Employee> root = cq.from(Employee.class);

	   	    Join<Employee, Department> deptJoin = root.join("dept");

	   	    cq.select(root)
	   	      .where(cb.equal(deptJoin.get("name"), deptName));

	   	    TypedQuery<Employee> tq = em.createQuery(cq);

	   	    return tq.getResultList();
	   	}
	   	 
	   	//5. find employee by mobile
	   	public List<Object[]> findEmployeeByMobile(Long mobile){
	   		
	   		//----------JPQL------------
	   		//TypedQuery<Object[]> tq = em.createQuery("SELECT e.Eid, e.name, d.name, d.managername FROM Employee e JOIN e.dept d JOIN e.phone p WHERE p = :mobile",Object[].class);
	   	    //tq.setParameter("mobile", mobile);
	   	    //return tq.getResultList();

	   		    CriteriaBuilder cb = em.getCriteriaBuilder();

	   		    CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);

	   		    Root<Employee> root = cq.from(Employee.class);

	   		    Join<Employee, Department> deptJoin = root.join("dept");

	   		    Join<Employee, Long> phoneJoin = root.join("phone");

	   		    cq.multiselect(
	   		            root.get("Eid"),
	   		            root.get("name"),
	   		            deptJoin.get("name"),
	   		            deptJoin.get("managername")
	   		    );

	   		    cq.where(cb.equal(phoneJoin, mobile));

	   		    TypedQuery<Object[]> tq = em.createQuery(cq);

	   		    return tq.getResultList();
	   		}
	   		
	   	
	   	
	   	//6. find employee greater than salary
	   	public List<Employee> findEmployeeGreaterThanSalary(int salary) {
	   		CriteriaBuilder cb= em.getCriteriaBuilder();
   	 		CriteriaQuery <Employee> cq= cb.createQuery(Employee.class);
   	 		Root<Employee> root = cq.from(Employee.class);
   	 		Predicate salaryPredicate =  cb.gt(root.get("sal"), salary);
   	 		cq.select(root).where(salaryPredicate);
   	 		TypedQuery <Employee> tq= em.createQuery(cq);
   	 	
   	 		List<Employee> list =tq.getResultList();
	   		
			return list;
	   		
	   	}
   	 	
   	 	
    }

