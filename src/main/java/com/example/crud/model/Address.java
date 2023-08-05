package com.example.crud.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="USERADDRESS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ADDRESS_ID", nullable = false)
	private int id;
	@Column(nullable=false,length=5)
	private int streetNumber;
	@Column(nullable=false)
	private String addressLine1;
	@Column
	private String addressLine2;
	@Column(nullable=false)
	private String locality;
	@Column(nullable=false)
	private String city;
	@Column(nullable=false)
	private String district;
	@Column(nullable=false,length=6)
	private int pinCode;
	@Column(nullable=false)
	private String state;
	@Column(nullable=false)
	private String country;
	
}
