package com.example.citizenservice.controller;

import com.example.citizenservice.dto.CitizenDtoRequest;
import com.example.citizenservice.dto.CitizenDtoResponse;
import com.example.citizenservice.service.CitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/citizen")
public class CitizenController {

    @Autowired
    CitizenService citizenService;

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return new ResponseEntity<>("hello", HttpStatus.OK);
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }

    @GetMapping("/id/{id}")
    public List<CitizenDtoResponse> getById(@PathVariable Integer id) {
        return citizenService.getCitizenListById(id);
    }

    @PostMapping("/add")
    public CitizenDtoResponse addCitizen(@RequestBody CitizenDtoRequest citizen) {
        return citizenService.save(citizen);
    }
}
