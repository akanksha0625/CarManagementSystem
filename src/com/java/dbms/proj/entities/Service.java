package com.java.dbms.proj.entities;

import java.util.ArrayList;


public class Service {
	
	String serviceID;
	String startDate;
	String endDate;
	String startTime;
	String endTime;
	String serviceDescription;
	String license;
	String serviceType;
	String serviceAbrev;
	public String getServiceAbrev() {
		return serviceAbrev;
	}
	public void setServiceAbrev(String serviceAbrev) {
		this.serviceAbrev = serviceAbrev;
	}
	String mechanic;
	ArrayList<Part> parts;
	String totalLaborHours;
	double costPerHour;
	double totalCost;
	double diagnosisFee = 0;
	String diagnosis;
	
	public double getDiagnosisFee() {
		return diagnosisFee;
	}
	public void setDiagnosisFee(double diagnosisFee) {
		this.diagnosisFee = diagnosisFee;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public String getServiceDescription() {
		return serviceDescription;
	}
	public void setServiceDescription(String serviceDescription) {
		this.serviceDescription = serviceDescription;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public void addPart( Part part ) {
		parts.add(part);
	}
	public String getServiceID() {
		return serviceID;
	}
	public void setServiceID(String serviceID) {
		this.serviceID = serviceID;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getLicense() {
		return license;
	}
	public void setLicense(String license) {
		this.license = license;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public String getMechanic() {
		return mechanic;
	}
	public void setMechanic(String mechanic) {
		this.mechanic = mechanic;
	}
	public ArrayList<Part> getParts() {
		return parts;
	}
	public void setParts(ArrayList<Part> parts) {
		this.parts = parts;
	}
	public String getTotalLaborHours() {
		return totalLaborHours;
	}
	public void setTotalLaborHours(String totalHours) {
		this.totalLaborHours = totalHours;
	}
	public double getCostPerHour() {
		return costPerHour;
	}
	public void setCostPerHour(double costPerHour) {
		this.costPerHour = costPerHour;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

}
