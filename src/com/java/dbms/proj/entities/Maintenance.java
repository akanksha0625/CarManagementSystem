package com.java.dbms.proj.entities;

import java.util.ArrayList;

public class Maintenance extends Service {
	int vechileID;
	double miles;
	int months;
	String maintenanceID;

	public String getMaintenanceName() {
		return super.getServiceName();
	}

	public void setMaintenanceName(String maintenanceName) {
		super.setServiceName(maintenanceName);
	}

	ArrayList<Part> partsList = new ArrayList<Part>();
	
	public int getVechileID() {
		return vechileID;
	}

	public void setVechileID(int vechileID) {
		this.vechileID = vechileID;
	}

	public double getMiles() {
		return miles;
	}

	public void setMiles(double miles) {
		this.miles = miles;
	}

	public int getMonths() {
		return months;
	}

	public void setMonths(int months) {
		this.months = months;
	}

	public String getMaintenanceID() {
		return maintenanceID;
	}

	public void setMaintenanceID(String maintenanceID) {
		this.maintenanceID = maintenanceID;
	}

	public ArrayList<Part> getPartsList() {
		return partsList;
	}

	public String repairPartsToString() {
		return super.partsToString(partsList);
	}
}
