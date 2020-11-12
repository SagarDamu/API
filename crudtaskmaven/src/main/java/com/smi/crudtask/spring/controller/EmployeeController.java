package com.smi.crudtask.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.smi.crudtask.spring.model.Employee;
import com.smi.crudtask.spring.service.EmployeeService;





@CrossOrigin ("*")
@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/springsecurity")
	public String greetings() {
		return "Working";
	}

	@GetMapping("/getallemployee")
	public ResponseEntity<List<Employee>> getAllEmployee() {
		List<Employee> emplList = employeeService.getAllEmployee();
		return ResponseEntity.ok().body(emplList);
	}

	@PostMapping("/insertemployee")
	public ResponseEntity<?> save(@RequestBody Employee employee) {
		int id = employeeService.save(employee);
		return ResponseEntity.ok().body("Employee created with the Id : " + id);
	}

	@GetMapping("/getemployee/{id}")
	public List<Employee> getEmployee(@PathVariable("id") int id) {
		List<Employee> employee = employeeService.getEmployee(id);
		return employee;
	}

	@PostMapping("/updateemployee/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody Employee employee) {
		employeeService.updateEmployeeRecord(id, employee);
		return ResponseEntity.ok().body("Employee Record Updated");
	}
	
	@GetMapping("/deleteeployee/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id){
		employeeService.deleteEmployeeRecord(id);
		return ResponseEntity.ok().body("Employee Record has been deleted");
		
	}

}
