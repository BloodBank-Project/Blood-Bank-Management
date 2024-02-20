package com.patient.serviceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patient.entity.Patient;
import com.patient.entity.PatientRequest;
import com.patient.exception.PatientNotFoundException;
import com.patient.exception.PatientRequestNotFoundException;
import com.patient.repository.PatientRequestRepository;
import com.patient.service.PatientRequestService;
@Service
public class PatientRequestServiceImp implements PatientRequestService{
	@Autowired
	private PatientRequestRepository requestRepository;
	
	@Override
	public PatientRequest save(PatientRequest patientRequest) {
		return requestRepository.save(patientRequest);
	}

	@Override
	public void deletePatientRequest(Long id) {
		Optional<PatientRequest> optional = requestRepository.findById(id);
		if (optional.isEmpty()) {
			try {
				optional.orElseThrow(() -> new PatientRequestNotFoundException("PatientRequest id is not Found"));
			} catch (PatientRequestNotFoundException e) {
				throw e;
			}
		} else {
			requestRepository.deleteById(id);
		}

	}

	@Override
	public List<PatientRequest> getAllPatientRequest() {
		List<PatientRequest> list = requestRepository.findAll();
		return list;
	}

	@Override
	public Optional<PatientRequest> updatePatientRequest(PatientRequest patientRequest) {
		Optional<PatientRequest> optional = requestRepository.findById(patientRequest.getPatient_request_id());
		if (optional.isPresent()) {
			requestRepository.save(patientRequest);
			return optional;
		}
		return Optional.of(
				optional.orElseThrow(() -> new PatientRequestNotFoundException("No request is found for updation")));
	}

	@Override
	public PatientRequest getPatientRequest(Long id) {
		Optional<PatientRequest> optional = requestRepository.findById(id);
		if (optional.isEmpty()) {
			try {
				optional.orElseThrow(() -> new PatientRequestNotFoundException("Request is not found"));
			} catch (PatientRequestNotFoundException e) {
				throw e;
			}
		}
		return optional.get();
	}
}
