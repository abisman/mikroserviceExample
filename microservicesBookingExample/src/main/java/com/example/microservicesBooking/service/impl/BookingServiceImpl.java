package com.example.microservicesBooking.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.microservicesBooking.model.Booking;
import com.example.microservicesBooking.repository.BookingRepository;
import com.example.microservicesBooking.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService {
	
	@Autowired
	private BookingRepository bookingRepository;

	@Override
	public List<Booking> getAll() {
		List<Booking> bookings = (List<Booking>) bookingRepository.findAll();
		return bookings;
	}

	@Override
	public Booking create(String name, String date, String price, String roomType, int amountOfPeople) {
		Booking booking = new Booking(name, date, price, roomType, amountOfPeople);
		return bookingRepository.save(booking);
	}
}
