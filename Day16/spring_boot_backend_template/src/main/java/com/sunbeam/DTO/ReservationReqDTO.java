package com.sunbeam.DTO;

import java.time.LocalDate;

import javax.validation.constraints.FutureOrPresent;

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
public class ReservationReqDTO {
	@FutureOrPresent
	private LocalDate checkInDate;
	@FutureOrPresent
	private LocalDate checkOutDate;
	private Long roomId;
}
