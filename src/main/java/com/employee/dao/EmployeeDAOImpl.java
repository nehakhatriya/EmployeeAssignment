package com.employee.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.employee.entity.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	SessionFactory sessionfactory;

	@Override
	public void saveEmployee(Employee employee) {
		Session session = sessionfactory.getCurrentSession();
		session.save(employee);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> listEmployee() {
		Session session = sessionfactory.getCurrentSession();
		Query query = session.createQuery("from Employee", Employee.class);
		return query.getResultList();
	}

	@Override
	public void deleteEmployee(int empid) {
		Session session = sessionfactory.getCurrentSession();
		Query query = session.createQuery("delete from Employee where empid=:employeeid");
		query.setParameter("employeeid",empid);
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> listEmployee(String val) {
		Session session = sessionfactory.getCurrentSession();
		if(val.equals("id"))
		{
			Query query = session.createQuery("from Employee order by empid");
			return query.getResultList();
		}	
		else {
			Query query = session.createQuery("from Employee order by name");
			return query.getResultList();
		}
	
	}

	@Override
	public Employee getEmployee(int empid) {
		Session session = sessionfactory.getCurrentSession();
		return session.get(Employee.class, empid);
	}

}
