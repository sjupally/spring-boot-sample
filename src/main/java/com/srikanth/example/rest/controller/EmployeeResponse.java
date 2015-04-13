package com.srikanth.example.rest.controller;

import java.util.List;

public class EmployeeResponse {
	
	private List<Employee> emps;

	public List<Employee> getEmps() {
		return emps;
	}

	public void setEmps(List<Employee> emps) {
		this.emps = emps;
	}
}
