package com.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import lombok.Data;

@Data
@Entity
@Validated
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int uid;
	
	@NotNull(message = "name should not be null")
	private String uname;
	
	@Size(max = 20  , message = "address must not exceed length 20 ")
	private String uaddress;
	
	@Size(min = 10,max = 10 , message = "phone number must be 10 digits.")
	private String phonenumber;
	
	private int age;
	
	private String gender;
	
	@Email(message = "email should be in proper format.")
	private String email;
	
	@NotNull(message = "name should not be null")
	private String username;
	
	@NotNull(message = "name should not be null")
	@Size(min = 10,  message = "Password contains at least minimum 10 characters")
	private String upassword;
	
	@NotNull(message = "name should not be null")
	private long acNumber;
	
	
	
	

}
