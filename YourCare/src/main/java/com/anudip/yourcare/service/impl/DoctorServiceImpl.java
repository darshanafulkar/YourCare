package com.anudip.yourcare.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anudip.yourcare.dto.DoctorDto;
import com.anudip.yourcare.entity.Doctor;
import com.anudip.yourcare.repository.DoctorRepository;
import com.anudip.yourcare.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService{

	@Autowired
	DoctorRepository doctorRepository;
	
	@Autowired
	ModelMapper modelMapper;

	@Override
	public Doctor createDoctor(Doctor doctor) {
		
		return doctorRepository.save(doctor);
	}

	@Override
	public List<DoctorDto> getAllDoctor() {
		
		List<Doctor> doctors = doctorRepository.findAll();
		
		return  doctors.stream().map(doctor -> modelMapper.map(doctor, DoctorDto.class)).collect(Collectors.toList());
	}

	@Override
	public Doctor getDoctorById(int id) {
		
		Doctor existingDoctor = doctorRepository.findById(id).get();
		
		//DoctorDto doctorDto = modelMapper.map(existingDoctor, DoctorDto.class);
		return existingDoctor;
	}

	@Override
	public Doctor getDoctorByName(String name) {
		Doctor existingDoctror = doctorRepository.findByFname(name);
		
		//DoctorDto doctorDto = modelMapper.map(existingDoctror, DoctorDto.class);
		return existingDoctror;
	}

	@Override
	public Doctor updateDoctorByName(Doctor doctor) {
		
		Doctor existingDoctor = doctorRepository.findByFname(doctor.getFname());
		
		existingDoctor.setLname(doctor.getLname());
		existingDoctor.setAddress(doctor.getAddress());
		existingDoctor.setAge(doctor.getAge());
		existingDoctor.setDateofbirth(doctor.getDateofbirth());
		existingDoctor.setCity(doctor.getCity());
		existingDoctor.setEmail(doctor.getEmail());
		existingDoctor.setGender(doctor.getGender());
		existingDoctor.setPhonenumber(doctor.getPhonenumber());
		existingDoctor.setQualification(doctor.getQualification());
		existingDoctor.setSpecialization(doctor.getSpecialization());
		
		return doctorRepository.save(existingDoctor);
	}

	@Override
	public String deleteDoctorByName(String name) {
		
		Doctor checkDoctor = doctorRepository.findByFname(name);
		
		if(checkDoctor == null)
		{
			return null;
		}
		
		doctorRepository.deleteById(checkDoctor.getId());
		return "The Record is deleted successfully";
	}

	
	

}
