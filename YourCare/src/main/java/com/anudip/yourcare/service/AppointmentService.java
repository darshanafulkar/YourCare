package com.anudip.yourcare.service;

import java.util.List;

import com.anudip.yourcare.dto.AppointmentDto;
import com.anudip.yourcare.entity.Appointment;


public interface AppointmentService {

	    //Method for creating the Appointment
		public Appointment createAppointment(Appointment appointment);
		
		//Methods for getting Appointment
		public List<AppointmentDto> getAllAppointments();
		
		public AppointmentDto getAppointmentById(int id);
		
		public AppointmentDto getAppointmentByName(String name);
		
		//Method for Updating Appointment
		public Appointment updateAppointmentByName(Appointment appointment);
		
		
		//Method for Deleting the Appointment
		public String deleteAppointmentByName(String name);
		
		
}
