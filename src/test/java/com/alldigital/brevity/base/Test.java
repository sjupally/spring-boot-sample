package com.alldigital.brevity.base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.srikanth.example.rest.controller.Employee;
import com.srikanth.example.rest.controller.EmployeeResponse;

public class Test {
	private static Collection<Employee> emps = new ArrayList<Employee>();

	public static void main(String[] args) {
		Test test = new Test();
		emps.addAll(test.getEmployees());
		System.out.println(emps);
	}

	private Collection<Employee> getEmployees() {
		EmployeeResponse employeeResponse = new EmployeeResponse();
		try {
			URL url = new URL("http://localhost:8080/employee");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
				employeeResponse = new ObjectMapper().readValue(output, EmployeeResponse.class);
			}
			conn.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return employeeResponse.getEmps();
	}
}
