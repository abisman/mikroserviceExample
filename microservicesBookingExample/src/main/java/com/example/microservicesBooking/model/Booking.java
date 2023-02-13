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
	private String roomCode;
	private Double totalPrice;
	private Integer totalNights;
	private Integer amountOfPeople;

	public Booking() {
		super();
	}

	public Booking(String name, String date, String roomCode, Double totalPrice, Integer totalNights, Integer amountOfPeople) {
		this.name = name;
		this.date = date;
		this.roomCode = roomCode;
		this.totalPrice = totalPrice;
		this.totalNights = totalNights;
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

	public String getRoomCode() {
		return roomCode;
	}

	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Integer getTotalNights() {
		return totalNights;
	}

	public void setTotalNights(Integer totalNights) {
		this.totalNights = totalNights;
	}

	public Integer getAmountOfPeople() {
		return amountOfPeople;
	}

	public void setAmountOfPeople(Integer amountOfPeople) {
		this.amountOfPeople = amountOfPeople;
	}

	@Override
	public String toString() {
		return "Booking [ID = " + this.id + 
				", Name = " + this.name + 
				", Date issued = " + this.date +
				", Room code = " + this.roomCode +
				", Total Price = " + this.totalPrice +
				", Total Nights = " + this.totalNights +
				", Amount of People = " + this.amountOfPeople + "]"; 
	}
}
