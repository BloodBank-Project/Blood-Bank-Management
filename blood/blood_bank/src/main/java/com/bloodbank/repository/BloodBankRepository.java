package com.bloodbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bloodbank.entity.Blood_Bank;

public interface BloodBankRepository extends JpaRepository<Blood_Bank, Long> {

}
