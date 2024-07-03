package com.sunbeam.DAO;

import java.time.LocalDate;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.sunbeam.entity.Reservation;

public interface ReservationDao extends JpaRepository<Reservation, Long>{ 
	@Query("select r from Reservation r where r.room.id = :id and (r.checkInDate between :inDate and :outDate or r.checkOutDate between :inDate and :outDate)")
	List<Reservation> getReservations(LocalDate inDate,LocalDate outDate, Long id);
	
	@Query("select r from Reservation r where :inDate between r.checkInDate and r.checkOutDate")
	List<Reservation> getReservedRoomDetails(LocalDate inDate);
}
