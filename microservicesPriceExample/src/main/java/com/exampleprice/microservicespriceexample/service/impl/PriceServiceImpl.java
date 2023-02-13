package com.exampleprice.microservicespriceexample.service.impl;

import com.exampleprice.microservicespriceexample.model.Price;
import com.exampleprice.microservicespriceexample.repository.PriceRepository;
import com.exampleprice.microservicespriceexample.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PriceServiceImpl implements PriceService {

    @Autowired
    private PriceRepository repository;

    @Override
    public List<Price> findAll() {
        return (List<Price>) repository.findAll();
    }

    @Override
    public Price findByRoomCode(String roomCode) {
        Optional<Price> price = repository.findById(roomCode);
        return price.orElse(null);
    }

    @Override
    public Price create(String roomCode, Double roomPrice) {
        Price price = new Price(roomCode, roomPrice);
        return repository.save(price);
    }
}
