 package com.bloodbank.controller;

import java.util.List;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bloodbank.dto.BloodBankDto;
import com.bloodbank.entity.Blood_Bank;
import com.bloodbank.exception.IdNotFoundException;
import com.bloodbank.service.BloodBankService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/bloodbank")
public class BloodBankController {

	private static Logger log=LoggerFactory.getLogger(Blood_Bank.class.getSimpleName());

	@Autowired
	private BloodBankService bloodBankService;

	@PostMapping
	public ResponseEntity<Blood_Bank> save(@RequestBody Blood_Bank bloodBank){
		log.info("Blood_Bank Details {}", bloodBank);
		try {
		bloodBankService.save(bloodBank);
		ResponseEntity<Blood_Bank> repResponseEntity=new ResponseEntity<>(bloodBank,HttpStatus.CREATED);
		log.info("Blood Bank Details Saved Succeessfully");
		return repResponseEntity;
		}
		catch (IdNotFoundException e) {
			log.error("Blood Bank Details Saved Unsuuccessfully ");
			return new ResponseEntity<Blood_Bank>(HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@GetMapping(path="/{id}")
	public ResponseEntity<Blood_Bank> getById(@PathVariable Long id){
		log.info("fetching bloodBank:{}",id);
		try {
		Blood_Bank blood_Bank = bloodBankService.getById(id);
		ResponseEntity<Blood_Bank> responseEntity = new ResponseEntity(blood_Bank, HttpStatus.OK);
		log.info("Details Fetched using Id is succeed");
		return responseEntity;
		}
		catch (IdNotFoundException e) {
			log.error("Details Are Not Fetched using Id");
			return new ResponseEntity<Blood_Bank>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(path="/all")
	public ResponseEntity<List<Blood_Bank>> getAll(){
		log.info("fetching bloodBank : {}");
		try {
		List<Blood_Bank> banks = bloodBankService.getAll();
		ResponseEntity<List<Blood_Bank>> responseEntity=new ResponseEntity<List<Blood_Bank>>(banks,HttpStatus.OK);
		log.info("Blood Bank details fetched suuceesfully");
		return responseEntity;
		}
		catch (IdNotFoundException e) {
			log.error("Blood Bank details Are Not fetched ");
			return new ResponseEntity<List<Blood_Bank>>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping(path="/delete/{id}")
	public ResponseEntity<Blood_Bank> delete(@PathVariable Long id){
		log.info("deletion of record");
		try {
		bloodBankService.delete(id);
		ResponseEntity<Blood_Bank> responseEntity=new ResponseEntity<Blood_Bank>(HttpStatus.OK);
		log.info("Blood Bank Details Deleted Using Id");
		return responseEntity;
		}
		catch (IdNotFoundException e) {
			log.error("Blood Bank Details Are Not Deleted Using Id");
			return new ResponseEntity<Blood_Bank>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping(path="/update")
	public ResponseEntity<Blood_Bank> update(@RequestBody Blood_Bank blood_Bank) {
		log.info("Updating Blood Bank");
		try {
		bloodBankService.update(blood_Bank);
		ResponseEntity<Blood_Bank> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		log.info("Blood Bank Details Updated Successfully");
		return responseEntity;
		}
		catch (IdNotFoundException e) {
			log.error("Blood Bank Details Are Not Updated");
			return new ResponseEntity<Blood_Bank>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/location/{loc}")
	public ResponseEntity<List<Blood_Bank>> findByLocation(@PathVariable String loc){
		log.info("going to find location");
		try {
		List<Blood_Bank> list = bloodBankService.findLoc(loc);
		ResponseEntity<List<Blood_Bank>> responseEntity=new ResponseEntity<>(list,HttpStatus.OK);
		log.info("Location fetched Successfully");
		return responseEntity;
		}
		catch (IdNotFoundException e) {
			log.error("Error occured while Fetching location");
			return new ResponseEntity<List<Blood_Bank>>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/bloodtype")
	public ResponseEntity<List<BloodBankDto>> findByLocation(@RequestParam Long donorId){
		log.info("going to find location");
		try {
//		List<Blood_Bank> list = bloodBankService.findLoc(loc);
		List<BloodBankDto> list = bloodBankService.getBloodType(donorId);
		ResponseEntity<List<BloodBankDto>> responseEntity=new ResponseEntity<>(list,HttpStatus.OK);
		log.info("Location fetched Successfully");
		return responseEntity;
		}
		catch (IdNotFoundException e) {
			log.error("Error occured while Fetching location");
			return new ResponseEntity<List<BloodBankDto>>(HttpStatus.NOT_FOUND);
		}
	}

	
}
