package com.example.microservicesRoom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservicesRoom.model.Room;
import com.example.microservicesRoom.service.RoomService;

@RestController
public class RoomController {
	
	@Autowired
	private RoomService roomService;
	
	@RequestMapping("/create")
	public String create(@RequestParam String roomType, @RequestParam String amountOfPeople){
		Room r = new Room();
		
		try {
			int peopleAmount = Integer.valueOf(amountOfPeople);
			
			r = roomService.create(roomType, peopleAmount);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return r != null ? r.toString() : "Ada yang salah";
	}
	
	@RequestMapping("/getRoom")
	public Room getRoomByCode(@RequestParam String code) {
		return roomService.findById(code);
	}
	
}
