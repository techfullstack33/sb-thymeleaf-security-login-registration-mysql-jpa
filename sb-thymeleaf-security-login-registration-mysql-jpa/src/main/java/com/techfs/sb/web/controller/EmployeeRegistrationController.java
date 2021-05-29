package com.techfs.sb.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.techfs.sb.service.EmployeeService;
import com.techfs.sb.web.dto.EmployeeRegistrationDto;

@Controller
public class EmployeeRegistrationController {

	@Autowired
	EmployeeService employeeService;

	public EmployeeRegistrationController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	@PostMapping("/registration")
	public String registerEmployee(@ModelAttribute EmployeeRegistrationDto erDto) {
		System.out.println(erDto);
		employeeService.save(erDto);
		return "redirect:/home?success";

	}

}
