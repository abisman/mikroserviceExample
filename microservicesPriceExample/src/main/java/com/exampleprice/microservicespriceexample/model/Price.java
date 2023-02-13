package com.exampleprice.microservicespriceexample.model;

import jakarta.persistence.*;

@Entity
@Table(name = "price")
public class Price {

    @Id
    private String roomCode;
    private Double roomPrice;

    public Price() {
        super();
    }

    public Price(String roomCode, Double roomPrice) {
        this.roomCode = roomCode;
        this.roomPrice = roomPrice;
    }

    public String getRoomCode() {
        return roomCode;
    }

    public void setRoomCode(String roomCode) {
        this.roomCode = roomCode;
    }

    public Double getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(Double roomPrice) {
        this.roomPrice = roomPrice;
    }
}
