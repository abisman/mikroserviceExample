package com.example.microservicesBooking.service;

import java.util.List;

import com.example.microservicesBooking.model.Booking;

public interface BookingService {
	List<Booking> getAll();
	
	Booking create(String name, String date, String roomCode, Double totalPrice, int totalNights, int amountOfPeople);
}
