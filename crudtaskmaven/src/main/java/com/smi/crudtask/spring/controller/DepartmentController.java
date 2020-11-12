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

import com.smi.crudtask.spring.model.Department;
import com.smi.crudtask.spring.service.DepartmentService;

@CrossOrigin("*")
@RestController
public class DepartmentController {

	@Autowired
	DepartmentService departmentService;
	
	@GetMapping("/getalldepartment")
	public ResponseEntity<List<Department>> getAllDepartment(){
		List<Department> depList = departmentService.getAllDepartment();
		return ResponseEntity.ok().body(depList);
	}
	
	@PostMapping("/insertdepartment")
	public ResponseEntity<?> save(@RequestBody Department department){
		int id = departmentService.save(department);
		return ResponseEntity.ok().body("The department has been added with the Id : "+id);
	}
	
	@GetMapping("/deletedepartment/{id}")
	public ResponseEntity<?> deleteDepartment(@PathVariable("id") int id){
		departmentService.deleteDepartment(id);
		return ResponseEntity.ok().body("Department has been deleted");
	}
	
	@GetMapping("/getdepartment/{id}")
	public List<Department> getDepartment(@PathVariable int id){
		List<Department> departmentList = departmentService.getDepartment(id);
		return departmentList;
 	}
}
