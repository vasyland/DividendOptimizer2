package com.stock.controllers;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.stock.model.Scenario;
import com.stock.model.User;
import com.stock.services.UserService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/user")
public class UserController {

	private static Logger log = LogManager.getLogger(UserController.class);

	private final UserService userService;

	public UserController(final UserService userService) {
		super();
		this.userService = userService;
	}

	@PostMapping("/add")
	public ResponseEntity<User> addScenario(@RequestBody User u) {
		User user = userService.save(u);
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}

	@PostMapping("/update")
	public User updateUser(@RequestBody final User u) {
		return userService.updateUser(u);
	}

	@GetMapping("/all")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> users = userService.findAll();
//		if (users == null || users.size() == 0) {
//		      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Data Not Found");
//		}
		log.info("Number of selected users is: " + users.size());
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<User> getScenarioById(@PathVariable("id") Long id) {
		User user = userService.findById(id);
		if (user == null) {
		      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Data Not Found");
		}
		return new ResponseEntity<>(user, HttpStatus.OK);
	}	
}
