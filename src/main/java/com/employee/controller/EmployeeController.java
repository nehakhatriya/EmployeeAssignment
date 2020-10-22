package com.employee.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.employee.entity.Employee;
import com.employee.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService service;

	@GetMapping
	public String homeEmployee(HttpServletRequest req ,Model model) {
		List<Employee> employees;
		if (req.getParameterMap().containsKey("sort")) {
			String val = req.getParameter("sort");
			employees = service.listEmployees(val);
		} else
			employees = service.listEmployees();
		model.addAttribute("employees", employees);
		return "home";
	}

	@PostMapping()
	public String saveEmployee(@Valid Employee employee,BindingResult br) {
		if(!br.hasErrors()) {
			service.saveEmployee(employee);		
		}
		return "redirect:employee/list";
	}

	@RequestMapping("/list")
	public String listEmployee(HttpServletRequest req ,Model model) {
		List<Employee> employees;
		if (req.getParameterMap().containsKey("sort")) {
			String val = req.getParameter("sort");
			employees = service.listEmployees(val);
		} else
			employees = service.listEmployees();
		model.addAttribute("employees", employees);
		return "list-employee";
	}
	
	@GetMapping("/addEmployee")
	public String addEmployee(Model model) {
		model.addAttribute("employee",new Employee());
		return "form";
	}
	
	@RequestMapping("/delete")
	public String deleteEmployee(@RequestParam("empid") int empid, Employee employee) {
		service.deleteEmployee(empid);
		return "redirect:/app/employee/list";
	}

	@GetMapping("/update")
	public String displayUpdateForm(@RequestParam("empid") int empid,Model model) {
		Employee employee=service.getEmployee(empid);
		model.addAttribute("employee",employee);
		return "update-form";
	}

	@PostMapping("/update")
	public String UpdateEmployee(Employee employee) {
		service.updateEmployee(employee);
		return "redirect:/app/employee/list";
	}
	
	@PostMapping("/login")
	public String login() {
		return "redirect:/app/employee/list";
	}
	
	@GetMapping("/showLoginPage")
	public String showLoginPage() {
		return "fancy-login";
	}
	
	@GetMapping("/access-denied")
	public String accessDenied() {
		return "access-denied";
	}
}
