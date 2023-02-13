package com.example.microservicesRoom.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.microservicesRoom.model.Room;
import com.example.microservicesRoom.repository.RoomRepository;
import com.example.microservicesRoom.service.RoomService;

@Service
public class RoomServiceImpl implements RoomService {
	
	@Autowired
	private RoomRepository repository;

	@Override
	public List<Room> findAll() {
		return (List<Room>) repository.findAll();
	}

	@Override
	public Room findById(String id) {
		Optional<Room> room = repository.findById(id);
		return room.orElse(null);
	}

	@Override
	public Room create(String roomType, String roomName) {
		List<Room> roomList = findAll();
		String roomTypeCode = roomTypeMapping(roomType);
		int count = 1;
		StringBuilder index = new StringBuilder();

		for (Room room:
			 roomList) {
			if(room.getRoomCode().contains(roomTypeCode)) count += 1;
		}

		index.append(count);

		while(index.length() < 3) {
			index.insert(0, "0");
		}

		Room room = new Room(roomTypeCode + index, roomName);
		return repository.save(room);
	}
	
	private String roomTypeMapping(String roomType) {

		return switch (roomType) {
			case "Public" -> "PB";
			case "Economy" -> "EC";
			case "Executive" -> "EX";
			case "Luxury" -> "LU";
			case "Deluxe" -> "DX";
			case "Wadaw" -> "WW";
			case "Wadidaw" -> "WD";
			default -> "UN"; // Unknown
		};
	}

}
