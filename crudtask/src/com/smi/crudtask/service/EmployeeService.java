package com.smi.crudtask.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import com.smi.crudtask.model.Employee;
import com.smi.crudtask.model.Example;

public class EmployeeService {
	SessionFactory sessionFactory;
	Session session;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		this.session = this.sessionFactory.openSession();
	}

	public boolean insert(Employee employee) {
		Transaction transaction = session.beginTransaction();
		boolean b = false;
		try {
			if (session.save(employee) != null) {
				b = true;
			}
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	public boolean delete(int id) {
		Transaction transaction = session.beginTransaction();
		boolean b = false;
		try {
			Query query = session.createQuery("delete from Employee where employeeId=:id");
			query.setParameter("id", id);
			int q = query.executeUpdate();
			if (q > 0) {
				b = true;
			}
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	public List<Employee> selectEmployee(int id) {

		List<Employee> employeeList = new ArrayList<Employee>();
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.add(Restrictions.eq("employeeId", id));
		employeeList = criteria.list();
		if (employeeList != null)
			return employeeList;
		else
			return null;
	}
}
