package com.smi.crudtask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smi.crudtask.model.Department;
import com.smi.crudtask.service.DepartmentService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class DepartmentController {

	@Autowired
	@Qualifier("department")
	DepartmentService departmentservice;

	@RequestMapping("/adddepartment")
	public String addDepartment(@RequestBody Department department) {
		if (departmentservice.addDepartment(department))
			return "Department Added Succesfuly";
		else
			return "Department Addition Failed";
	}

	@RequestMapping("/deletedepartment/{id}")
	public String deleteDepartment(@PathVariable int id) {
		if (departmentservice.delete(id))
			return "Department Deleted";
		else
			return "Department Deletion Failed";
	}

}
