package com.bloodbank.service;

import java.util.List;

import com.bloodbank.entity.Blood_Bank;

public interface BloodBankService {
	
	void save(Blood_Bank bloodbank);
	Blood_Bank getById(Long id);
	List<Blood_Bank> getAll();
	void delete(Long id);

}
