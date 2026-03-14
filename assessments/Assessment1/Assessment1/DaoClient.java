package cg.demo.Assessment1;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Scanner;
import java.util.Set;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Hello world!
 *
 */
public class DaoClient {
    static OrdersDaoImp dao = new OrdersDaoImp();
    static Scanner scan = new Scanner(System.in);
        
	public static void main(String[] args) {
		String opt = null;
		do {
			System.out.println("1-ADD, 2--VIEW BY ORDER ID, 3--VIEW BY CUSTOMER NAME");
			int mtype = scan.nextInt();
			processMenu(mtype);
			System.out.println("press y to continue");
			opt=scan.next();
		}while(opt.equalsIgnoreCase("y"));

	}
	
	public static void processMenu(int mtype) {
		switch(mtype) {
		case 1:
	        
			 Orders ord = new Orders();

             scan.nextLine();

             System.out.print("Enter order_amount: ");
             Double amount = scan.nextDouble();
 			 ord.setOrder_amt(amount);
             scan.nextLine();
             
             
             System.out.print("Enter order_date: ");
             ord.setOrder_date(LocalDate.now());
   
            
             System.out.print("Enter customer Id: ");
 			int id = scan.nextInt();
 			boolean b = dao.addOrder(ord,id);
 			if(!b) {
 				System.out.println("Order added");}
 			else
 			{
 				System.out.println("Order already exists");}
 			break;

			
		case 2:
			System.out.print("Enter Order Id: ");
			int id1 = scan.nextInt();
			System.out.println();
			Orders o1 = dao.getOrder(id1);
			System.out.println(o1);
			break;
			
		case 3:
			scan.nextLine();
			System.out.print("Enter Customer name: ");
			String name = scan.nextLine();
			List<Orders> l=dao.getOrders(name);
			for(Orders od : l){
				System.out.println(od);
			}
			break;
		default:
			System.out.println("Invalid option");
		}
	}

	
 }


