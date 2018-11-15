package com.java.dbms.proj.entities;


public class Service {
	
	String appointmentID;
	int customerID;
	String vehicleLicense;
	String appointmentDate;
	String appointmentStartTime;
	String requestedMechanic;
	String actualMechanic;
	String serviceType;
	String serviceName;
	String serviceStatus;
	TimeSlot timeSlot = new TimeSlot();
	String serviceTypeID;
	
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getActualMechanic() {
		return actualMechanic;
	}
	public void setActualMechanic(String actualMechanic) {
		this.actualMechanic = actualMechanic;
	}	
	public void createTimeSlot(int slotID, String startTime, String endTime) {
		timeSlot = new TimeSlot();
		timeSlot.setStartTime(startTime);
		timeSlot.setEndTime(endTime);
		timeSlot.setSlotID(slotID);
	}
	public String getAppointmentID() {
		return appointmentID;
	}
	public void setAppointmentID(String appointmentID) {
		this.appointmentID = appointmentID;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public String getVehicleLicense() {
		return vehicleLicense;
	}
	public void setVehicleLicense(String vehicleLicense) {
		this.vehicleLicense = vehicleLicense;
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
	public String getServiceStatus() {
		return serviceStatus;
	}
	public void setServiceStatus(String serviceStatus) {
		this.serviceStatus = serviceStatus;
	}
	public TimeSlot getTimeSlot() {
		return timeSlot;
	}

	public String getServiceTypeID() {
		return serviceTypeID;
	}
	public void setServiceTypeID(String serviceTypeID) {
		this.serviceTypeID = serviceTypeID;
	}
	
	public String toString() {
		return "Service ID        :\t" + this.getAppointmentID() +
			   "\nService Date|Time :\t" + this.getAppointmentDate() + "|" + this.getTimeSlot().getStartTime() +
			   "\nVehicle License   :\t" + this.getVehicleLicense() +
			   "\nService Type      :\t" + this.getServiceType() + " : \"" + this.getServiceName() + "\"" +
			   "\nMechanic Name     :\t" + this.getActualMechanic() +
			   "\nParts             :\t PRINT PARTS\\COST" +
			   "\nTotal Labor Hours :\t PRINT HOURS" +
			   "\nTotal Service Cost:\t PRINT COST";
	}

}
