package com.user.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.user.bean.UserBean;
import com.user.entity.User;
import com.user.exception.UserNotFoundException;
import com.user.service.UserService;

@RestController
@RequestMapping(path = "/user")
public class UserController {

	private static Logger log = LoggerFactory.getLogger(User.class.getSimpleName());

	@Autowired
	private UserService userService;

	@PostMapping("/save")
	public ResponseEntity<User> save(@RequestBody User user) {

		log.info("User Details {}", user);
		try {
		userService.save(user);
		ResponseEntity<User> repResponseEntity = new ResponseEntity<>(user, HttpStatus.CREATED);
		log.info("saved Successfully");
		return repResponseEntity;
		}
		catch (UserNotFoundException e) {
			log.error("saved UnSuccessfully");
			return new ResponseEntity<User>(HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<UserBean> getById(@PathVariable Long id) {
		log.info("fetching user:{}", id);
		try {
		UserBean user = userService.getById(id);

		ResponseEntity<UserBean> responseEntity = new ResponseEntity<UserBean>(user, HttpStatus.OK);
		log.info("Details Got Successfully");
		return responseEntity;
		}
		catch (UserNotFoundException e) {
			log.error("Details got UnSuccessfull");
			return new ResponseEntity<UserBean>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(path = "/all")
	public ResponseEntity<List<User>> getAll() {

		log.info("fetching users : {}");
		try {
		List<User> users = userService.getAll();

		ResponseEntity<List<User>> responseEntity = new ResponseEntity<List<User>>(users, HttpStatus.OK);
		log.info("fetched Successfully");
		return responseEntity;
		}
		catch (UserNotFoundException e) {
			log.error("fetched UnSuccessfully");
			return new ResponseEntity<List<User>>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<User> delete(@PathVariable Long id) {

		log.info("deleted record");
		try {
		userService.delete(id);

		ResponseEntity<User> responseEntity = new ResponseEntity<User>(HttpStatus.OK);
		log.info("deleted Successsfully");
		return responseEntity;
		}
		catch (UserNotFoundException e) {
			log.error("Deleted Unsuucessfully");
			return new ResponseEntity<User>(HttpStatus.NOT_ACCEPTABLE);
		}
		
		}

	

	@PutMapping(path = "/update")
	public ResponseEntity<Optional<User>> update(@RequestBody User user) {

		log.info("updated record");
		try {
		Optional<User> updateRecord = userService.update(user);

		ResponseEntity<Optional<User>> responseEntity = new ResponseEntity<Optional<User>>(updateRecord, HttpStatus.OK);
		log.info("updated Successfully");
		return responseEntity;
		}
		catch (UserNotFoundException e) {
			log.error("not updated");
			return new ResponseEntity<Optional<User>>(HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@GetMapping(path = "/login")
	public ResponseEntity<Optional<User>> login(String email, String password) {
		
		log.info("Going to Login");
		try {
		Optional<User> optional = userService.login(email, password);

		ResponseEntity<Optional<User>> responseEntity = new ResponseEntity<Optional<User>>(optional, HttpStatus.OK);
		log.info("loggged in Successfully");
		return responseEntity;
		}
		catch (UserNotFoundException e) {
			log.error("error occured while login");
			return new ResponseEntity<Optional<User>>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@PutMapping(path = "/updatePassword")
	public ResponseEntity<Optional<User>> updatePassword(String email, String password) {
		log.info(" going to update password ");
		try {
		Optional<User> optional = userService.updatePassword(email, password);

		ResponseEntity<Optional<User>> responseEntity = new ResponseEntity<Optional<User>>(optional, HttpStatus.OK);
		log.info("Succcessfully updated");
		return responseEntity;
		}
		catch (UserNotFoundException e) {
			log.error("Password is not updated");
			return new ResponseEntity<Optional<User>>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
}
