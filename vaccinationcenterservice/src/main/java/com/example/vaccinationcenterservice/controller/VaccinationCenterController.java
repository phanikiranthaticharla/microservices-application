package com.example.vaccinationcenterservice.controller;

import com.example.vaccinationcenterservice.dto.VaccinationCenterDtoRequest;
import com.example.vaccinationcenterservice.dto.VaccinationCenterDtoResponse;
import com.example.vaccinationcenterservice.service.VaccinationCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vaccinationcenter")
public class VaccinationCenterController {

    @Autowired
    VaccinationCenterService vaccinationCenterService;


    @GetMapping("/id/{id}")
    public VaccinationCenterDtoResponse getVaccinationCenterDetailsById(@PathVariable Integer id) {
        return vaccinationCenterService.getVaccinationCenterDetailsById(id);
    }

    @GetMapping("/name/{name}")
    public VaccinationCenterDtoResponse getVaccinationCenterDetailsByName(@PathVariable String name) {
        return vaccinationCenterService.getVaccinationCenterDetailsByName(name);
    }

    @PostMapping("/add")
    public VaccinationCenterDtoResponse addVaccinationCenter(@RequestBody VaccinationCenterDtoRequest vaccinationCenterDtoRequest) {
        return vaccinationCenterService.addVaccinationCenter(vaccinationCenterDtoRequest);
    }
}
