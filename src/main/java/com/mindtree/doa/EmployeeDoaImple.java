package com.mindtree.doa;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.mindtree.entity.Employee;
@Repository
public class EmployeeDoaImple {
		
		HibernateTemplate template = new HibernateTemplate();
		
		public HibernateTemplate getTemplate() {
			return template;
		}

		public void setTemplate(HibernateTemplate template) {
			this.template = template;
		}

		//Add Employee
		public void addEmployee(Employee e)
		{
			Session s = template.getSessionFactory().openSession();
			s.save(e);
			s.beginTransaction().commit();			
		}
		
		//delete employee
		public void deleteEmployee(int id)
		{
			Employee e = getById(id);
			Session s = template.getSessionFactory().openSession();
			s.delete(e);
			s.beginTransaction().commit();			

		}
		
		//List of employee
		public List<Employee> allEmployees()
		{
			List<Employee> list=new ArrayList<Employee>();  
		    list = template.loadAll(Employee.class);  
		    return list;  
		}
		
		//Update Employee
		public void updateEmployee(Employee e)
		{
			
			Session s = template.getSessionFactory().openSession();
			s.save(e);
			s.beginTransaction().commit();		
		}
		
		//Get Employee details by empid
		public Employee getById(int id)
		{
			return template.get(Employee.class, id);
		}
		
		//check valid Employee
		public String validEmployee(String username,String password)
		{
			List<Employee> l = allEmployees();
			Employee e1 = null;
			for(Employee e:l)
			{
				if(e.getUsername().compareTo(username)==0)
					e1=e;
			}
			if(e1!=null)
				if(e1.getUsername().compareTo(username)==0 && e1.getPassword().compareTo(password)==0)
					return "Success";
			return "Failure";
		}
	

}
