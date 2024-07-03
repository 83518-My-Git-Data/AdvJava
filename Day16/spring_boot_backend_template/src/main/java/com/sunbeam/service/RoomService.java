package com.sunbeam.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


import com.sunbeam.DTO.ApiResponse;
import com.sunbeam.DTO.RoomReqDTO;
import com.sunbeam.entity.Room;



public interface RoomService {

	ApiResponse addNewRoom(RoomReqDTO roomDto);
	List<Room> getAllRooms();
	
	List<Room> getAvailableRooms(String checkInDate);
}
