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

import com.anudip.yourcare.dto.AppointmentDto;
import com.anudip.yourcare.entity.Appointment;
import com.anudip.yourcare.entity.Doctor;
import com.anudip.yourcare.service.impl.AppointmentServiceImpl;
import com.anudip.yourcare.service.impl.DoctorServiceImpl;



@RestController
public class AppointmentControler {

	@Autowired
	AppointmentServiceImpl appointmentServiceImpl;
	
	@Autowired
	DoctorServiceImpl doctorServiceImpl;
	
	@PostMapping("/appointment/{fname}/create")
	public Appointment addAppointment(@RequestBody Appointment appointment,@PathVariable String fname)
	{
		Doctor doctor = doctorServiceImpl.getDoctorByName(fname);
		appointment.setDoctor(doctor);
		
		return appointmentServiceImpl.createAppointment(appointment);
		
	}
	
	@GetMapping("/appointment/all")
	public List<AppointmentDto> getAllAppointments()
	{
		return appointmentServiceImpl.getAllAppointments();
	}
	
	@GetMapping("/appointment/{id}/id")
	public AppointmentDto getAppointmentBYId(@PathVariable int id)
	{
		return appointmentServiceImpl.getAppointmentById(id);
	}
	
	@GetMapping("/appointment/{fname}/fname")
	public AppointmentDto getAppointmentByFname(@PathVariable String fname)
	{
		return appointmentServiceImpl.getAppointmentByName(fname);
	}
	
	@PutMapping("/appointment/update")
	public Appointment updateAppointmentByFname(@RequestBody Appointment appointment)
	{		
		return appointmentServiceImpl.createAppointment(appointment);
	}
	
	@DeleteMapping("/appointment/{fname}/delete")
	public String deleteAppointmentById(@PathVariable String fname)
	{
		return appointmentServiceImpl.deleteAppointmentByName(fname);
	}
	
}
