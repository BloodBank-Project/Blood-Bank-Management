package com.blood.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blood.entity.Blood;
import com.blood.repository.BloodRepository;

@Service
public class BloodServiceImp implements BloodService {

	@Autowired
	private BloodRepository bloodRepository;
	
	@Override
	public void save(Blood blood) {
		bloodRepository.save(blood);
		
	}

	@Override
	public Blood getById(Integer id) {
		
		return bloodRepository.findById(id).get();
	}

	@Override
	public List<Blood> getAll() {
	return bloodRepository.findAll();
	}

	

}







