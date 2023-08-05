package com.example.crud.service;



import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.example.crud.exception.UserIdNotFoundException;
import com.example.crud.exception.UserNameNotFoundException;
import com.example.crud.model.User;
import com.example.crud.repository.UserRepository;

import jakarta.validation.ConstraintViolationException;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	
	@Override
	public String registerUser(User user) throws MethodArgumentNotValidException {
			
				this.userRepository.save(user);
				return "User Registered Successfully !!";
		
	}


	@Override
	public User findByName(String name) throws UserNameNotFoundException {
		try {
			return this.userRepository.findUserByUserName(name).get();
		} catch(Exception userNameNotFound) {
			throw new UserNameNotFoundException("User with Name "+name+" doesn't exists !!");
		}
	}


	@Override
	public User findUserById(int userId) throws UserIdNotFoundException{
		// TODO Auto-generated method stub
		try {
			return this.userRepository.findById(userId).get();
		} catch(Exception userNameNotFound) {
			throw new UserNameNotFoundException("User with User Id "+userId+" doesn't exists !!");
		}
	}
	
	
	
}
