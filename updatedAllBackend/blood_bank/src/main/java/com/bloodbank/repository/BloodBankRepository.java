package com.bloodbank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bloodbank.dto.BloodBankDto;
import com.bloodbank.entity.Blood_Bank;
import com.bloodbank.entity.DonorEntity;

public interface BloodBankRepository extends JpaRepository<Blood_Bank, Long> {

    @Query(value = "SELECT * FROM Blood_Bank WHERE blood_bank_location LIKE %:location% ", nativeQuery = true)
	List<Blood_Bank> findByLocation(String location);
	
	
	  @Query(value =  "SELECT new com.bloodbank.dto.BloodBankDto (D.blood_type) FROM DonorDetailsEntity A "
              + "JOIN DonorEntity B ON A.id = B.id "
              + "JOIN User C ON C.user_id = B.id "
              + "JOIN Blood D ON D.blood_id = C.blood_group_id where A.id =:donorId")
   
	List<BloodBankDto> getBloodGroup(@Param("donorId") Long donorId);
}
