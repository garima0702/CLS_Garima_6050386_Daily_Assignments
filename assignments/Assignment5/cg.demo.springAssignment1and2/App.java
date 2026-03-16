package cg.demo.springAssignment1and2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import cg.demo.springAssignment1and2.entities.Employee;


public class App 
{
	public static void main( String[] args )
    {
        System.out.println( "Starting Application...." );
        
        ApplicationContext ac =new ClassPathXmlApplicationContext("springConf.xml"); 
        
        Employee e1= (Employee) ac.getBean("emp1");

        System.out.println(e1);

        System.out.println( "Closing Application...." );
    }
}
