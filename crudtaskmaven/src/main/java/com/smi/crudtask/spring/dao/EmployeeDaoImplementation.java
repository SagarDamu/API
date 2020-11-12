package com.smi.crudtask.spring.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.smi.crudtask.spring.model.Employee;

@Repository
public class EmployeeDaoImplementation implements EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int save(Employee employee) {
		sessionFactory.getCurrentSession().save(employee);
		return employee.getEmployeeId();
	}

	@Override
	public List<Employee> getEmployee(int id) {
		List<Employee> employeeList = new ArrayList();
		Criteria criteria =  sessionFactory.getCurrentSession().createCriteria(Employee.class);
		criteria.add(Restrictions.eq("employeeId", id));
		employeeList = criteria.list();
		return employeeList;
	}

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> employeeList = sessionFactory.getCurrentSession().createQuery("from Employee").list();
		return employeeList;
	}

	@Override
	public void updateEmployeeRecord(int id, Employee employee) {
		Session session = sessionFactory.getCurrentSession();
		Employee oldEmployee = session.byId(Employee.class).load(id);
		oldEmployee.setAddress(employee.getAddress());
		oldEmployee.setAge(employee.getAge());
		oldEmployee.setContactNumber(employee.getContactNumber());
		oldEmployee.setDepartmentId(employee.getDepartmentId());
		oldEmployee.setEmail(employee.getEmail());
		oldEmployee.setEmployeeName(employee.getEmployeeName());
		oldEmployee.setSex(employee.getSex());

		session.flush();
	}

	@Override
	public void deleteEmployeeRecord(int id) {
		Session session = sessionFactory.getCurrentSession();
		Employee employee = session.byId(Employee.class).load(id);
		session.delete(employee);

	}

}
