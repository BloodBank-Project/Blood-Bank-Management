package com.project.bloodBank.controller;

import java.util.List;


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
import org.springframework.web.bind.annotation.RestController;

import com.project.bloodBank.bean.DonorBean;
import com.project.bloodBank.exceptions.DonorNotFoundException;
import com.project.bloodBank.serviceImpl.DonorServiceImpl;

@RestController
@RequestMapping("/donor")
public class DonorController {

	private static Logger log=LoggerFactory.getLogger(DonorController.class.getSimpleName());

	@Autowired
	private DonorServiceImpl donorServiceImpl;
	
	@PostMapping("/save")
	public ResponseEntity<DonorBean> saveDonor(@RequestBody DonorBean donorBean){
		log.info(" Going to save Donar ");
		try {
			donorServiceImpl.save(donorBean);
			ResponseEntity<DonorBean> responseEntity = new ResponseEntity<>(HttpStatus.CREATED);
			log.info("Donor Saved Successfully");
			return responseEntity;
		}
		catch (DonorNotFoundException e) {
			log.error(" Saving Of Donor Unsuccessfull");
			return new ResponseEntity<DonorBean>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	
	@GetMapping("/get/{id}")
	public ResponseEntity<DonorBean> getByDonorId(@PathVariable Long id){
		log.info(" Going to get Donar Id ");
		try {
			DonorBean byDonorId = donorServiceImpl.getByDonorId(id);
			ResponseEntity<DonorBean> responseEntity = new ResponseEntity<>(byDonorId, HttpStatus.OK);
			log.info("Getting DonorId Is Successed");
			return responseEntity;
		}
		catch (DonorNotFoundException e) {
			log.error(" Getting Of DonorId Unsuccessfull");
			return new ResponseEntity<DonorBean>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@PutMapping("/update")
	public ResponseEntity<DonorBean> updateDonor(@RequestBody DonorBean donorBean){
		log.info(" Going to Update Donar ");
		try {
			donorServiceImpl.update(donorBean);
			ResponseEntity<DonorBean> responseEntity = new ResponseEntity<>(HttpStatus.OK);
			log.info("Donor Updated Successfully");
			return responseEntity;
		}
		catch (DonorNotFoundException e) {
			log.error(" Updating Of Donor Unsuccessfull");
			return new ResponseEntity<DonorBean>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<DonorBean> deleteDonor(@PathVariable Long id){
		log.info(" Going to Delete Donar ");
		try {
			donorServiceImpl.delete(id);
			ResponseEntity<DonorBean> responseEntity = new ResponseEntity<>(HttpStatus.OK);
			log.info("Donor Deleted Successfully");
			return responseEntity;
		}
		catch (DonorNotFoundException e) {
			log.error(" Deleting Of Donor Is Unsuccessfull");
			return new ResponseEntity<DonorBean>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<DonorBean>> donorsList(){
		log.info(" Going to Update Donar ");
		try {
			List<DonorBean> allDonors = donorServiceImpl.getAllDonors();
			ResponseEntity<List<DonorBean>> responseEntity = new ResponseEntity<>(allDonors,HttpStatus.OK);
			log.info("Donor Fetched Successfully");
			return responseEntity;
		}
		catch (DonorNotFoundException e) {
			log.error(" Updating Of Donor Unsuccessfull");
			return new ResponseEntity<List<DonorBean>>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<DonorBean> getUserDetails(@PathVariable Long id){
		
		log.info("fetch user details", id);
		try {
			DonorBean donorBean = donorServiceImpl.getById(id);
		ResponseEntity<DonorBean> responseEntity = new ResponseEntity(donorBean, HttpStatus.OK);
		log.info("User Details Fetched Successfully");
		return responseEntity;
		}
		catch(DonorNotFoundException e) {
			log.error("User Details Fetched Unsuccessfull");
			return new ResponseEntity<DonorBean>(HttpStatus.NOT_FOUND);
		}

	}
	

	//	----------------------------using Entity----------------------------------------

//	@PostMapping("/save")
//	public String save(@RequestBody DonorBean donorEntity) {
//		donorServiceImpl.save(donorEntity);
//		return "data saved";
//	}

	
//	@GetMapping("/get/{id}")
//	public ResponseEntity<DonorEntity> getById(@PathVariable Long id) {
////		Optional<DonorEntity> optional = donorServiceImpl.getById(id);
//		DonorEntity optional = donorServiceImpl.getById(id);
//		ResponseEntity<DonorEntity> responseEntity = new ResponseEntity(optional, HttpStatus.OK);
//		return responseEntity;
//	}
//
//	
//	@DeleteMapping("/delete/{id}")
//	public void delete(@PathVariable Long id) {
//		donorServiceImpl.delete(id);
//	}
//	
//
//	@GetMapping("/all")
//	public ResponseEntity<List<DonorEntity>> getAllDonors() {
//		List<DonorEntity> list = donorServiceImpl.getAll();
//		ResponseEntity<List<DonorEntity>> responseEntity = new ResponseEntity(list, HttpStatus.OK);
//		return responseEntity;
//
//	}
//	
//
//	@PutMapping("/update")
//	public ResponseEntity<Optional<DonorEntity>> updateDonor(@RequestBody DonorEntity donorEntity) {
//		Optional<DonorEntity> update = donorServiceImpl.update(donorEntity);
//		ResponseEntity<Optional<DonorEntity>> responseEntity = new ResponseEntity<>(update, HttpStatus.OK);
//		return responseEntity;
//	}
}
