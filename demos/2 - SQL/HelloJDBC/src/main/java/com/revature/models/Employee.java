package com.revature.models;

import java.time.LocalDate;

public class Employee {
	/*
	 * - Employees
 * 			+ id (PK)
 * 			+ first_name
 * 			+ last_name
 * 			+ birthdate
 * 			+ monthly_income
 * 			+ department_id (foreign key) (unique identifer that is a PK in another table)
 * 			+ hire_date
 * 			+ job_title
 * 			+ email
	 */

	private int employeeId;
	private String employeeFirstName;
	private String employeeLastName;
	private LocalDate employeeBirthdate;
	private double employeeMonthlyIncome;
	private Department employeeDepartment;
	private LocalDate employeeHiredate;
	private String employeeJobTitle;
	private String employeeEmail;
	
	public Employee() {
		super();
	}

	public Employee(String employeeFirstName, String employeeLastName, LocalDate employeeBirthdate,
			double employeeMonthlyIncome, Department employeeDepartment, LocalDate employeeHiredate,
			String employeeJobTitle, String employeeEmail) {
		super();
		this.employeeFirstName = employeeFirstName;
		this.employeeLastName = employeeLastName;
		this.employeeBirthdate = employeeBirthdate;
		this.employeeMonthlyIncome = employeeMonthlyIncome;
		this.employeeDepartment = employeeDepartment;
		this.employeeHiredate = employeeHiredate;
		this.employeeJobTitle = employeeJobTitle;
		this.employeeEmail = employeeEmail;
	}

	public Employee(int employeeId, String employeeFirstName, String employeeLastName, LocalDate employeeBirthdate,
			double employeeMonthlyIncome, Department employeeDepartment, LocalDate employeeHiredate,
			String employeeJobTitle, String employeeEmail) {
		super();
		this.employeeId = employeeId;
		this.employeeFirstName = employeeFirstName;
		this.employeeLastName = employeeLastName;
		this.employeeBirthdate = employeeBirthdate;
		this.employeeMonthlyIncome = employeeMonthlyIncome;
		this.employeeDepartment = employeeDepartment;
		this.employeeHiredate = employeeHiredate;
		this.employeeJobTitle = employeeJobTitle;
		this.employeeEmail = employeeEmail;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeFirstName() {
		return employeeFirstName;
	}

	public void setEmployeeFirstName(String employeeFirstName) {
		this.employeeFirstName = employeeFirstName;
	}

	public String getEmployeeLastName() {
		return employeeLastName;
	}

	public void setEmployeeLastName(String employeeLastName) {
		this.employeeLastName = employeeLastName;
	}

	public LocalDate getEmployeeBirthdate() {
		return employeeBirthdate;
	}

	public void setEmployeeBirthdate(LocalDate employeeBirthdate) {
		this.employeeBirthdate = employeeBirthdate;
	}

	public double getEmployeeMonthlyIncome() {
		return employeeMonthlyIncome;
	}

	public void setEmployeeMonthlyIncome(double employeeMonthlyIncome) {
		this.employeeMonthlyIncome = employeeMonthlyIncome;
	}

	public Department getEmployeeDepartment() {
		return employeeDepartment;
	}

	public void setEmployeeDepartment(Department employeeDepartment) {
		this.employeeDepartment = employeeDepartment;
	}

	public LocalDate getEmployeeHiredate() {
		return employeeHiredate;
	}

	public void setEmployeeHiredate(LocalDate employeeHiredate) {
		this.employeeHiredate = employeeHiredate;
	}

	public String getEmployeeJobTitle() {
		return employeeJobTitle;
	}

	public void setEmployeeJobTitle(String employeeJobTitle) {
		this.employeeJobTitle = employeeJobTitle;
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeFirstName=" + employeeFirstName + ", employeeLastName="
				+ employeeLastName + ", employeeBirthdate=" + employeeBirthdate + ", employeeMonthlyIncome="
				+ employeeMonthlyIncome + ", employeeDepartment=" + employeeDepartment + ", employeeHiredate="
				+ employeeHiredate + ", employeeJobTitle=" + employeeJobTitle + ", employeeEmail=" + employeeEmail
				+ "]";
	}
}
