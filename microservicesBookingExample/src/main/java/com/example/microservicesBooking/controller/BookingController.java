package com.example.microservicesBooking.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.microservicesBooking.model.Booking;
import com.example.microservicesBooking.service.BookingService;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/")
	public String index() {
		return "Halo euy";
	}
	
	@GetMapping("/homepage")
	public String homepage(@RequestParam(value="name", defaultValue="World") String name,
						   @RequestParam(value="age", defaultValue="0") String age, Model model) {
		String sentence = String.format("Hello %s!", name) + 
				(Integer.valueOf(age) < 14 ? " Kamu masih terlalu muda!" : 
					String.format(" Umur kamu adalah %s", age));
		model.addAttribute("welcome", sentence);
		return sentence;
	}
	
	@RequestMapping("/create")
	public ResponseEntity<Object> create(@RequestParam String name, @RequestParam String date, @RequestParam String roomCode, @RequestParam String totalNights, @RequestParam String amountOfPeople) {
		String url = "http://localhost:8082/getRoomWithPrice?code=" + roomCode;
		Map<String, Object> responseBody = new LinkedHashMap<>();
		responseBody.put("status", "Bad Request");

		try {
			String str = restTemplate.getForObject(url, String.class);
			JSONObject json = new JSONObject(str);

			int stay = Integer.parseInt(totalNights);
			int amount = Integer.parseInt(amountOfPeople);
			double price = json.getDouble("roomPrice") * stay;
			
			Booking b = bookingService.create(name, date, roomCode, price, stay, amount);

			responseBody.put("status", "Booking Created!");
			responseBody.put("data", b);
			return ResponseEntity.ok().body(responseBody);
			
		}catch(Exception e) {
			responseBody.put("reason", e.getMessage());
			e.printStackTrace();
		}
		
		return ResponseEntity.badRequest().body(responseBody);
	}
	
	@RequestMapping("/allBookingList")
	public List<Booking> getAll() {
		return bookingService.getAll();
	}
}
