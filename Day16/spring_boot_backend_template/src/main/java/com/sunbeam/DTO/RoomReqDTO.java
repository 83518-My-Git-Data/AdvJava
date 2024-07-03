package com.sunbeam.DTO;



import com.sunbeam.entity.Type;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class RoomReqDTO {
	private int roomNumber;
	private Type roomType;
	private double price;

}
