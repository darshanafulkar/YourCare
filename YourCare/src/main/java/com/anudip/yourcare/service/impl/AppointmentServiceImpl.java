package com.anudip.yourcare.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anudip.yourcare.dto.AppointmentDto;
import com.anudip.yourcare.entity.Appointment;
import com.anudip.yourcare.repository.AppointmentRepository;
import com.anudip.yourcare.service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService {

	

	@Autowired
	AppointmentRepository appointmentRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public Appointment createAppointment(Appointment appointment) {
		
		return appointmentRepository.save(appointment);
	}

	@Override
	public List<AppointmentDto> getAllAppointments() {
		
		List<Appointment> appointments = appointmentRepository.findAll();
		return appointments.stream().map(appointment -> modelMapper.map(appointment, AppointmentDto.class)).collect(Collectors.toList());
	}

	
	@Override
	public AppointmentDto getAppointmentById(int id) {
		Appointment existingAppointment = appointmentRepository.findById(id).get();
		
		AppointmentDto appointmentDto = modelMapper.map(existingAppointment, AppointmentDto.class);
		return appointmentDto;
	}

	@Override
	public AppointmentDto getAppointmentByName(String fname) {
		Appointment existingAppointment = appointmentRepository.findAppointmentByFname(fname);
		
		AppointmentDto appointmentDto = modelMapper.map(existingAppointment, AppointmentDto.class);
		return appointmentDto;
	}

	@Override
	public Appointment updateAppointmentByName(Appointment appointment) {
		Appointment existingAppointment = appointmentRepository.findAppointmentByFname(appointment.getFname());
		
		existingAppointment.setLname(appointment.getLname());
		existingAppointment.setAddress(appointment.getAddress());
		existingAppointment.setAge(appointment.getAge());
		existingAppointment.setAppointmentdate(appointment.getAppointmentdate());
		existingAppointment.setAppointmenttime(appointment.getAppointmenttime());
		existingAppointment.setDeseases(appointment.getDeseases());
		existingAppointment.setGender(appointment.getGender());
		existingAppointment.setPhonenumber(appointment.getPhonenumber());
		existingAppointment.setSpecialization(appointment.getSpecialization());
		existingAppointment.setSymptoms(appointment.getSymptoms());
		existingAppointment.setDoctor(appointment.getDoctor());
		
		return appointmentRepository.save(existingAppointment);
	}

	@Override
	public String deleteAppointmentByName(String name) {
		Appointment existingAppointment = appointmentRepository.findAppointmentByFname(name);
		
		appointmentRepository.delete(existingAppointment);
		
		return "The appointment is deleted";
	}

}
