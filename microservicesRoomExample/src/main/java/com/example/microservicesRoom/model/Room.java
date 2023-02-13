package com.example.microservicesRoom.model;

import jakarta.persistence.*;

@Entity
@Table(name = "room")
public class Room {

	@Id
	private String roomCode;

	private String roomName;

	public Room() {
		super();
	}

	public Room(String roomCode, String roomName) {
		this.roomCode = roomCode;
		this.roomName = roomName;
	}

	public String getRoomCode() {
		return roomCode;
	}

	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	@Override
	public String toString() {
		return "Room [Room Name: " + this.roomName +
				", Room Code: " + this.roomCode + "]";
	}
}
