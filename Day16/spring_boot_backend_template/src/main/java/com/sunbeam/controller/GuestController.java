package com.sunbeam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.DTO.ApiResponse;
import com.sunbeam.DTO.GuestReqDTO;
import com.sunbeam.service.GuestService;

@RestController
@RequestMapping("/guests")
public class GuestController {
	
	@Autowired
	private GuestService guestService;
	
	@PostMapping
	public ResponseEntity<?> registerGuest(@RequestBody GuestReqDTO dto){
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(guestService.registerGuest(dto));
		}catch(RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));
		}
	}
}
