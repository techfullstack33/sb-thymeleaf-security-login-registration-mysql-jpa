package com.techfs.sb.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.techfs.sb.model.Employee;
import com.techfs.sb.service.EmployeeService;
import com.techfs.sb.web.dto.EmployeeRegistrationDto;

@Controller
public class MainController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping("/home")
	public String showHomePage(Model model) {
		// load all employees at page load
		List<Employee> empList = employeeService.getAllEmployees();
		model.addAttribute("empList", empList);

		return "home";

	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/welcome")
	public String welcome() {
		return "welcome";
	}

}
