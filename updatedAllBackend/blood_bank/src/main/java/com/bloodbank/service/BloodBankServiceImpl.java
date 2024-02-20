package com.bloodbank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bloodbank.dto.BloodBankDto;
import com.bloodbank.entity.Blood_Bank;
import com.bloodbank.exception.IdNotFoundException;
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
//	public Optional<Blood_Bank> getById(Long id) {
	public Blood_Bank getById(Long id){
		 Optional<Blood_Bank> id2 = bloodBankRepository.findById(id);
		 if(id2.isEmpty()) {
			 try {
					id2.orElseThrow(()->new IdNotFoundException("Id is not Avaialable to delete"));
			 }
			 catch (IdNotFoundException e) {
			 		throw e;
			 }
		 }
		 return id2.get();
	}

	@Override
	public void delete(Long id) {
		Optional<Blood_Bank> id2 = bloodBankRepository.findById(id);
		if(id2.isPresent()) {
			bloodBankRepository.deleteById(id);
		}
		else {
			id2.orElseThrow(()->new IdNotFoundException("Id is not Avaialable to delete"));
		}
		
	}

	@Override
	public List<Blood_Bank> getAll() {
		List<Blood_Bank> list = bloodBankRepository.findAll();
		return list;
	}

	@Override
	public void update(Blood_Bank blood_Bank) {
		
		Optional<Blood_Bank> id = bloodBankRepository.findById(blood_Bank.getBlood_bank_id());
		if(id.isPresent()) {
			bloodBankRepository.save(blood_Bank);
		}
		else {
			id.orElseThrow(()->new IdNotFoundException("Id is not Avaialable to update"));
		}
	}

	@Override
	public List<Blood_Bank> findLoc(String loc) {
		List<Blood_Bank> location = bloodBankRepository.findByLocation(loc);
//		if(location.isEmpty()) {
//			try {
//				throw new IdNotFoundException("Not Found");
//			}
//			catch (IdNotFoundException e) {
//				throw e;
//			}
//		}
		return location;
		
		
	}

	@Override
	public List<BloodBankDto> getBloodType(Long donorId) {
		  List<BloodBankDto> type = bloodBankRepository.getBloodGroup(donorId);
		  if(type.isEmpty()) {
				try {
					throw new IdNotFoundException("Not Found");
				}
				catch (IdNotFoundException e) {
					throw e;
				}
			}
			return type;
	}

}
