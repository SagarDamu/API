package com.smi.crudtask.spring.dao;

import java.util.List;

import com.smi.crudtask.spring.model.Department;

public interface DepartmentDao {

	int save(Department department); // Insert

	List<Department> getDepartment(int id); // Select the particular department

	List<Department> getAllDepartment(); // Select all the department record

	void deleteDepartment(int id); // Delete the particular department;
}
