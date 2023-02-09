package com.example.microservicesRoom.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "room")
public class Room {
	
	@Id
	private String id;

	private String roomType;
	private int amountOfPeople;
	
	public Room() {
		super();
	}

	public Room(String id, String roomType, int amountOfPeople) {
		super();
		this.id = id;
		this.roomType = roomType;
		this.amountOfPeople = amountOfPeople;
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getRoomType() {
		return roomType;
	}
	
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	
	public int getAmountOfPeople() {
		return amountOfPeople;
	}
	
	public void setAmountOfPeople(int amountOfPeople) {
		this.amountOfPeople = amountOfPeople;
	}
	
	@Override
	public String toString() {
		return "Room Type is " + this.roomType + 
				" with an Id " + this.id + 
				" can carry " + this.amountOfPeople + " people";
	}
}
