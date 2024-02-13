package com.bloodbank.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bloodbank.entity.Blood_Bank;
import com.bloodbank.service.BloodBankService;

import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
@RequestMapping("/bloodbankController")
public class BloodBankController {

	private static Logger log=LoggerFactory.getLogger(Blood_Bank.class.getSimpleName());

	@Autowired
	private BloodBankService bloodBankService;

	@PostMapping
	public ResponseEntity<Blood_Bank> save(@RequestBody Blood_Bank bloodBank){
		log.info("Blood_Bank Details {}", bloodBank);
		bloodBankService.save(bloodBank);
		ResponseEntity<Blood_Bank> repResponseEntity=new ResponseEntity<>(bloodBank,HttpStatus.CREATED);
		return repResponseEntity;
	}

	@GetMapping(path="/{id}")
	public ResponseEntity<Blood_Bank> getById(@PathVariable Long id){
		log.info("fetching bloodBank:{}",id);
		Blood_Bank bloodBank = bloodBankService.getById(id);
		ResponseEntity<Blood_Bank> responseEntity=new ResponseEntity<Blood_Bank>(bloodBank,HttpStatus.OK);
		return responseEntity;
	}

	@GetMapping(path="/all")
	public ResponseEntity<List<Blood_Bank>> getAll(){
		log.info("fetching bloodBank : {}");
		List<Blood_Bank> banks = bloodBankService.getAll();
		ResponseEntity<List<Blood_Bank>> responseEntity=new ResponseEntity<List<Blood_Bank>>(banks,HttpStatus.OK);
		return responseEntity;
	}

	@GetMapping(path="/delete/{id}")
	public ResponseEntity<Blood_Bank> delete(@PathVariable Long id){
		log.info("deleted record");
		bloodBankService.delete(id);
		ResponseEntity<Blood_Bank> responseEntity=new ResponseEntity<Blood_Bank>(HttpStatus.OK);
		return responseEntity;
	}

}
