package com.sunbeam.service;

import com.sunbeam.DTO.GuestReqDTO;
import com.sunbeam.DTO.GuestResDTO;

public interface GuestService {
	GuestResDTO registerGuest(GuestReqDTO guestReqDto);
}
