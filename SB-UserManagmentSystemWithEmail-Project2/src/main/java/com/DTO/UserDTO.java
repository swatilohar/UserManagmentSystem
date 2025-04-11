package com.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(value = Include.NON_NULL)
public class UserDTO {
	
	private int uid;
	
	private String uname;
	
	private String uaddress;
	
	private int age;
	
	private String gender;
	
	private String msg;
	
}
