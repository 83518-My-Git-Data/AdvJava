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
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="guests")
public class Guest {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="guest_id")
	private Long guestId;
	@Column(name = "first_name", length=30)
	private String firstName;
	@Column(name = "last_name", length=30)
	private String lastName;
	@Column(unique = true, length = 30)
	private String email;
	private LocalDate dob;
}
