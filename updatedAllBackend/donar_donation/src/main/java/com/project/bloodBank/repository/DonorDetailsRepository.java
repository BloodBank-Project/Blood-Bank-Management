package com.project.bloodBank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.bloodBank.entity.DonorDetailsEntity;

public interface DonorDetailsRepository extends JpaRepository<DonorDetailsEntity, Long>{

}
