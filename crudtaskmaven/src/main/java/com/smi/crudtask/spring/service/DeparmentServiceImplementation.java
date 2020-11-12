package com.smi.crudtask.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smi.crudtask.spring.dao.DepartmentDao;
import com.smi.crudtask.spring.model.Department;

@Service
public class DeparmentServiceImplementation implements DepartmentService {

	@Autowired
	DepartmentDao departmentDao;

	@Override
	@Transactional
	public int save(Department department) {
		return departmentDao.save(department);
	}

	@Override
	@Transactional
	public List<Department> getDepartment(int id) {
		return departmentDao.getDepartment(id);
	}

	@Override
	@Transactional
	public List<Department> getAllDepartment() {
		return departmentDao.getAllDepartment();
	}

	@Override
	@Transactional
	public void deleteDepartment(int id) {
		departmentDao.deleteDepartment(id);

	}

}
