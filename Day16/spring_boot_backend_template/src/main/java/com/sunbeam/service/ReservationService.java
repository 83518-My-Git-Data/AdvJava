package com.sunbeam.service;

import java.util.Optional;

import com.sunbeam.DTO.ApiResponse;
import com.sunbeam.DTO.ReservationReqDTO;
import com.sunbeam.DTO.ReservationResDTO;
import com.sunbeam.entity.Reservation;

public interface ReservationService {
	ApiResponse makeReservation(ReservationReqDTO reserveDTO, Long guestId); 
	
}
