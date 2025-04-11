package com.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DTO.UserDTO;
import com.Model.User;
import com.Service.UserService;

@RestController
@RequestMapping("/exponent/api")
public class UserController {
	
	@Autowired
	private UserService us;
	
	@PostMapping(value = "/reg")
	public ResponseEntity<?> addUser(@Valid @RequestBody User u){
		
		us.addUserInService(u);
		
		return new ResponseEntity("User added...", HttpStatus.OK);
		
	}
	
	@Cacheable(cacheNames = "getempbyid")
	@GetMapping(value = "/getbyId/{id}")
	public ResponseEntity<?> getUserById(@PathVariable("id") int id){
		
		UserDTO userdto = us.getUserByIdInService(id);
		
		return new ResponseEntity(userdto, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/deletebyId/{id}")
	public ResponseEntity<?> deleteUserById(@PathVariable("id") int id){
		
		us.deleteUserByIdInService(id);
		
		return new ResponseEntity("User deleted successfully!!", HttpStatus.OK);
	}
	
	@PutMapping(value = "/updateUserName/{id}/{name}")
	public ResponseEntity<?> updateUserName(@PathVariable("id") int id, @PathVariable("name") String name){
		
		User user = us.updateUserNameInService(id , name);
		
		if(user != null) {
		
		return new ResponseEntity(user, HttpStatus.OK);
		}else {
			return new ResponseEntity("User is not present", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
		
		@PutMapping(value = "/updateUser")
		public ResponseEntity<?> updateUser(@RequestBody User u){
			
			User user = us.updateUserInService(u);
			
			if(user != null) {
			
			return new ResponseEntity(user, HttpStatus.OK);
			}else {
				return new ResponseEntity("User is not present", HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			//one comment added.
	
	}
}
