package com.sunbeam.DAO;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.entity.Guest;

public interface GuestDao extends JpaRepository<Guest, Long>{
	Optional<Guest> findByFirstName(String firstName);
}
