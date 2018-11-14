package com.java.dbms.proj.entities;

import java.util.Date;

public class Appointment {
	int appointmentID;
	String appointmentDate;
	String requestedMechanic;
	String serviceType;
	String state;
	String serviceID;

	private Vehicle vehicle;
	
	
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public int getAppointmentID() {
		return appointmentID;
	}
	public void setAppointmentID(int appointmentID) {
		this.appointmentID = appointmentID;
	}
	public String getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public String getRequestedMechanic() {
		return requestedMechanic;
	}
	public void setRequestedMechanic(String requestedMechanic) {
		this.requestedMechanic = requestedMechanic;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getServiceID() {
		return serviceID;
	}
	public void setServiceID(String serviceID) {
		this.serviceID = serviceID;
	}
}
