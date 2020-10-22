package com.employee.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@Column(name = "empid")
	@NotNull(message="is required!!")
	@Min(value=1,message="must be greater than 0!")
	private int empID;
	@Column(name = "name")
	@NotNull(message="is required!!")
	private String Name;

	public Employee() {

	}

	public Employee(int empID, String name) {
		super();
		this.empID = empID;
		Name = name;
	}

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

}
