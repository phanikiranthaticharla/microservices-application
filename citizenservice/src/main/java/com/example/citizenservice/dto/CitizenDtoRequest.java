package com.example.citizenservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CitizenDtoRequest {

    private String name;
    private int vaccinationCenterId;
}
