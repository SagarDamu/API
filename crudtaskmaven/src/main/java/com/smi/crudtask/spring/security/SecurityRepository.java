package com.smi.crudtask.spring.security;

import org.springframework.stereotype.Repository;

import com.smi.crudtask.spring.model.Employee;

@Repository
public interface SecurityRepository {

	Employee findByUserName(String email); // Login User
	
}
