package com.example.citizenservice.service;

import com.example.citizenservice.dto.CitizenDtoRequest;
import com.example.citizenservice.dto.CitizenDtoResponse;
import com.example.citizenservice.entity.Citizen;
import com.example.citizenservice.repository.CitizenRepository;
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

        return citizenList.stream()
                .map(this::getCitizenDtoResponse)
                .collect(Collectors.toList());
    }

    public CitizenDtoResponse save(CitizenDtoRequest citizenDtoRequest) {
        Citizen citizen = new Citizen();
        citizen.setName(citizenDtoRequest.getName());
        citizen.setVaccinationCenterId(citizenDtoRequest.getVaccinationCenterId());
        citizenRepository.save(citizen);
        return getCitizenDtoResponse(citizen);

    }

    public CitizenDtoResponse getCitizenDtoResponse(Citizen citizen) {
        CitizenDtoResponse citizenDtoResponse = new CitizenDtoResponse();
        citizenDtoResponse.setId(citizen.getId());
        citizenDtoResponse.setName(citizen.getName());
        citizenDtoResponse.setVaccinationCenterId(citizen.getVaccinationCenterId());
        return citizenDtoResponse;
    }
}
