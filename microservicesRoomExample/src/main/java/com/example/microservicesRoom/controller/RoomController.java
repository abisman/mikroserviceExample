package com.example.microservicesRoom.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservicesRoom.model.Room;
import com.example.microservicesRoom.service.RoomService;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
public class RoomController {
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private RoomService roomService;
	
	@RequestMapping("/create")
	public ResponseEntity<Object> create(@RequestParam String roomType, @RequestParam String roomName){
		Map<String, Object> responseBody = new LinkedHashMap<>();
		responseBody.put("status", "bad request");

		try {
			Room r = roomService.create(roomType, roomName);
			responseBody.put("status", "created!");
			responseBody.put("data", r);

			return ResponseEntity.ok().body(responseBody);
		} catch (Exception e) {
			responseBody.put("reason", e.getMessage());
			e.printStackTrace();
		}

		return ResponseEntity.badRequest().body(responseBody);
	}
	
	@RequestMapping("/getRoom")
	public Room getRoomByCode(@RequestParam String code) {
		return roomService.findById(code);
	}

	@RequestMapping("/getRoomWithPrice")
	public ResponseEntity<Object> getRoomByCodeWithPrice(@RequestParam String code) {
		Room room = roomService.findById(code);
		Map<String, Object> responseBody = new LinkedHashMap<>();

		String url = "http://localhost:8083/getPrice?roomCode=" + room.getRoomCode();

		try {
			String str = restTemplate.getForObject(url, String.class);
			JSONObject json = new JSONObject(str);
			responseBody.put("status", "Oke Sangat");
			responseBody.put("roomName", room.getRoomName());
			responseBody.put("roomCode", room.getRoomCode());
			responseBody.put("roomPrice", json.getDouble("roomPrice"));
		} catch(Exception e) {
			responseBody.put("status", "You get an error bruh");
			e.printStackTrace();
		}
		return ResponseEntity.ok(responseBody);
	}

	@RequestMapping("/getAllRoom")
	public ResponseEntity<Object> getAllRoom() {
		List<Room> roomList = roomService.findAll();
		Map<String, Object> responseBody = new LinkedHashMap<>();
		int index = 1;

		for (Room room:
			 roomList) {
			responseBody.put("room" + index, room);
			index += 1;
		}
//		responseBody.put("roomList", roomList);

		return ResponseEntity.ok().body(responseBody);
	}

}
