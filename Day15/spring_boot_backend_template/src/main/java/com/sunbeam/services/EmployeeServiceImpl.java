package com.sunbeam.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.dao.EmployeeDao;
import com.sunbeam.entity.Employee;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	public List<Employee> getAllEmployees() {
		
		return employeeDao.findAll();
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		
		return employeeDao.save(employee);
	}
	
}
