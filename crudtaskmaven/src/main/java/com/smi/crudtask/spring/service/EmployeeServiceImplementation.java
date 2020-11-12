package com.smi.crudtask.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smi.crudtask.spring.dao.EmployeeDao;
import com.smi.crudtask.spring.model.Employee;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Override
	@Transactional
	public int save(Employee employee) {
		return employeeDao.save(employee);
	}

	@Override
	@Transactional
	public List<Employee> getEmployee(int id) {
		return employeeDao.getEmployee(id);
	}

	@Override
	@Transactional
	public List<Employee> getAllEmployee() {
		return employeeDao.getAllEmployee();
	}

	@Override
	@Transactional
	public void updateEmployeeRecord(int id, Employee employee) {
		employeeDao.updateEmployeeRecord(id, employee);

	}

	@Override
	@Transactional
	public void deleteEmployeeRecord(int id) {
		employeeDao.deleteEmployeeRecord(id);
	}

}
