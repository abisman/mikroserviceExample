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
		List<Room> rooms = (List<Room>) repository.findAll();
		return rooms;
	}

	@Override
	public Room findById(String id) {
		Optional<Room> room = repository.findById(id);
		return room.get();
	}

	@Override
	public Room create(String roomType, int amountOfPeople) {
		String id = roomTypeMapping(roomType) + amountOfPeople;
		
		Room room = new Room(id, roomType, amountOfPeople);
		return repository.save(room);
	}
	
	private String roomTypeMapping(String roomType) {
		String id;
		switch(roomType) {
		case "Public":
			id = "PB";
			break;
		case "Economy":
			id = "EC";
			break;
		case "Executive":
			id = "EX";
			break;
		case "Luxury":
			id = "LU";
			break;
		case "Deluxe":
			id = "DX";
			break;
		case "Wadaw":
			id = "WW";
			break;
		case "Wadidaw":
			id = "WD";
			break;
		default:
			id = "UN"; // Unknown
			break;
		}
		
		return id;
	}

}
