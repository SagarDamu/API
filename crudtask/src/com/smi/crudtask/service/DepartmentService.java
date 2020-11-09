package com.smi.crudtask.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.smi.crudtask.model.Department;

public class DepartmentService {

	SessionFactory sessionFactory;
	Session session;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		this.session = this.sessionFactory.openSession();
	}

	public boolean addDepartment(Department department) {
		Transaction transaction = session.beginTransaction();
		boolean b = false;
		try {
			if (session.save(department) != null)
				b = true;
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
			Query query = session.createQuery("delete from Department where employeeId=:id");
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

//public List<Department> selectEmployee(int id) {
//		
//		List<Department> departmentList = new ArrayList<Department>();
//		Criteria criteria = session.createCriteria(Department.class);
//		criteria.add(Restrictions.eq("departmentId", id));
//		departmentList = criteria.list();
//		if(departmentList!=null)
//			return departmentList;
//		else
//			return null;
//	}

}
