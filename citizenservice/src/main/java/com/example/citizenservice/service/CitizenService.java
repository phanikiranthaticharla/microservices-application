package com.example.citizenservice.service;

import com.example.citizenservice.dto.CitizenDtoRequest;
import com.example.citizenservice.dto.CitizenDtoResponse;
import com.example.citizenservice.entity.Citizen;
import com.example.citizenservice.repository.CitizenRepository;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CitizenService {

    @Autowired
    CitizenRepository citizenRepository;

    public List<CitizenDtoResponse> getCitizenListById(Integer id) {
        List<Citizen> citizenList = citizenRepository.findByVaccinationCenterId(id);
        List<CitizenDtoResponse> citizenDtoResponseList = citizenList.stream()
                .map(CitizenDtoResponse::new)
                .collect(Collectors.toList());

        return citizenDtoResponseList;
    }

    public CitizenDtoResponse save(CitizenDtoRequest citizenDtoRequest) {
        Citizen citizen = new Citizen();
        citizen.setName(citizenDtoRequest.getName());
        citizen.setVaccinationCenterId(citizenDtoRequest.getVaccinationCenterId());
        citizenRepository.save(citizen);
        return new CitizenDtoResponse(citizen);

    }
}
