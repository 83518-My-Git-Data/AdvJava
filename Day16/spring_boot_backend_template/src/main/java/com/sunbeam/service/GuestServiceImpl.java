package com.sunbeam.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.DAO.GuestDao;
import com.sunbeam.DTO.GuestReqDTO;
import com.sunbeam.DTO.GuestResDTO;
import com.sunbeam.entity.Guest;

@Service
@Transactional
public class GuestServiceImpl implements GuestService{

	@Autowired
	private GuestDao guestDao;
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public GuestResDTO registerGuest(GuestReqDTO guestReqDto) {
		Guest guest = mapper.map(guestReqDto, Guest.class);
		Guest persistentGuest = guestDao.save(guest);
		return mapper.map(guest, GuestResDTO.class);
	}
	
	
}
