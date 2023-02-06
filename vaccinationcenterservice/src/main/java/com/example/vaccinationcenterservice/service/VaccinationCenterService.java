package com.example.vaccinationcenterservice.service;

import com.example.vaccinationcenterservice.dto.CitizenDtoResponse;
import com.example.vaccinationcenterservice.dto.CitizenDtoResponseList;
import com.example.vaccinationcenterservice.dto.VaccinationCenterDtoRequest;
import com.example.vaccinationcenterservice.dto.VaccinationCenterDtoResponse;
import com.example.vaccinationcenterservice.entity.VaccinationCenter;
import com.example.vaccinationcenterservice.repository.VaccinationCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class VaccinationCenterService {

    @Autowired
    VaccinationCenterRepository vaccinationCenterRepository;

    @Autowired
    RestTemplate restTemplate;

    private static final String urlString = "http://localhost:8081/citizen/id/%d";

    public VaccinationCenterDtoResponse getVaccinationCenterDetailsById(Integer id) {

        VaccinationCenter vaccinationCenter = vaccinationCenterRepository.findById(id).get();
        VaccinationCenterDtoResponse vaccinationCenterDtoResponse = new VaccinationCenterDtoResponse();
        vaccinationCenterDtoResponse.setId(vaccinationCenter.getId());
        vaccinationCenterDtoResponse.setCenterName(vaccinationCenter.getCenterName());
        vaccinationCenterDtoResponse.setCenterAddress(vaccinationCenter.getCenterAddress());

        ResponseEntity<CitizenDtoResponse[]> response = restTemplate.getForEntity(String.format(urlString, id), CitizenDtoResponse[].class);
        CitizenDtoResponse[] citizenDtoResponseArray = response.getBody();
        List<CitizenDtoResponse> citizenDtoResponseList = Arrays.asList(citizenDtoResponseArray);
        vaccinationCenterDtoResponse.setCitizenList(citizenDtoResponseList);
        return vaccinationCenterDtoResponse;
    }

    public VaccinationCenterDtoResponse getVaccinationCenterDetailsByName(String name) {

        VaccinationCenter vaccinationCenter = vaccinationCenterRepository.findByCenterName(name);
        VaccinationCenterDtoResponse vaccinationCenterDtoResponse = new VaccinationCenterDtoResponse();
        vaccinationCenterDtoResponse.setCenterName(vaccinationCenter.getCenterName());
        vaccinationCenterDtoResponse.setCenterAddress(vaccinationCenter.getCenterAddress());

        ResponseEntity<CitizenDtoResponse[]> response = restTemplate.getForEntity(String.format(urlString, vaccinationCenter.getId()), CitizenDtoResponse[].class);
        CitizenDtoResponse[] citizenDtoResponseArray = response.getBody();
        List<CitizenDtoResponse> citizenDtoResponseList = Arrays.asList(citizenDtoResponseArray);

        vaccinationCenterDtoResponse.setCitizenList(citizenDtoResponseList);
        return vaccinationCenterDtoResponse;
    }

    public VaccinationCenterDtoResponse addVaccinationCenter(VaccinationCenterDtoRequest vaccinationCenterDtoRequest) {
        VaccinationCenter center = getVaccinationCenter(vaccinationCenterDtoRequest);
        vaccinationCenterRepository.save(center);
        VaccinationCenterDtoResponse vaccinationCenterDtoResponse = new VaccinationCenterDtoResponse();
        vaccinationCenterDtoResponse.setId(center.getId());
        vaccinationCenterDtoResponse.setCenterName(center.getCenterName());
        vaccinationCenterDtoResponse.setCenterAddress(center.getCenterAddress());
        return vaccinationCenterDtoResponse;
    }

    public VaccinationCenter getVaccinationCenter(VaccinationCenterDtoRequest vaccinationCenterDtoRequest) {
        VaccinationCenter vaccinationCenter = new VaccinationCenter();
        vaccinationCenter.setCenterName(vaccinationCenterDtoRequest.getCenterName());
        vaccinationCenter.setCenterAddress(vaccinationCenterDtoRequest.getCenterAddress());
        return vaccinationCenter;
    }
}
