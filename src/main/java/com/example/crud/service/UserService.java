package com.example.crud.service;

import org.springframework.web.bind.MethodArgumentNotValidException;

import com.example.crud.exception.UserIdNotFoundException;
import com.example.crud.exception.UserNameNotFoundException;
import com.example.crud.model.User;

import jakarta.validation.ConstraintViolationException;

public interface UserService {

	public String registerUser(User user) throws MethodArgumentNotValidException;

	public User findByName(String name) throws UserNameNotFoundException;

	public User findUserById(int userId) throws UserIdNotFoundException;
	
	
}
