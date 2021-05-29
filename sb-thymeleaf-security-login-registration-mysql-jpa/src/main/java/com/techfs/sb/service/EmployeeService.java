package com.techfs.sb.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.techfs.sb.model.Employee;
import com.techfs.sb.web.dto.EmployeeRegistrationDto;

public interface EmployeeService extends UserDetailsService {

	Employee save(EmployeeRegistrationDto registrationDto);

	List<Employee> getAllEmployees();

}
