package com.example.crud.model;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="USERS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable=false,length=50)
	@NotBlank(message="First Name cannot be null or empty")
	private String firstName;
	@Column(nullable=false,length=50)
	@NotBlank(message="Last cannot be null or empty")
	private String lastName;
	@Column(nullable=false,unique=true)
	@Email(message="Enter Valid Email Id")
	private String emailId;
	@Column
	private Long mobileNumber;
	@Column
	private int age;
	
	@JoinColumn(name = "ADDRESS_ID", nullable = false)
    @MapsId
	@OneToOne(cascade = {CascadeType.ALL})
	private Address address;
	
	
	
}
