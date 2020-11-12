package com.smi.crudtask.spring.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.smi.crudtask.spring.model.Department;

@Repository
public class DepartmentDaoImplement implements DepartmentDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public int save(Department department) {
		sessionFactory.getCurrentSession().save(department);
		return department.getDepartmentId();
	}

	@Override
	public List<Department> getDepartment(int id) {
		List<Department> departmentList = new ArrayList();
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Department.class);
		criteria.add(Restrictions.eq("departmentId", id));
		departmentList = criteria.list();
		return departmentList;
	}

	@Override
	public List<Department> getAllDepartment() {
		List<Department> departmentList = sessionFactory.getCurrentSession().createQuery("from Department").list();
		return departmentList;
	}

	@Override
	public void deleteDepartment(int id) {
		Session session = sessionFactory.getCurrentSession();
		Department department = session.byId(Department.class).load(id);
		session.delete(department);
		
	}

}
