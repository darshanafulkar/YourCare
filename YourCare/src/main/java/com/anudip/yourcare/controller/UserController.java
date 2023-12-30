package com.anudip.yourcare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.anudip.yourcare.dto.UserDto;
import com.anudip.yourcare.entity.User;
import com.anudip.yourcare.service.impl.UserServiceImpl;



@RestController
public class UserController {

	@Autowired
	UserServiceImpl userServiceImpl;
	
	
	//This will get the request to create the new user
	@PostMapping("/user/create")
	public User addUser(@RequestBody User user)
	{
		return userServiceImpl.createUser(user);
	}
	
	//This will get the request to print all the existing users
	@GetMapping("/user/allUsers")
	public List<UserDto> getAllUser(@RequestBody User user)
	{
		return userServiceImpl.getAllUsers();
	}
	
	
	//This will get the request to print the user by using id
	@GetMapping("/user/userById/{id}")
	public UserDto findUserById(@PathVariable int id)
	{
		return userServiceImpl.getUserById(id);
	}
	
	//This will get the request to usdate the exixting user 
	@GetMapping("/user/userByName/{name}")
	public UserDto findByName(@PathVariable String name)
	{
		return userServiceImpl.getUserByFname(name);
	}
	
	//This will Get the request to update the existing user in the DB
	@PutMapping("/user/update")
	public User updateUser(@RequestBody User user)
	{
		return userServiceImpl.updateUserByName(user);
	}
	
	@DeleteMapping("/user/delete/{fname}")
	public String deleteByName(@PathVariable String fname)
	{
		String msg = userServiceImpl.deleteUserByName(fname);
		return msg;
	}
}
