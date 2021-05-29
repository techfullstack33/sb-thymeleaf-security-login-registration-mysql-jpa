package com.techfs.sb.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.techfs.sb.model.Employee;
import com.techfs.sb.model.Role;
import com.techfs.sb.repository.EmployeeRepository;
import com.techfs.sb.web.dto.EmployeeRegistrationDto;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}



	@Override
	public Employee save(EmployeeRegistrationDto registrationDto) {
 
		Employee employee = new Employee(
				registrationDto.getFirstName(), 
				registrationDto.getLastName(), 
				registrationDto.getEmail(),
				registrationDto.getCountry(),
				passwordEncoder.encode(registrationDto.getPassword()), 
				Arrays.asList(new Role("ROLE_EMPLOYEE")));
		
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}
	

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Employee emp = employeeRepository.findByEmail(email);
		if(emp == null) {
			throw new UsernameNotFoundException("Please check the username or password!");
		}
		return new User(emp.getEmail(), emp.getPassword(), mapRolesToAuthorities(emp.getRoles()));
	}
	
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
		
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
			
	}
	
	

}
