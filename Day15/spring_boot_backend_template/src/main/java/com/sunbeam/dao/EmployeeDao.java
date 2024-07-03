package com.sunbeam.dao;

import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.entity.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Long>{

}
