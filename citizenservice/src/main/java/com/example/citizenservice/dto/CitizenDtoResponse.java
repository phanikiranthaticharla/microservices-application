package com.example.citizenservice.dto;

import com.example.citizenservice.entity.Citizen;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CitizenDtoResponse {
    private int id;
    private String name;
    private int vaccinationCenterId;

    public CitizenDtoResponse(Citizen citizen) {
        this.id = citizen.getId();
        this.name = citizen.getName();
        this.vaccinationCenterId = citizen.getVaccinationCenterId();
    }
}
