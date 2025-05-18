package com.example.demo;

import org.springframework.web.bind.annotation.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RestController
@RequestMapping("/api")
public class DemoApplication {

    @GetMapping("/data")
    public String getData() {
        return "{\"message\": \"Data from backend\"}";
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}

