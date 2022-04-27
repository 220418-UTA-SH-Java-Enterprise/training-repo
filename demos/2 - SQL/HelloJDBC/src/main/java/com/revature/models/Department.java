package com.revature.models;

public class Department {
	
	private int departmentId;
	private String departmentName;
	private double departmentMonthlyBudget;
	
	//no-args constructor
	public Department() {
		super();
	}

	//this constructor is useful for SQL insert queries that we will be making with JDBC
	public Department(String departmentName, double departmentMonthlyBudget) {
		super();
		this.departmentName = departmentName;
		this.departmentMonthlyBudget = departmentMonthlyBudget;
	}

	//all-args constructor
	public Department(int departmentId, String departmentName, double departmentMonthlyBudget) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.departmentMonthlyBudget = departmentMonthlyBudget;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public double getDepartmentMonthlyBudget() {
		return departmentMonthlyBudget;
	}

	public void setDepartmentMonthlyBudget(double departmentMonthlyBudget) {
		this.departmentMonthlyBudget = departmentMonthlyBudget;
	}

	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName
				+ ", departmentMonthlyBudget=" + departmentMonthlyBudget + "]";
	}
}
