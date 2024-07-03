package com.sunbeam.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name="employees")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="emp_id")
	private Long empId;
	@Column(name="first_name", length=30)
	private String firstName;
	@Column(name="last_name", length=30)
	private String lastName;
	@Column(length=30 , unique = true)
	private String email;
	@Column(length=30)
	private String password;
	@Column(length=30)
	private String department;
	@Column(length=30)
	private String location;
	private double salary;
	private LocalDate joinDate;
}
