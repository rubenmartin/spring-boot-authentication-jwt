package com.bedirhanatasoy.springboot.auth.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bedirhanatasoy.springboot.auth.domain.User;
import com.bedirhanatasoy.springboot.auth.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PreAuthorize("hasRole('REGISTER')")
	@PostMapping("/api/user/register")
	public ResponseEntity<User> registerUser(@RequestBody User user) {
		user = userService.registerUser(user);
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}
	
}
