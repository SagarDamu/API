package com.smi.crudtask.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.smi.crudtask.model.Employee;
import com.smi.crudtask.model.Example;
import com.smi.crudtask.service.EmployeeService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {

	@Autowired
	@Qualifier("employee")
	EmployeeService employeeService;

	@RequestMapping(value = "/insertemployee", produces = "application/json",method = RequestMethod.POST)
	public String insertEmployee(@RequestBody Employee employee) {
		if (employeeService.insert(employee))
			return "Inserted";
		else
			return "Insertion Failed";
	}

	@RequestMapping(value = "/deleteemployee/{id}",produces = "application/json",method = RequestMethod.GET)
	public String deleteEmployee(@PathVariable int id) {
		if (employeeService.delete(id))
			return "Data Deleted";
		else
			return "Data deletion Failed";
	}

	@GetMapping("/getemployee/{id}")
	public List<Employee> selectEmployee(@PathVariable int id) {
		List<Employee> employeeList = employeeService.selectEmployee(id);
		return employeeList;
	}

}
