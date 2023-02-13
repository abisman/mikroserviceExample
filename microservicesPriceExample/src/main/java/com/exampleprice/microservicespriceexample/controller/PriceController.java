package com.exampleprice.microservicespriceexample.controller;

import com.exampleprice.microservicespriceexample.model.Price;
import com.exampleprice.microservicespriceexample.service.PriceService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PriceController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private PriceService priceService;

    @RequestMapping("/")
    public String index() {
        return "Hello bung, ini mikroservice bagian price";
    }

    @RequestMapping("/create")
    public ResponseEntity<Object> create(@RequestParam String roomCode, @RequestParam String roomPrice) {
        String url = "http://localhost:8082/getAllRoom";
        Map<String, Object> responseBody = new LinkedHashMap<>();
        List<String> roomCodeList = new ArrayList<>();
        double price;

        responseBody.put("status", "Bad Request");

        try {
            String str = restTemplate.getForObject(url, String.class);
            JSONObject json = new JSONObject(str);

            for(int i = 1; i <= json.length(); i++) {
                roomCodeList.add(json.getJSONObject("room" + i).get("roomCode").toString());
            }

            if(!roomCodeList.contains(roomCode)) throw new Exception(roomCode + " is not on the room list!");

            price = Double.parseDouble(roomPrice);
            Price p = priceService.create(roomCode, price);

            responseBody.put("status", "Created!");
            responseBody.put("data", p);

            return ResponseEntity.ok().body(responseBody);
        } catch (Exception e) {
            responseBody.put("reason", e.getMessage());
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().body(responseBody);
    }

    @RequestMapping("/getPrice")
    public Price getPrice(@RequestParam String roomCode) {
        return priceService.findByRoomCode(roomCode);
    }
}
