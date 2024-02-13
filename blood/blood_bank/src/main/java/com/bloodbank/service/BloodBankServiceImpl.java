package com.bloodbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bloodbank.entity.Blood_Bank;
import com.bloodbank.repository.BloodBankRepository;

@Service
public class BloodBankServiceImpl implements BloodBankService {
	@Autowired
	private BloodBankRepository bloodBankRepository;

	@Override
	public void save(Blood_Bank bloodbank) {
		bloodBankRepository.save(bloodbank);
	}

	@Override
	public Blood_Bank getById(Long id) {
		return bloodBankRepository.findById(id).get();
	}

	@Override
	public List<Blood_Bank> getAll() {
		return bloodBankRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		bloodBankRepository.deleteById(id);
	}

}
