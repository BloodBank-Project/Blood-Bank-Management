package com.patient.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patient.entity.PatientRequest;

public interface PatientRequestRepository extends JpaRepository<PatientRequest, Long>{

}
