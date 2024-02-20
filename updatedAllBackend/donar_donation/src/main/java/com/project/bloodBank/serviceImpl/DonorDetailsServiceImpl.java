package com.project.bloodBank.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.bloodBank.entity.DonorDetailsEntity;
import com.project.bloodBank.exceptions.DonationDetailsNotFoundException;
import com.project.bloodBank.exceptions.DonorNotFoundException;
import com.project.bloodBank.repository.DonorDetailsRepository;
import com.project.bloodBank.service.DonorDetailsService;

@Service
public class DonorDetailsServiceImpl implements DonorDetailsService{
	
	@Autowired
	private DonorDetailsRepository detailsRepository;

	@Override
	public DonorDetailsEntity saveDonation(DonorDetailsEntity donorEntity) {
		System.out.println("data is going to save"+donorEntity);
		try {
		detailsRepository.save(donorEntity);
		}
		catch(DonationDetailsNotFoundException e) {
			throw e;
		}
		return donorEntity;
	}

	@Override
	public DonorDetailsEntity getByDonationId(Long id) {
		Optional<DonorDetailsEntity> optional = detailsRepository.findById(id);
		if (optional.isEmpty()) {
			try {
				optional.orElseThrow(() -> new DonationDetailsNotFoundException("donor is not found to delete with this " + id));
			} catch (DonationDetailsNotFoundException e) {
				throw e;
			}
		}
		return optional.get();
	}

	@Override
	public void updateDonation(DonorDetailsEntity donorEntity) {
		Optional<DonorDetailsEntity> donorEntity1 = detailsRepository.findById(donorEntity.getDonationId());
		if (donorEntity1.isPresent()) {
			detailsRepository.save(donorEntity);
		} else {
			try {
				throw new DonorNotFoundException("Donor is not available to update with this " + donorEntity.getDonationId());
			} catch (DonorNotFoundException e) {
				throw e;
			}
		}		
	}

	@Override
	public void deleteDonation(Long id) {
		Optional<DonorDetailsEntity> findById = detailsRepository.findById(id);
		if (findById.isEmpty()) {
			try {
				findById.orElseThrow(() -> new DonationDetailsNotFoundException("donar id is  not found to delete"));
			} catch (DonationDetailsNotFoundException e) {
				throw e;
			}
		} else {
			detailsRepository.deleteById(id);
		}		
	}

	@Override
	public List<DonorDetailsEntity> getAll() {
		List<DonorDetailsEntity> entities = detailsRepository.findAll();
		return entities;
	}

}
