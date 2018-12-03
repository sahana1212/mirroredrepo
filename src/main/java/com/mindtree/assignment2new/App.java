package com.mindtree.assignment2new;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mindtree.doa.EmployeeDoaImple;
import com.mindtree.entity.Employee;

public class App 
{
    public static void main( String[] args)
    {
        System.out.println( "Hello World!" );
        
        Employee e = new Employee();
        e.setId(156);  
	    e.setFullname("varun");  
	    e.setDob("dfghj");
	    e.setEmailid("cgvhbjn");
	    e.setGender("gender");
	    e.setPassword("yhtgrfed");
	    e.setSecurityAnswer("securityAnswer");
	    e.setSecurityQuestion("securityQuestion");
	    e.setUsername("username");
        
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        EmployeeDoaImple ed = (EmployeeDoaImple) context.getBean("d");
        
        //add
        ed.addEmployee(e);
    	
        //update
    	//ed.updateEmployee(e);
        
        //delete
        //ed.deleteEmployee(114);
        
        //getbyid
        //System.out.println(ed.getById(114));
        
        //all employess
        //System.out.println(ed.allEmployees());
        
        //validate employee
        //System.out.println(ed.validEmployee(e.getUsername(), ""));
    	
    	System.out.println("Working Fine");
        
        
    }
}
