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
import com.blood.service.BloodService;

@RestController
@RequestMapping
public class BloodController {
	private static Logger log=LoggerFactory.getLogger(Blood.class.getSimpleName());

	@Autowired
	private BloodService bloodService;
	
	@PostMapping("/save")
	
  public ResponseEntity<Blood> save(@RequestBody Blood blood){
		
		log.info("Blood Group  {}",blood);
		
		bloodService.save(blood);
		
		ResponseEntity<Blood> repResponseEntity=new ResponseEntity<>(blood,HttpStatus.CREATED);
		
		return repResponseEntity;
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<Blood> getById(@PathVariable Integer id){
		
		log.info("fetching user:{}",id);
		
		Blood blood=bloodService.getById(id);
		
		ResponseEntity<Blood> responseEntity=new ResponseEntity<Blood>(blood,HttpStatus.OK);
		
		return responseEntity;
	}
	
	@GetMapping(path="/all")
	public ResponseEntity<List<Blood>> getAll(){
		
		log.info("fetching users : {}");
		
		List<Blood> users=bloodService.getAll();
		
		ResponseEntity<List<Blood>> responseEntity=new ResponseEntity<List<Blood>>(users,HttpStatus.OK);
		
		return responseEntity;
	}
}
