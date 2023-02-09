package com.example.microservicesBooking.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "booking")
public class Booking {
	
	static final String BOOKING_SEQ = "booking_id_seq";
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = BOOKING_SEQ)
	@SequenceGenerator(name = BOOKING_SEQ, sequenceName = BOOKING_SEQ,
	      allocationSize = 1,initialValue=1)
	private Long id;
	
	private String name;
	private String date;
	private String price;
	private String roomType;
	private int amountOfPeople;

	public Booking() {
		super();
	}

	public Booking(String name, String date, String price, String roomType, int amountOfPeople) {
		super();
		this.name = name;
		this.date = date;
		this.price = price;
		this.roomType = roomType;
		this.amountOfPeople = amountOfPeople;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getPrice() {
		return price;
	}
	
	public void setPrice(String price) {
		this.price = price;
	}
	
	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public int getPersonType() {
		return amountOfPeople;
	}

	public void setPersonType(int personType) {
		this.amountOfPeople = personType;
	}
	
	@Override
	public String toString() {
		return "Booking [ID = " + this.id + 
				", Name = " + this.name + 
				", Date issued = " + this.date + 
				", Price = " + this.price +
				", Room Type = " + this.roomType + 
				", Amount of People = " + this.amountOfPeople + "]"; 
	}
}