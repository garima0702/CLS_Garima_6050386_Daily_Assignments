package cg.demo.jpahibernate;

import cg.demo.jpahibernate.entities.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class App {
    public static void main(String[] args)  {

        Scanner sc = new Scanner(System.in);
        int choice;
        
        EmpDAO dao= new EmpDAO();

        do {
        	System.out.println("1. Insert Employee");
        	System.out.println("2. View by id");
        	System.out.println("3. View all");
        	System.out.println("4. Update Salary");
        	System.out.println("5. Delete Employee");
        	System.out.println("6. Total Employee in each dept");
        	System.out.println("7. Employees with same salary");
        	System.out.println("8. Find employee by mobile number");
        	System.out.println("9. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch(choice) {
         

            case 1:

                Employee emp = new Employee();

                sc.nextLine();

                System.out.print("Enter Name: ");
                emp.setName(sc.nextLine());

                System.out.print("Enter Salary: ");
                emp.setSalary(sc.nextInt());
                sc.nextLine();

                System.out.print("Enter Department: ");
                emp.setDepartment(sc.nextLine());

                Set<Long> phones = new HashSet<>();

                System.out.print("Enter number of phone numbers: ");
                int n = sc.nextInt();

                for(int i = 0; i < n; i++) {
                    System.out.print("Enter phone number: ");
                    phones.add(sc.nextLong());
                }

                emp.setPhone(phones);

                dao.addEmployee(emp);

                System.out.println(emp);

                break;

                case 2:
                	
                	System.out.print("Enter Employee ID: ");
                	int id = sc.nextInt();
                	
                	Employee emp1=new Employee();
                	emp1=dao.viewEmployeeById(id);

                	if(emp1 != null) {
                	    System.out.println(emp1);
                	}
                	else {
                	    System.err.println("Employee not found");
                	}
                	break;
                	
                    
                case 3:
                	List<Employee> employees = dao.viewEmployees();

                	for(Employee e : employees) {
                	    System.out.println(e);
                	}
                	break;
                	
              

                case 4:

                    System.out.print("Enter Employee ID: ");
                    int id1 = sc.nextInt();

                    System.out.print("Enter New Salary: ");
                    int salary = sc.nextInt();

                    Employee updatedEmp = dao.updateSalary(id1,salary);

                    if(updatedEmp != null) {
                        System.out.println("Updated Employee:");
                        System.out.println(updatedEmp);
                    }
                    else {
                        System.err.println("Employee not found");
                    }

                    break;

                case 5:

                	System.out.print("Enter Employee ID: ");
                	int deleteId = sc.nextInt();

                	  
                       Employee emp2= dao.deleteEmployee(deleteId);
                       System.out.println(emp2);
                    break;
                case 6:
                	List<Object[]> emplist =dao.totalEmployeesInEachDept();
                	
                	for(Object[] obj : emplist) {
                	    System.out.println(obj[0] + " " + obj[1]);
                	}
                	break;
                	
                	
                	
                case 7:

                    List<Employee> sameSalaryEmployees = dao.employeesWithSameSalary();

                    if(sameSalaryEmployees.isEmpty()) {
                        System.out.println("No employees with same salary found");
                    }
                    else {
                        System.out.println("Employees with same salary:");
                        for(Employee e : sameSalaryEmployees) {
                            System.out.println(e);
                        }
                    }

                    break;
                    
                    
                case 8:

                    System.out.print("Enter Mobile Number: ");
                    Long mobile = sc.nextLong();

                    Employee emp3 = dao.findEmployeeByMobile(mobile);

                    if(emp3 != null) {
                        System.out.println(emp3);
                    } 
                    else {
                        System.out.println("No employee found");
                    }

                    break;

            }

        } while(choice != 9);

        System.out.println("Program Ended.");

    }
}










