package com.example.crud.service;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.example.crud.exception.EmailIdNotFoundException;
import com.example.crud.exception.UserIdNotFoundException;
import com.example.crud.exception.UserNameNotFoundException;
import com.example.crud.model.Address;
import com.example.crud.model.User;
import com.example.crud.repository.UserRepository;

import jakarta.transaction.Transactional;


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


	@Transactional
	@Override
	public String updateAddressbyEmailId(Address address, String email) throws EmailIdNotFoundException  {
		// TODO Auto-generated method stub
		
		try {
			int useraddrid=this.userRepository.findaddressidbyemail(email);
			this.userRepository.updateaddress(useraddrid,address.getStreetNumber(),address.getAddressLine1(),address.getAddressLine2(),address.getLocality(),address.getCity(),address.getDistrict(),address.getPinCode(),address.getState(),address.getCountry());
			return "Addresss Updated Successfully";
		}catch(Exception emailIdNotFound) {
			throw new EmailIdNotFoundException("User with Email: "+ email +" doesn't exists ");
		}
		
		
	}


	@Transactional
	@Override
	public String deleteUserbyUserId(int userId) throws UserIdNotFoundException {
		if(this.userRepository.existsById(userId)) {
			this.userRepository.deleteById(userId);
			return "User Deleted Successfully";
		}
		throw new UserIdNotFoundException("User with User Id "+userId+" doesn't exists !!");
			
	}
	
	
	
}
