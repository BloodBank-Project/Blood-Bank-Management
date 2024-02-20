package com.project.bloodBank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.bloodBank.entity.DonorEntity;

public interface DonorRepository extends JpaRepository<DonorEntity, Long>{

}
