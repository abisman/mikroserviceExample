package com.example.microservicesRoom.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.microservicesRoom.model.Room;

@Repository
public interface RoomRepository extends CrudRepository<Room, String> {

}
