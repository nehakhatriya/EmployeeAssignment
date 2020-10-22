package com.employee.dao;

import java.util.List;

import com.employee.entity.Employee;

public interface EmployeeDAO {

	void saveEmployee(Employee employee);

	List<Employee> listEmployee();

	void deleteEmployee(int empid);

	List<Employee> listEmployee(String val);

	Employee getEmployee(int empid);

}