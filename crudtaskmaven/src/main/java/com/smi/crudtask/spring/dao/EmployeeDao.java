package com.smi.crudtask.spring.dao;

import java.util.List;

import com.smi.crudtask.spring.model.Employee;

public interface EmployeeDao {

	int save(Employee employee); // Insertion

	List<Employee> getEmployee(int id); // Selecting a single record

	List<Employee> getAllEmployee(); // Selecting the whole record

	void updateEmployeeRecord(int id, Employee employee); // Updating the record

	void deleteEmployeeRecord(int id); // Deleting the record
	
	
}
