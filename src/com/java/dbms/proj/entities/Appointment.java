package com.java.dbms.proj.entities;

public class Appointment {
	int appointmentID;
	String appointmentDate;
	String requestedMechanicFirstName;
	String requestedMechanicLastName;
	int mechanicId;
	public int getMechanicId() {
		return mechanicId;
	}
	public void setMechanicId(int mechanicId) {
		this.mechanicId = mechanicId;
	}
	String serviceType;
	String state;
	String serviceID;

	private Vehicle vehicle;
	
	
	public String getRequestedMechanicFirstName() {
		return requestedMechanicFirstName;
	}
	public void setRequestedMechanicFirstName(String requestedMechanicFirstName) {
		this.requestedMechanicFirstName = requestedMechanicFirstName;
	}
	public String getRequestedMechanicLastName() {
		return requestedMechanicLastName;
	}
	public void setRequestedMechanicLastName(String requestedMechanicLastName) {
		this.requestedMechanicLastName = requestedMechanicLastName;
	}
	
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
