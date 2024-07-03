package com.sunbeam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.entity.Employee;
import com.sunbeam.services.EmployeeService;

@RestController
@RequestMapping
public class EmployeeController {
	
	
	@Autowired
	private EmployeeService employeeService;
	@GetMapping
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees(); 
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> saveEmployee(@RequestBody Employee employee ) {
		
		return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.saveEmployee(employee));
	}
}
