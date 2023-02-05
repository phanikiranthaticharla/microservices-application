package com.example.vaccinationcenterservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VaccinationCenterDtoRequest {
    private int id;
    private String centerName;
    private String centerAddress;
}
