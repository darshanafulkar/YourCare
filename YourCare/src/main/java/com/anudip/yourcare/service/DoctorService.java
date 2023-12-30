package com.anudip.yourcare.service;

import java.util.List;

import com.anudip.yourcare.dto.DoctorDto;
import com.anudip.yourcare.entity.Doctor;


public interface DoctorService {

    	//Method for creating the Doctor
		public Doctor createDoctor(Doctor doctor);
		
		//Methods for getting Doctor
		public List<DoctorDto> getAllDoctor();
		
		public Doctor getDoctorById(int id);
		
		public Doctor getDoctorByName(String name);
		
		//Method for Updating Doctor
		public Doctor updateDoctorByName(Doctor doctor);
		
		
		//Method for Deleting the Doctor
		public String deleteDoctorByName(String name);
		
		
		
}
