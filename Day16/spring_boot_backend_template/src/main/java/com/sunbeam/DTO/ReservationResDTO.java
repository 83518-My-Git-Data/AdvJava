package com.sunbeam.DTO;

import java.time.LocalDate;

import com.sunbeam.entity.Guest;
import com.sunbeam.entity.Room;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


	@NoArgsConstructor
	@Getter
	@Setter
	@ToString
	public class ReservationResDTO {
		private Long reservationId;
		private LocalDate checkInDate;
		private LocalDate checkOutDate;
}
