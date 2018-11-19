package com.silocean.rovertest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class RoverTestApplication {

    @GetMapping("/")
    public String helloRover() {
        return "Hello, Rover!";
    }

    public static void main(String[] args) {
        SpringApplication.run(RoverTestApplication.class, args);
    }
}
