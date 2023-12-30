package com.anudip.yourcare.service;

import java.util.List;

import com.anudip.yourcare.dto.UserDto;
import com.anudip.yourcare.entity.User;

public interface UserService {
	
	
	//Method for creating the user
	public User createUser(User user);
	
	//Methods for getting User
	public List<UserDto> getAllUsers();
	
	public UserDto getUserById(int id);
	
	public UserDto getUserByFname(String fname);
	
	//Method for Updating Users
	public User updateUserByName(User user);
	
	
	//Method for Deleting the user
	public String deleteUserByName(String name);
	
	
	
	

}
