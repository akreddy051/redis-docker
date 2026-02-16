package com.example.test_docker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/testDocker")
public class MyController {

    @GetMapping
    public String getMethod() {
        return "Hello from docker akshay";
    }
}
