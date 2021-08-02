package com.java.curdOperations.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//mark class as an Entity  
@Entity
//defining Table name 
@Table(name = "Employee")
public class Employee {

	// Defining Employee id as primary key
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "FirstName")
	private String EmpFirstName;
	@Column(name = "LastName")
	private String EmpLastName;
	@Column(name = "Job")
	private String Job;
	@Column(name = "ManagerName")
	private String Manager;
	@Column(name = "HireDate")
	private Date HireDate;
	@Column(name = "Salary")
	private int Salary;
	@Column(name = "Commission")
	private int Commission;
	@Column(name = "DeptCode")
	private int DeptCode;

	public Employee(String empFirstName, String empLastName, String job, String manager, Date hireDate, int salary,
			int commission, int deptCode) {
		super();
		this.EmpFirstName = empFirstName;
		this.EmpLastName = empLastName;
		this.Job = job;
		this.Manager = manager;
		this.HireDate = hireDate;
		this.Salary = salary;
		this.Commission = commission;
		this.DeptCode = deptCode;
	}

	public int getid() {
		return id;
	}

	public void setid(int empId) {
		id = empId;
	}

	public String getEmpFirstName() {
		return EmpFirstName;
	}

	public void setEmpFirstName(String empFirstName) {
		EmpFirstName = empFirstName;
	}

	public String getEmpLastName() {
		return EmpLastName;
	}

	public void setEmpLastName(String empLastName) {
		EmpLastName = empLastName;
	}

	public String getJob() {
		return Job;
	}

	public void setJob(String job) {
		Job = job;
	}

	public String getManager() {
		return Manager;
	}

	public void setManager(String manager) {
		Manager = manager;
	}

	public Date getHireDate() {
		return HireDate;
	}

	public void setHireDate(Date hireDate) {
		HireDate = hireDate;
	}

	public int getSalary() {
		return Salary;
	}

	public void setSalary(int salary) {
		Salary = salary;
	}

	public int getCommission() {
		return Commission;
	}

	public void setCommission(int commission) {
		Commission = commission;
	}

	public int getDeptCode() {
		return DeptCode;
	}

	public void setDeptCode(int deptCode) {
		DeptCode = deptCode;
	}

}
