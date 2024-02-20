package com.blood.controller;

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

import com.blood.entity.Blood;
import com.blood.exception.NoDataFoundException;
import com.blood.service.BloodService;

@RestController
@RequestMapping("/blood")
public class BloodController {
	private static Logger log = LoggerFactory.getLogger(Blood.class.getSimpleName());

	@Autowired
	private BloodService bloodService;

	@PostMapping("/save")
	public ResponseEntity<Blood> save(@RequestBody Blood blood) {

		log.info("Saving Blood Group ", blood);

		try {
		bloodService.save(blood);

		ResponseEntity<Blood> repResponseEntity = new ResponseEntity<>(blood, HttpStatus.CREATED);
		log.info("Blood group Saved Successfully");
		return repResponseEntity;
		}
		catch(NoDataFoundException e) {
			log.error("Blood group saved unsuccessfully");
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Blood> getById(@PathVariable Integer id) {

		log.info("Getting Blood Group Id ", id);
		try {
		Blood blood = bloodService.getById(id);
		ResponseEntity<Blood> responseEntity = new ResponseEntity<Blood>(blood, HttpStatus.OK);
		log.info("Getting of Blood group id is successfull");
		return responseEntity;
		}
		catch (NoDataFoundException e) {
			log.error("Getting of Blood group id is  unsuccessfull");
			return new  ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}

	@GetMapping(path = "/all")
	public ResponseEntity<List<Blood>> getAll() {
		
		log.info("Getting All Blood Groups");
		try {
		List<Blood> users = bloodService.getAll();

		ResponseEntity<List<Blood>> responseEntity = new ResponseEntity<List<Blood>>(users, HttpStatus.OK);
		log.info("Blood Groups Fetched successfully");
		return responseEntity;
		}
		catch (NoDataFoundException e) {
			log.error("Fetching Of Blood Groups unsuuccessfull");
			return new  ResponseEntity<List<Blood>>(HttpStatus.NOT_FOUND);

		}
	}
}
