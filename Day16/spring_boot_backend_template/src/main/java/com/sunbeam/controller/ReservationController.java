package com.sunbeam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.DTO.ReservationReqDTO;
import com.sunbeam.service.ReservationService;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
	
	@Autowired
	private ReservationService resService;
	
	@PostMapping("/{guestId}")
	public ResponseEntity<?> makeReservation(@RequestBody ReservationReqDTO dto, @PathVariable Long guestId){
		try {
			return ResponseEntity.ok(resService.makeReservation(dto, guestId));
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	
	}
}
