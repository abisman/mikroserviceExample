package com.example.microservicesRoom.service;

import java.util.List;

import com.example.microservicesRoom.model.Room;

public interface RoomService {
	List<Room> findAll();
	Room findById(String id);
	Room create(String roomType, String roomName);
}
