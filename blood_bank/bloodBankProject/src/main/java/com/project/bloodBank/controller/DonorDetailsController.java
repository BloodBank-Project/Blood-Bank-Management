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
import com.project.bloodBank.bean.DonorDetailsBean;
import com.project.bloodBank.entity.DonorEntity;
import com.project.bloodBank.exceptions.DonationDetailsNotFoundException;
import com.project.bloodBank.serviceImpl.DonorDetailsServiceImpl;

@RestController
@RequestMapping("/details")
public class DonorDetailsController {

	private static Logger log=LoggerFactory.getLogger(DonorDetailsController.class.getSimpleName());
	
	@Autowired
	private DonorDetailsServiceImpl detailsServiceImpl;
	
	
	@PostMapping("/save")
	public ResponseEntity<DonorDetailsBean> saveDonor(@RequestBody DonorDetailsBean donorBean){
		log.info(" Going to save Donar Details ");
		try {
			detailsServiceImpl.save(donorBean);
			ResponseEntity<DonorDetailsBean> responseEntity = new ResponseEntity<>(HttpStatus.CREATED);
			log.info("Donor Details Saved Successfully");
			return responseEntity;
		}
		catch (DonationDetailsNotFoundException e) {
			log.error(" Saving Of Donor Details Unsuccessfull");
			return new ResponseEntity<DonorDetailsBean>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	
	@GetMapping("/get/{id}")
	public ResponseEntity<DonorDetailsBean> getByDonorId(@PathVariable Long id){
		log.info(" Going to get Donar Id ");
		try {
			DonorDetailsBean byDonorId = detailsServiceImpl.getByDonorId(id);
			ResponseEntity<DonorDetailsBean> responseEntity = new ResponseEntity<>(byDonorId, HttpStatus.OK);
			log.info("Getting Donor DetailsId Is Successed");
			return responseEntity;
		}
		catch (DonationDetailsNotFoundException e) {
			log.error(" Getting Of DonorId Unsuccessfull");
			return new ResponseEntity<DonorDetailsBean>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@PutMapping("/update")
	public ResponseEntity<DonorDetailsBean> updateDonor(@RequestBody DonorDetailsBean donorBean){
		log.info(" Going to Update Donar Details");
		try {
			detailsServiceImpl.update(donorBean);
			ResponseEntity<DonorDetailsBean> responseEntity = new ResponseEntity<>(HttpStatus.OK);
			log.info("Donor Details  Updated Successfully");
			return responseEntity;
		}
		catch (DonationDetailsNotFoundException e) {
			log.error(" Updating Of Donor Unsuccessfull");
			return new ResponseEntity<DonorDetailsBean>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<DonorDetailsBean> deleteDonor(@PathVariable Long id){
		log.info(" Going to Delete Donar ");
		try {
			detailsServiceImpl.delete(id);
			ResponseEntity<DonorDetailsBean> responseEntity = new ResponseEntity<>(HttpStatus.OK);
			log.info("Donor Deleted Successfully");
			return responseEntity;
		}
		catch (DonationDetailsNotFoundException e) {
			log.error(" Deleting Of Donor Is Unsuccessfull");
			return new ResponseEntity<DonorDetailsBean>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<DonorDetailsBean>> donorsList(){
		log.info(" Going to Update Donar ");
		try {
			List<DonorDetailsBean> allDonors = detailsServiceImpl.getAllDonors();
			ResponseEntity<List<DonorDetailsBean>> responseEntity = new ResponseEntity<>(allDonors,HttpStatus.OK);
			log.info("Donor Details Fetched Successfully");
			return responseEntity;
		}
		catch (DonationDetailsNotFoundException e) {
			log.error(" Updating Of Donor Details Unsuccessfull");
			return new ResponseEntity<List<DonorDetailsBean>>(HttpStatus.NOT_FOUND);
		}
	}
	
//	-----------------------------------------------------------------------------------------
	

//	@PostMapping("/save")
//	public ResponseEntity<DonorDetailsBean> save(@RequestBody DonorDetailsBean donorEntity) {
//		detailsServiceImpl.save(donorEntity);
//		ResponseEntity<DonorDetailsBean> responseEntity = new ResponseEntity(donorEntity, HttpStatus.CREATED);
//		return responseEntity;
//	}
//
//	@GetMapping("/get/{id}")
//	public ResponseEntity<DonorDetailsEntity> getById(@PathVariable Long id) {
////		Optional<DonorDetailsEntity> optional = detailsServiceImpl.getById(id);
//		DonorDetailsEntity optional = detailsServiceImpl.getById(id);
//		ResponseEntity<DonorDetailsEntity> responseEntity = new ResponseEntity(optional, HttpStatus.OK);
//		return responseEntity;
//	}
//
//	@DeleteMapping("/delete/{id}")
//	public void deleteDetails(@PathVariable Long id) {
//		detailsServiceImpl.delete(id);
//	}
//
//	@GetMapping("/all")
//	public ResponseEntity<List<DonorDetailsEntity>> getAllDetails() {
//		List<DonorDetailsEntity> list = detailsServiceImpl.getAll();
//		ResponseEntity<List<DonorDetailsEntity>> responseEntity = new ResponseEntity(list, HttpStatus.OK);
//		return responseEntity;
//
//	}
//
//	@PutMapping("/update")
//	public ResponseEntity<Optional<DonorDetailsEntity>> updateDetails(@RequestBody DonorDetailsEntity donorEntity) {
//		Optional<DonorDetailsEntity> update = detailsServiceImpl.update(donorEntity);
//		ResponseEntity<Optional<DonorDetailsEntity>> responseEntity = new ResponseEntity<>(update, HttpStatus.OK);
//		return responseEntity;
//	}

}
