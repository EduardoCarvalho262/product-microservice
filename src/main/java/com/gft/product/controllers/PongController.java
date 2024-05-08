package com.gft.product.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pingpong")
public class PongController {


    @GetMapping("/ping")
    public String Ping(){
        return "Pong";
    }
}
