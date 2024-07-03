package com.sunbeam.DTO;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;



@NoArgsConstructor
@Getter
@Service
@ToString
public class GuestReqDTO {
	
	private String firstName;
	private String lastName;
	private String email;
	private LocalDate dob;
}
