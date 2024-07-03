package com.sunbeam.services;


import java.util.List;
import java.util.Optional;

import com.sunbeam.entity.Employee;

public interface EmployeeService {
	List<Employee> getAllEmployees();
	Employee saveEmployee(Employee employee);
}
