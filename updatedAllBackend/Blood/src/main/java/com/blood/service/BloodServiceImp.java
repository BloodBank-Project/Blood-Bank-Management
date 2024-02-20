package com.blood.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blood.entity.Blood;
import com.blood.exception.NoDataFoundException;
import com.blood.repository.BloodRepository;

@Service
public class BloodServiceImp implements BloodService {

	@Autowired
	private BloodRepository bloodRepository;
	
	@Override
	public void save(Blood blood) {
		try {
		bloodRepository.save(blood);
		}
		catch(Exception e) {
			throw e;
		}
	}

	@Override
	public Blood getById(Integer id) {
		
		 Optional<Blood> findById = bloodRepository.findById(id);
		 if(findById.isEmpty()) {
			 try {
				 findById.orElseThrow(()-> new NoDataFoundException("no data is found is get"+id));
			 }
			 catch (NoDataFoundException e) {
				 throw e;
			}
		 }
		 return findById.get();
	}

	@Override
	public List<Blood> getAll() {
	 return bloodRepository.findAll();
	}

}







