package com.library.lending.controller;

import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.library.lending.model.User;
import com.library.lending.service.IUserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	private final IUserService service;

	@Autowired
	public UserController(IUserService service) {
		this.service = service;
	}

	@PostMapping(value = "/register", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<User> registerUser(
			@RequestParam(value = "name") String name, @RequestParam(value = "contact") String contact) {

		return new ResponseEntity<User>(service.registerUser(name, contact), HttpStatus.OK);
	}
	
	@GetMapping(value = "/{uid}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<User> getUser(@PathVariable("uid") @NotBlank long uid
			) {

		User resp = service.getUser(uid);

		return new ResponseEntity<User>(resp, HttpStatus.OK);
	}

}
