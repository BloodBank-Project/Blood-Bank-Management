package com.patient.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patient.entity.Patient;
import com.patient.entity.PatientRequest;

public interface PatientRepository extends JpaRepository<Patient,Long> {


}
