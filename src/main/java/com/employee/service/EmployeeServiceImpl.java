package com.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.employee.dao.EmployeeDAO;
import com.employee.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDAO dao;

	@Override
	@Transactional
	public void saveEmployee(Employee employee) {
		dao.saveEmployee(employee);
	}

	@Override
	@Transactional
	public List<Employee> listEmployees() {
		return dao.listEmployee();
	}

	@Override
	@Transactional
	public void deleteEmployee(int empid) {
		dao.deleteEmployee(empid);
	}

	@Override
	@Transactional
	public void updateEmployee(Employee employee) {
		dao.deleteEmployee(employee.getEmpID());
		dao.saveEmployee(employee);
	}

	@Override
	@Transactional
	public List<Employee> listEmployees(String val) {
		return dao.listEmployee(val);
	}

	@Override
	@Transactional
	public Employee getEmployee(int empid) {
		return dao.getEmployee(empid);
	}
}
