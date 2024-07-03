package com.sunbeam.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "res_id")
	private Long reservationId;
	@ManyToOne
	@JoinColumn(name="guest_id", nullable = false)
	private Guest geust;
	private LocalDate checkInDate;
	private LocalDate checkOutDate;
	@ManyToOne
	@JoinColumn(name="room_id", nullable = false)
	private Room room;
	private double totalPrice;
}
