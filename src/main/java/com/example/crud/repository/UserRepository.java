package com.example.crud.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.crud.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
	
	@Query("SELECT U FROM User U WHERE CONCAT (U.firstName,' ',U.lastName) =:name ")
	Optional<User> findUserByUserName(String name);
	
	Optional<User> findById(int id);
	

}
