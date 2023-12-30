package com.anudip.yourcare.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anudip.yourcare.dto.UserDto;
import com.anudip.yourcare.entity.User;
import com.anudip.yourcare.repository.UserRepository;
import com.anudip.yourcare.service.UserService;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	//Method to create new user into the DB
	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	//Method to print all the existing users from DB
	@Override
	public List<UserDto> getAllUsers() {
		List<User> users = userRepository.findAll();
		
		return users.stream().map(user -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
	}

	
	//Method to print user by using Id
	@Override
	public UserDto getUserById(int id) {
		Optional<User> existingUser = userRepository.findById(id);
		
		if(existingUser.isPresent())
		{
			UserDto userDto = modelMapper.map(existingUser, UserDto.class);
			return userDto;
		}
		return null;
	}

	//Method to get the existing user by using name
	@Override
	public UserDto getUserByFname(String fname) {
		
		User user = userRepository.findByFname(fname);
		 
		UserDto userDto = modelMapper.map(user, UserDto.class);
		return userDto;
	}

	
	//Method to Update the existing user on the basis of Fname in DB
	@Override
	public User updateUserByName(User user) {
		User existingUser = userRepository.findByFname(user.getFname());

		if(existingUser == null)
		{
			return null;
		}
	
		existingUser.setLname(user.getLname());
		existingUser.setAddress(user.getAddress());
		existingUser.setAge(user.getAge());
		existingUser.setBloodgroup(user.getBloodgroup());
		existingUser.setCity(user.getCity());
		existingUser.setDateofbirth(user.getDateofbirth());
		existingUser.setEmail(user.getEmail());
		existingUser.setGender(user.getGender());
		existingUser.setPhonenumber(user.getPhonenumber());
		
		return userRepository.save(existingUser);
	}

	@Override
	public String deleteUserByName(String name) {
		
		User checkUser = userRepository.findByFname(name);
		
		if(checkUser == null)
		{
			return null;
		}
		
		userRepository.deleteById(checkUser.getId());
		return "User deleted Successfully";
	}

}
