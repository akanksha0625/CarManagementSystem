package com.java.dbms.proj.entities;

import java.util.ArrayList;

import com.java.dbms.proj.common.HelperFunctions;

public class Service {

	private String appointmentID;
	private int customerID;
	private int mechanicID;
	private String vehicleLicense;
	private String appointmentDate;
	private String appointmentStartTime;
	private String requestedMechanic;
	private String actualMechanic;
	private String serviceType;
	private String serviceName;
	private String serviceStatus;
	private double totalCost = 0;
	private double totalInstallationCost = 0;
	private double totalPartsCost = 0;
	private double totalHours = 0.0;
	private TimeSlot timeSlot = new TimeSlot();
	private String serviceTypeID;
	private String firstAID = "";
	private String firstBID = "";
	private String firstCID = "";
	private String CustomerName = "";
	private String serviceCenterID = "";
	private double mechanicCost = 0;

	public double getMechanicCost() {
		return mechanicCost;
	}

	public void setMechanicCost(double mechanicCost) {
		this.mechanicCost = mechanicCost;
	}

	public String getFirstAID() {
		return firstAID;
	}

	public void setFirstAID(String firstAID) {
		this.firstAID = firstAID;
	}

	public String getFirstBID() {
		return firstBID;
	}

	public void setFirstBID(String firstBID) {
		this.firstBID = firstBID;
	}

	public String getFirstCID() {
		return firstCID;
	}

	public void setFirstCID(String firstCID) {
		this.firstCID = firstCID;
	}

	public void addToPartsCost(double charge) {
		this.totalPartsCost += charge;
	}

	public void addToInstallationCost(double charge) {
		this.totalInstallationCost += charge;
	}

	public double getTotalCost() {
		return this.totalCost;
	}

	public void addToTotalHours(double hours) {
		this.totalHours += hours;
	}

	public double getTotalHours() {
		return this.totalHours;
	}

	public ArrayList<Integer> requiredServiceIDs = new ArrayList<Integer>();

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

	public String toCustomerString() {
		if (this.serviceType.equalsIgnoreCase("maintenance") && (this.getAppointmentID().equals(this.getFirstAID())
				|| this.getAppointmentID().equals(this.getFirstBID())
				|| this.getAppointmentID().equals(this.getFirstCID()))) {
			System.out.println("\nService Note : First Time Maintenance " + this.getServiceType()
					+ "for Vehicle License \"" + this.getVehicleLicense() + "\"");
			System.out.println("\tTotal of $" + this.totalInstallationCost + " installation deducted from invoice.\n");
		} else {
			this.totalCost += this.totalInstallationCost;
		}

		this.totalCost += this.totalPartsCost;

		return "Service ID              :\t" + this.getAppointmentID() + "\nService Start Date|Time :\t" + this.getAppointmentDate() + "|"
				+ this.getTimeSlot().getStartTime() + "\nService End Date|Time   :\t" + this.getAppointmentDate() + "|"
				+ HelperFunctions.addTime(this.getTimeSlot().getStartTime(), this.getTotalHours())
				+ "\nVehicle License         :\t" + this.getVehicleLicense() + "\nService Type            :\t"
				+ this.getServiceType() + " : \"" + this.getServiceName() + "\"" + "\nMechanic Name           :\t"
				+ this.getActualMechanic() + "\nTotal Labor Hours       :\t" + this.getTotalHours()
				+ "\nLabor Wages per Hour    :\t$" + this.getMechanicCost() + "\nTotal Service Cost      :\t$"
				+ this.getTotalCost() + "\n\nParts Required for Service "
				+ "\n-------------------------------------------------------";

	}

	public String toManagerString() {
		if (this.serviceType.equalsIgnoreCase("maintenance") && (this.getAppointmentID().equals(this.getFirstAID())
				|| this.getAppointmentID().equals(this.getFirstBID())
				|| this.getAppointmentID().equals(this.getFirstCID()))) {
			System.out.println("\nService Note : First Time Maintenance " + this.getServiceType()
					+ "for Vehicle License \"" + this.getVehicleLicense() + "\"");
			System.out.println("\tTotal of $" + this.totalInstallationCost + " installation deducted from invoice.\n");
		} else {
			this.totalCost += this.totalInstallationCost;
		}

		this.totalCost += this.totalPartsCost;

		return "Service ID              :\t" + this.getAppointmentID() + "\nCustomer Name           :\t"
				+ this.getCustomerName() + "\nService Start Date|Time :\t" + this.getAppointmentDate() + "|"
				+ this.getTimeSlot().getStartTime() + "\nService End Date|Time   :\t" + this.getAppointmentDate() + "|"
				+ HelperFunctions.addTime(this.getTimeSlot().getStartTime(), this.getTotalHours())
				+ "\nVehicle License         :\t" + this.getVehicleLicense() + "\nService Type            :\t"
				+ this.getServiceType() + " : \"" + this.getServiceName() + "\"" + "\nMechanic Name           :\t"
				+ this.getActualMechanic() + "\nTotal Labor Hours       :\t" + this.getTotalHours()
				+ "\nLabor Wages per Hour    :\t$" + this.getMechanicCost() + "\nTotal Service Cost      :\t$"
				+ this.getTotalCost() + "\n\nParts Required for Service "
				+ "\n-------------------------------------------------------";

	}

	public String partsToString(ArrayList<Part> partsList) {
		String returnString = "";
		for (int i = 0; i < partsList.size(); i++) {
			Part part = partsList.get(i);
			returnString += "- " + part.getPartName() + " | " + part.getUnitsRequired() + " unit(s) | $"
					+ part.getUnitCost() + " per unit " + " | installation : $" + part.getInstallCharge()
					+ " | required for " + part.getRequiredFor() + "\n";
		}
		return returnString;
	}

	public String getAppointmentStartTime() {
		return appointmentStartTime;
	}

	public void setAppointmentStartTime(String appointmentStartTime) {
		this.appointmentStartTime = appointmentStartTime;
	}

	public String getCustomerName() {
		return CustomerName;
	}

	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}

	public String getServiceCenterID() {
		return serviceCenterID;
	}

	public void setServiceCenterID(String serviceCenterID) {
		this.serviceCenterID = serviceCenterID;
	}

	public int getMechanicID() {
		return mechanicID;
	}

	public void setMechanicID(int mechanicID) {
		this.mechanicID = mechanicID;
	}
}
