package com.example.microservicesBooking.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.microservicesBooking.model.Booking;
import com.example.microservicesBooking.service.BookingService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/hello")
	public String hello(@RequestParam(value="name", defaultValue="World") String name,
			@RequestParam(value="age", defaultValue="0") String age) {
		String sentence = String.format("Hello %s!", name) + 
				(Integer.valueOf(age) < 14 ? " Kamu masih terlalu muda!" : 
					String.format(" Umur kamu adalah %s", age));
		return sentence;
	}
	
	@RequestMapping("/create")
	public String create(@RequestParam String name, @RequestParam String date, @RequestParam String price, @RequestParam String roomTypeCode) {
		String url = "http://localhost:8081/getRoom?code=" + roomTypeCode;
		
		String str = restTemplate.getForObject(url, String.class);
		
		try {
			JSONObject json = new JSONObject(str);
			
			String roomType = json.getString("roomType");
			int amountOfPeople = json.getInt("amountOfPeople");
			
			Booking b = bookingService.create(name, date, price, roomType, amountOfPeople);
			return b.toString();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "Something is wrong";
	}
	
	@RequestMapping("/allBookingList")
	public List<Booking> getAll() {
		return bookingService.getAll();
	}
}
