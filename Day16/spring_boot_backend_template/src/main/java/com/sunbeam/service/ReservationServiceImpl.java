package com.sunbeam.service;



import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.sunbeam.DAO.GuestDao;
import com.sunbeam.DAO.ReservationDao;
import com.sunbeam.DAO.RoomDao;
import com.sunbeam.DTO.ApiResponse;
import com.sunbeam.DTO.ReservationReqDTO;
import com.sunbeam.DTO.ReservationResDTO;
import com.sunbeam.custom_exceptions.ResourceNotFoundException;
import com.sunbeam.entity.Guest;
import com.sunbeam.entity.Reservation;
import com.sunbeam.entity.Room;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {
	@Autowired
	private GuestDao guestDao;
	
	@Autowired
	private RoomDao roomDao;
	
	@Autowired
	private ModelMapper mapper;

	@Autowired
	private ReservationDao reservationDao;
	@Override
	public ApiResponse makeReservation(ReservationReqDTO reserveDTO, Long guestId) {
		List<Reservation> reservationList = reservationDao.getReservations(reserveDTO.getCheckInDate(), reserveDTO.getCheckOutDate(), reserveDTO.getRoomId());
		if(reservationList.isEmpty()) {
		Guest guest = guestDao.findById(guestId).orElseThrow(()-> new ResourceNotFoundException("Guest not found!"));
		Room room = roomDao.findById(reserveDTO.getRoomId()).orElseThrow(()->new ResourceNotFoundException("Invalid Room Id"));
		Reservation reserve = mapper.map(reserveDTO, Reservation.class);
		reserve.setGeust(guest);
		reserve.setRoom(room);
		reserve.setTotalPrice((reserveDTO.getCheckOutDate().compareTo(reserveDTO.getCheckInDate()))*room.getPrice());
		reservationDao.save(reserve);
		return new ApiResponse("Reservation Successful!!");
		}
		else {
			return new ApiResponse("Room is not available for this time period!!");
		}
	}

}
