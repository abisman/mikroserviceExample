package com.exampleprice.microservicespriceexample.service;

import com.exampleprice.microservicespriceexample.model.Price;

import java.util.List;

public interface PriceService {
    List<Price> findAll();
    Price findByRoomCode(String roomCode);
    Price create(String roomCode, Double roomPrice);
}
