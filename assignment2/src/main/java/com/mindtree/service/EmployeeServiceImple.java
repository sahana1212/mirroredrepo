package com.mindtree.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.doa.EmployeeDoaImple;
import com.mindtree.entity.Employee;
@Component
@Repository
public class EmployeeServiceImple {
	
	ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
    EmployeeDoaImple ed = context.getBean("d",EmployeeDoaImple.class);
    
	@Transactional
	public void addEmployee(Employee e)
	{
		ed.addEmployee(e);
	}
	@Transactional
	public void deleteEmployee(int id)
	{
		ed.deleteEmployee(id);
	}
	
	public List<Employee> allEmployees()
	{
		return ed.allEmployees();
	}
	@Transactional
	public void updateEmployee(Employee e)
	{
		ed.updateEmployee(e);
	}
	
	public Employee getById(int id)
	{
		return ed.getById(id);
	}
	
	public String validEmployee(String username,String password)
	{
		return ed.validEmployee(username, password);
	}

}
