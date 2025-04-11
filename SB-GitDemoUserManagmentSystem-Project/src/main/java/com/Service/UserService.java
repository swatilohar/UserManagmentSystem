package com.Service;

import com.DTO.UserDTO;
import com.Model.User;

public interface UserService {

	void addUserInService(User u);

	UserDTO getUserByIdInService(int id);

	void deleteUserByIdInService(int id);

	User updateUserNameInService(int id, String name);

	User updateUserInService(User u);

}
