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

import com.anudip.yourcare.dto.DoctorDto;
import com.anudip.yourcare.entity.Doctor;
import com.anudip.yourcare.service.impl.DoctorServiceImpl;

@RestController
public class DoctorController {

	@Autowired
	DoctorServiceImpl doctorServiceImpl;
	
	   //This will get the request to create the new Doctor
		@PostMapping("/doctor/create")
		public Doctor addDoctor(@RequestBody Doctor doctor)
		{
			return doctorServiceImpl.createDoctor(doctor);
		}
		
		//This will get the request to print all the existing Doctor
		@GetMapping("/doctor/allDoctor")
		public List<DoctorDto> getAllUser(@RequestBody Doctor doctor)
		{
			return doctorServiceImpl.getAllDoctor();
		}
		
		
		//This will get the request to print the Doctor by using id
		@GetMapping("/doctor/doctorById/{id}")
		public Doctor findDoctorById(@PathVariable int id)
		{
			return doctorServiceImpl.getDoctorById(id);
		}
		
		//This will get the request to update the existing Doctor 
		@GetMapping("/doctor/doctorByName/{fname}")
		public Doctor findByName(@PathVariable String fname)
		{
			return doctorServiceImpl.getDoctorByName(fname);
		}
		
		
		//This will Get the request to update the existing doctor in the DB
		@PutMapping("/doctor/update")
		public Doctor updateDoctor(@RequestBody Doctor doctor)
		{
			return doctorServiceImpl.updateDoctorByName(doctor);
		}
		
		@DeleteMapping("/doctor/delete/{fname}")
		public String deleteByName(@PathVariable String fname)
		{
			String msg = doctorServiceImpl.deleteDoctorByName(fname);
			return msg;
		}
		
		
}
