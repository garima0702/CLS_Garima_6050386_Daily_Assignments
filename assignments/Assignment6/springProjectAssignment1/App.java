package cg.demo.springProjectAssignment1;

import java.util.Map;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cg.demo.springProjectAssignment1.beans.Employee;
import cg.demo.springProjectAssignment1.services.IEmployeeService;

public class App {

    public static void main(String[] args) {

        ApplicationContext context =new AnnotationConfigApplicationContext(springConfig.class);

        IEmployeeService service = context.getBean(IEmployeeService.class);

        Scanner sc = new Scanner(System.in);

        char ch;

        do {
            System.out.println("\n1. Add Employee");
            System.out.println("2. Get Employee by ID");
            System.out.println("3. All Employees");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");

            System.out.println("Enter your choice:");

            int choice = sc.nextInt();

            switch(choice) {

            case 1:

                System.out.print("Enter Employee ID: ");
                int id = sc.nextInt();

                System.out.print("Enter Employee Name: ");
                String name = sc.next();

                System.out.print("Enter Salary: ");
                double salary = sc.nextDouble();

                Employee e = new Employee(id, name, salary); 

                service.addEmployee(e);
                break;

            case 2:
                System.out.print("Enter Employee ID to fetch: ");
                int id2 = sc.nextInt();

                Employee emp = service.fetchById(id2);

                if(emp != null) {
                    System.out.println(emp.getEmpid() + " " + emp.getEname() + " " + emp.getSalary());
                } else {
                    System.out.println("Employee not found!");
                }
                break;

            case 3:
                System.out.println("All Employees:");

                Map<Integer, Employee> all = service.getAllEmployees();

                if(all.isEmpty()) {
                    System.out.println("No employees found!");
                } else {
                    for(Employee empObj : all.values()) {
                        System.out.println(empObj.getEmpid() + " " + empObj.getEname() + " " + empObj.getSalary());
                    }
                }
                break;

            case 4:

                System.out.print("Enter ID to update: ");
                int id1 = sc.nextInt();

                Employee existing = service.fetchById(id1);

                if(existing != null) {

                    System.out.print("Enter New Name: ");
                    String name1 = sc.next();

                    System.out.print("Enter New Salary: ");
                    double salary1 = sc.nextDouble();

                    Employee upd = new Employee(id1, name1, salary1);

                    service.updateEmployee(upd);

                    System.out.println("Employee updated successfully!");

                } else {
                    System.out.println("Employee not found!");
                }

                break;

            case 5:
                System.out.print("Enter ID to delete: ");
                int delId = sc.nextInt();

                service.deleteEmployee(delId);
                break;

            default:
                System.out.println("Invalid choice!");
            }

            System.out.println("\nDo you want to continue? (y/n)");
            ch = sc.next().charAt(0);

        } while(ch == 'y' || ch == 'Y');

        System.out.println("Thank you!");

        sc.close();
        
        
    }
}