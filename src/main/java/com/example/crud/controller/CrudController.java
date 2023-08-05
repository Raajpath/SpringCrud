package com.example.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.exception.UserIdNotFoundException;
import com.example.crud.exception.UserNameNotFoundException;
import com.example.crud.model.User;
import com.example.crud.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1.0")
public class CrudController {
	
	@Autowired
	UserService userService;
	
	
	@PostMapping(path="/register",produces= {
			MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE
	},consumes= {
			MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE
	})
	public String register(@RequestBody @Valid User user) throws MethodArgumentNotValidException {
		
		return this.userService.registerUser(user);
	
	}
	
	@GetMapping(path="/finduserbyname/{name}",produces= {
			MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE})
	public User findUserByName(@PathVariable String name) throws UserNameNotFoundException{
		
		return this.userService.findByName(name.trim());
	
	}
	
	@GetMapping(path="/finduserbyuserid/{id}",produces= {
			MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE})
	public User findUserByUserId(@PathVariable("id") int userId) throws UserIdNotFoundException{
		return userService.findUserById(userId);
		
	}
	
	
	
	
	

}
