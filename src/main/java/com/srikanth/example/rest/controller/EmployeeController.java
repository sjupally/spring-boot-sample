package com.srikanth.example.rest.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/employee")
public class EmployeeController {
	private List<Employee> emps = null;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<EmployeeResponse> getEmployee() {
		emps = new ArrayList<Employee>();
		emps.add(new Employee("Andrew", "andrew@oracle.com", 5000, getADate(2010, 5, 4, 5, 0)));
		emps.add(new Employee("Bill", "bill@oracle.com", 6000, getADate(2011, 3, 24, 9, 0)));
		emps.add(new Employee("Bob", "bob@oracle.com", 4000, getADate(2012, 2, 21, 9, 0)));
		emps.add(new Employee("Gary", "gary@oracle.com", 3000, getADate(2014, 3, 14, 4, 0)));
		emps.add(new Employee("George", "george@oracle.com", 3000, getADate(2014, 3, 14, 4, 0)));
		emps.add(new Employee("Jeff", "jeff@oracle.com", 3000, getADate(2014, 3, 14, 4, 0)));
		emps.add(new Employee("Jerry", "jerry@oracle.com", 5000, getADate(2010, 5, 4, 5, 0)));
		emps.add(new Employee("Shay", "Shay@oracle.com", 5000, getADate(2012, 3, 4, 6, 0)));
		EmployeeResponse empResponse = new EmployeeResponse();
		empResponse.setEmps(emps);
		return new ResponseEntity<>(empResponse, HttpStatus.OK);
	}

	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public ResponseEntity<String> getName(@PathVariable String name) {
		log.debug("getName method called : ");

		String response = "Hello " + name + "! Welcome to Oracle MAF Application.";

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	private Date getADate(int y, int m, int d, int h, int mi) {
		Calendar c1 = Calendar.getInstance();
		c1.set(y, m, d, h, mi);
		Date retDate = c1.getTime();
		return retDate;
	}
}