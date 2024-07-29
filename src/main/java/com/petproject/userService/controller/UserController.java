package com.petproject.userService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.SplittableRandom;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    RestTemplate restTemplate;
    @GetMapping
    public ResponseEntity<String> getOrders(){
        try{
            ResponseEntity<String> response  = restTemplate.getForEntity("http://localhost:8081/orders?userId=1", String.class);
            return response;

        }
        catch (HttpServerErrorException e){
            return new ResponseEntity<>("Error",HttpStatus.BAD_REQUEST);
        }
    }
}
