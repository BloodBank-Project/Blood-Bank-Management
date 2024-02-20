package com.bloodbank.service;

import java.util.List;
import java.util.Optional;

import com.bloodbank.dto.BloodBankDto;
import com.bloodbank.entity.Blood_Bank;

public interface BloodBankService {

	void save(Blood_Bank bloodbank);

	Blood_Bank getById(Long id);

	void update(Blood_Bank bloodbank);

	void delete(Long id);

	List<Blood_Bank> getAll();
	
	List<Blood_Bank> findLoc(String loc);
	
	List<BloodBankDto> getBloodType(Long donorId);

}
