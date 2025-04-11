package com.Service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DTO.UserDTO;
import com.Model.User;
import com.Repository.UserRepo;

@Service
public class UserServiceIMPL implements UserService {

	@Autowired
	private UserRepo ur;

	Logger logger = LoggerFactory.getLogger(UserServiceIMPL.class);

	@Override
	@Transactional
	public void addUserInService(User u) {
		if (u != null) {
			ur.save(u);
			logger.info("User added....");
		} else {
			logger.info("User is null");
		}

	}

	@Override
	public UserDTO getUserByIdInService(int id) {
		User user = ur.findById(id).get();
		UserDTO ud = new UserDTO();
		if (user != null) {
			ud.setUname(user.getUname());
			ud.setUid(user.getUid());
			ud.setUaddress(user.getUaddress());
			ud.setAge(user.getAge());
			ud.setGender(user.getGender());

			return ud;
		} else {
			ud.setMsg("user is null");

			return ud;
		}

	}

	@Override
	public void deleteUserByIdInService(int id) {
		ur.deleteById(id);
		logger.info("User deleted succssfully!!");

	}

	@Override
	public User updateUserNameInService(int id, String name) {
		User user = ur.findById(id).get();
		if (user != null) {
			user.setUname(name);
			ur.save(user);
			logger.info("User updated successfully!!!");
			}
		return user;
	}

	@Override
	public User updateUserInService(User u) {
		
	
		User user1 = ur.save(u);
		return user1;
	}

	
}
