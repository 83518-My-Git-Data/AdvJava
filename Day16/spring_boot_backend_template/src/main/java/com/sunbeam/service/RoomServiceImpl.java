package com.sunbeam.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.DAO.ReservationDao;
import com.sunbeam.DAO.RoomDao;
import com.sunbeam.DTO.ApiResponse;
import com.sunbeam.DTO.RoomReqDTO;
import com.sunbeam.custom_exceptions.ResourceNotFoundException;
import com.sunbeam.entity.Reservation;
import com.sunbeam.entity.Room;

@Service
@Transactional
public class RoomServiceImpl implements RoomService{

	@Autowired
	private RoomDao roomDao;
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private ReservationDao reserveDao;
	
	@Override
	public ApiResponse addNewRoom(RoomReqDTO roomDto) {
		
		Room room = mapper.map(roomDto, Room.class);
		roomDao.save(room);
		return new ApiResponse("Room Added With Id "+ room.getRoomId());
	}

	@Override
	public List<Room> getAllRooms() {
		
		return roomDao.findAll();
	}

	@Override
	public List<Room> getAvailableRooms(String checkInDate) {
		LocalDate date = LocalDate.parse(checkInDate);
		List<Reservation> reserveList = reserveDao.getReservedRoomDetails(date);
		List<Room> rooms = roomDao.findAll();
		Collections.sort(reserveList, (a,b)-> a.getRoom().getRoomId().compareTo(b.getRoom().getRoomId()));
//		System.out.println(reserveList.toString());
		
		/*
		 * for (Room room : rooms) { System.out.println(room); }
		 */
		for (Reservation r : reserveList) {
			for (Room room : rooms) {
				System.out.println(r.getRoom().getRoomId() == room.getRoomId());
				if(r.getRoom().getRoomId() == room.getRoomId()) {
					System.out.println(r.getRoom().getRoomId()+" , "+ room.getRoomId());
				rooms.remove(room);
					System.out.println(rooms+ "inside foreach");
				}
				break;
			}
		}
		for (Room room : rooms) {
			System.out.println(room);
		}
		
		System.out.println(rooms.isEmpty());
		System.out.println(rooms+ "Outside foreach");
		
		return rooms;
	}

	
	
	
}
