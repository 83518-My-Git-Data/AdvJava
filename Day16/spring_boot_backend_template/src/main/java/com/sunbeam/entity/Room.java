package com.sunbeam.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="rooms")
public class Room {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="room_id")
	private Long roomId;
	@Column(name = "room_no", unique = true)
	private int roomNumber;
	@Column(name = "room_type")
	@Enumerated(EnumType.STRING)
	private Type roomType;
	private double price;
}
