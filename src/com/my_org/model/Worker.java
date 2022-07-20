package com.my_org.model;

import java.sql.Timestamp;

public class Worker {
	
	private int workerId;
	private String firstname;
	private String lastname;
	private int salary;
	private Timestamp joiningdate;
	private String department;
	private String email;
	
	public Worker() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Worker(int workerId, String firstname, String lastname, int salary, Timestamp joiningdate,
			String department,String email) {
		super();
		this.workerId = workerId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.salary = salary;
		this.joiningdate = joiningdate;
		this.department = department;
		this.email = email;
	}

	public int getWorkerId() {
		return workerId;
	}

	public void setWorkerId(int workerId) {
		this.workerId = workerId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Timestamp getJoiningdate() {
		return joiningdate;
	}

	public void setJoiningdate(Timestamp joiningdate) {
		this.joiningdate = joiningdate;
	}

	
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

	@Override
	public String toString() {
		return "Worker [workerId=" + workerId + ", firstname=" + firstname + ", lastname=" + lastname + ", salary="
				+ salary + ", joiningdate=" + joiningdate + ", department=" + department + ", email=" + email + "]";
	}
	
	

}
