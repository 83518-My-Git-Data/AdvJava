package com.sunbeam.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.DTO.ApiResponse;
import com.sunbeam.DTO.RoomReqDTO;
import com.sunbeam.service.RoomService;

@RestController
@RequestMapping("/rooms")
public class RoomController {
	@Autowired
	private RoomService roomService;
	
	@PostMapping
	public ResponseEntity<?> addNewRoom(@RequestBody RoomReqDTO dto){
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(roomService.addNewRoom(dto));
		}catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));
		}	
	}
	
	@GetMapping
	public ResponseEntity<?> getAllRooms(){
		try {
			return ResponseEntity.ok(roomService.getAllRooms());
		}catch(RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));
		}
	}
	
	@GetMapping("/availRooms/{date}")
	public ResponseEntity<?> getAvialableRooms(@PathVariable String date){
		try {
			return ResponseEntity.ok(roomService.getAvailableRooms(date));
		}catch(RuntimeException e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		
	}
}
