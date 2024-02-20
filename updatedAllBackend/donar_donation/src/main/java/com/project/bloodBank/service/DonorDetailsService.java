package com.project.bloodBank.service;

import java.util.List;

import com.project.bloodBank.entity.DonorDetailsEntity;


public interface DonorDetailsService {

	DonorDetailsEntity saveDonation(DonorDetailsEntity donorEntity);

	DonorDetailsEntity getByDonationId(Long id);

	void updateDonation(DonorDetailsEntity DonorEntity);

	void deleteDonation(Long id);

	List<DonorDetailsEntity> getAll();
	
}
