package com.patient.service;

import java.util.List;
import java.util.Optional;

import com.patient.entity.PatientRequest;

public interface PatientRequestService
{
	PatientRequest save(PatientRequest patientRequest);

	void deletePatientRequest(Long id);

	List<PatientRequest> getAllPatientRequest();

	Optional<PatientRequest> updatePatientRequest(PatientRequest patientRequest);

	PatientRequest getPatientRequest(Long id);

}