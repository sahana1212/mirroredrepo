package com.mindtree.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;hvfdsdfsfd
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mindtree.doa.EmployeeDoaImple;
import com.mindtree.entity.Employee;
import com.mindtree.service.EmployeeServiceImple;


@RestController
public class EmployeeController {
	@Autowired
	EmployeeServiceImple es;
	@RequestMapping("/index")
	public ModelAndView indexPage()
	{
		return new ModelAndView("index","message","");
	}
	
	@RequestMapping("/addEmp1")
	public ModelAndView  addEmployeePage()
	{
		return new ModelAndView("addEmp","message","");
	}
	
	@RequestMapping(value="/addEmployee",method=RequestMethod.POST)
	public ModelAndView addEmployee(@ModelAttribute("employee") @Validated Employee employee,BindingResult bindingResult,Model model) {
		if (bindingResult.hasErrors()) {
			return new ModelAndView("index","message","Unsuccessfull");
	      }
		
		System.out.println(employee);
		es.addEmployee(employee);
		return new ModelAndView("index","message","Add Successfully");
	}
	
	@RequestMapping("/deleteEmp1")
	public ModelAndView  deleteEmployeePage()
	{
		
		return new ModelAndView("deleteEmp");
	}
	@RequestMapping(value="/deleteEmp",method=RequestMethod.POST)
	public ModelAndView deleteEmployee(Employee employee,Model model) {
		System.out.println(employee.getId());
		es.deleteEmployee(employee.getId());
		
		return new ModelAndView("index","message","Deleted Successfully");
	}
	
	@RequestMapping("/getAllEmpDetails1")
	public ModelAndView  getEmployeePage()
	{
		List<Employee> e = (new EmployeeServiceImple()).allEmployees();
		return new ModelAndView("getAllEmpDetails","message",e);
	}
	
	@RequestMapping("/getByEmpId1")
	public ModelAndView  getEmployeeByIDPage()
	{
		return new ModelAndView("getByEmpId","message","");
	}
	
	@RequestMapping(value="/getByEmpId",method=RequestMethod.POST)
	public ModelAndView getEmployeeById(Employee employee,Model model) {
		System.out.println(employee.getId());
		Employee e = es.getById(employee.getId());
		List<Employee> emps = new ArrayList<Employee>();
		emps.add(e);
		System.out.println(emps);
		return new ModelAndView("getByEmpId","message",emps);
	}
	
	@RequestMapping("/checkLogin1")
	public ModelAndView  checkLoginPage()
	{
		return new ModelAndView("checkLogin","message","");
	}
	
	@RequestMapping(value="/checkLogin",method=RequestMethod.POST)
	public ModelAndView checkLogin(Employee employee,Model model) {
		return new ModelAndView("checkLogin","message",es.validEmployee(employee.getUsername(), employee.getPassword()));
	}
	
	
}
