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
                Employee e = context.getBean(Employee.class);

                System.out.print("Enter Employee ID: ");
                e.setEmpid(sc.nextInt());

                System.out.print("Enter Employee Name: ");
                e.setEname(sc.next());

                System.out.print("Enter Salary: ");
                e.setSalary(sc.nextDouble());

                service.addEmployee(e);
                break;

            case 2:
                System.out.print("Enter Employee ID to fetch: ");
                int id = sc.nextInt();

                Employee emp = service.fetchById(id);

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
                Employee upd = context.getBean(Employee.class);

                System.out.print("Enter ID to update: ");
                upd.setEmpid(sc.nextInt());

                System.out.print("Enter New Name: ");
                upd.setEname(sc.next());

                System.out.print("Enter New Salary: ");
                upd.setSalary(sc.nextDouble());

                service.updateEmployee(upd);
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