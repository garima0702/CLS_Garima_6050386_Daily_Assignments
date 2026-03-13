package cg.demo.AssociationMapping;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


public class OneToManyMenu {
    public static void main(String[] args)  {

        Scanner sc = new Scanner(System.in);
        int choice;
        
        OneToManyDAO dao= new OneToManyDAO();
        

        do {
        	System.out.println("1. Insert Employee");
        	System.out.println("2. View all employees along with dept");
        	System.out.println("3. no. of employees in each dept");
        	System.out.println("4. find employees by department");
        	System.out.println("5. find employee by mobile");
        	System.out.println("6. find employee greater than 300000 sal");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); 

            switch(choice) {
         

            case 1:
            	Employee e1 = new Employee();

            	System.out.print("Enter Name: ");
            	e1.setName(sc.nextLine());

            	System.out.print("Enter Salary: ");
            	e1.setSal(sc.nextInt());

            	Set<Long> phones = new HashSet<>();

            	System.out.print("Enter number of phone numbers: ");
            	int n = sc.nextInt();

            	for(int i = 0; i < n; i++) {
            	    System.out.print("Enter phone number: ");
            	    phones.add(sc.nextLong());
            	}

            	e1.setPhone(phones);

            	sc.nextLine();   

            	System.out.print("Enter Department: ");
            	String deptName = sc.nextLine();

            	Department d1 = dao.findDeptByName(deptName);

            	if(d1 == null) {
            	    d1 = new Department();

            	    d1.setName(deptName);

            	    System.out.print("Enter Manager Name: ");
            	    d1.setManagername(sc.nextLine());
            	    d1.setEmp(new ArrayList<>()); 
            	}

            	e1.setDept(d1);
            	d1.getEmp().add(e1);
            	
            	dao.InsertEmployee(e1);

            	System.out.println(e1);

            	break;
            
            
            case 2:
            	List<Employee> list = dao.viewAllWithDept();

            	for(Employee e : list) {
            		System.out.println(
            		        "Employee Name: " + e.getName() +
            		        " | Salary: " + e.getSal() +
            		        " | Department: " + e.getDept().getName() +
            		        " | Manager: " + e.getDept().getManagername()
            	    );
            	}
            	break;
            	
            case 3:
            	List<Object[]> list1= dao.employeesInEachDepartment();

            	for(Object[] obj : list1) {
            	    System.out.println(
            	        "Department: " + obj[0] +
            	        " | Employees: " + obj[1]
            	    );
            	}
            	break;
            case 4:

                sc.nextLine(); // clear buffer

                System.out.print("Enter Department Name: ");
                String dName = sc.nextLine();

                List<Employee> list3 = dao.findEmployeesByDepartment(dName);

                if(list3.isEmpty()){
                    System.out.println("No employees found in this department.");
                }
                else{
                    for(Employee e : list3){
                        System.out.println(
                            "Employee ID: " + e.getEid() +
                            " | Name: " + e.getName() +
                            " | Salary: " + e.getSal()
                        );
                    }
                }

            break;
            	
            case 5:

                System.out.print("Enter mobile number: ");
                Long mobile = sc.nextLong();

                List<Object[]> list4 = dao.findEmployeeByMobile(mobile);

                if(list4.isEmpty()){
                    System.out.println("No employee found with this mobile number");
                }
                else{
                    for(Object[] row : list4){
                        System.out.println(
                            "Employee ID: " + row[0] +
                            " | Name: " + row[1] +
                            " | Department: " + row[2] +
                            " | Manager: " + row[3]
                        );
                    }
                }

            break;
            
           
            }
            
            
            
//               
        }while(choice != 7);

        System.out.println("Program Ended.");

        }
    }










