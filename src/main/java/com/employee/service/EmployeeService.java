package com.employee.service;

import java.util.List;


import com.employee.entity.Employee;

public interface EmployeeService {

	void saveEmployee(Employee employee);

	List<Employee> listEmployees();

	void deleteEmployee(int empid);

	void updateEmployee(Employee employee);

	List<Employee> listEmployees(String val);

	Employee getEmployee(int empid);


}