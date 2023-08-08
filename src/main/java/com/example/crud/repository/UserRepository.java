package com.example.crud.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.crud.model.Address;
import com.example.crud.model.User;

import jakarta.transaction.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
	
	@Query("SELECT U FROM User U WHERE CONCAT (U.firstName,' ',U.lastName) =:name ")
	Optional<User> findUserByUserName(String name);
	
	Optional<User> findById(int id);
	
	

	@Query("SELECT U.id FROM User U WHERE U.emailId =:email")
	int findaddressidbyemail(String email);

	
	@Transactional
	@Modifying
	@Query("UPDATE Address AID SET AID.streetNumber=:stNum,AID.addressLine1=:Line1, AID.addressLine2=:Line2,AID.locality=:localty, AID.city=:city, AID.district=:district,AID.pinCode=:pinCode,AID.state=:state,AID.country=:country where AID.id=:useraddrid")
	void updateaddress(@Param("useraddrid") int useraddrid,@Param("stNum") int stNum,@Param("Line1") String Line1,@Param("Line2") String Line2, @Param("localty") String localty,@Param("city") String city, @Param("district") String district, @Param("pinCode") int pinCode, @Param("state") String state, @Param("country") String country);
	
	
	
	@Query("DELETE FROM User u WHERE u.id=:userId")
	Optional<User> deleteByUserId(int userId);
	

}
