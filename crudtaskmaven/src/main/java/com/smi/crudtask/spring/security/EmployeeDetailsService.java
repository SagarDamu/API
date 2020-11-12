package com.smi.crudtask.spring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.smi.crudtask.spring.model.Employee;

@Service
public class EmployeeDetailsService implements UserDetailsService {

	@Autowired
	private SecurityRepository securityRepository; 
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Employee employee = securityRepository.findByUserName(email);
		if(employee == null)
			throw new UsernameNotFoundException("Employee Not Found");
		
		return new EmployeePrincipal(employee);
	}

}
