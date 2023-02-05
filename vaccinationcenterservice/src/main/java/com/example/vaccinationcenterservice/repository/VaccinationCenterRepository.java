package com.example.vaccinationcenterservice.repository;

import com.example.vaccinationcenterservice.entity.VaccinationCenter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VaccinationCenterRepository extends JpaRepository<VaccinationCenter, Integer> {

    public VaccinationCenter findById(int id);

    public VaccinationCenter findByCenterName(String name);
}
