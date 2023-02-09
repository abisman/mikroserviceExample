package com.example.microservicesBooking.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.microservicesBooking.model.Booking;

@Repository
public interface BookingRepository extends CrudRepository<Booking, Long> {
	
}
