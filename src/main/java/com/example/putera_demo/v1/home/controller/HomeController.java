package com.example.putera_demo.v1.home.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {

    @Autowired
    public HomeController() {}

    @GetMapping
    public ResponseEntity<String> home() {
        return ResponseEntity.ok("Welcome to the Home Page!");
    }

    @GetMapping("demo-putera-api")
    public ResponseEntity<?> home2() {
        return ResponseEntity.status(302).header("Location", "/").build();
    }

    @GetMapping("demo-putera-api/v1")
    public ResponseEntity<?> home3() {
        return ResponseEntity.status(302).header("Location", "/").build();
    }
}
