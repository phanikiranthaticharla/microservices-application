package com.example.vaccinationcenterservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VaccinationCenterDtoResponse {
    private int id;
    private String centerName;
    private String centerAddress;
    private List<CitizenDtoResponse> citizenList;
}
