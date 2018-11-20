package com.java.dbms.proj.entities;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ServiceDetails {
	private String make = "";
	private String model = "";
	private String year = "";
	private ArrayList<Integer> serviceAIDs = new ArrayList<Integer>();
	private ArrayList<Integer> serviceBIDs = new ArrayList<Integer>();
	private ArrayList<Integer> serviceCIDs = new ArrayList<Integer>();
	private ArrayList<Part> serviceAParts = new ArrayList<Part>();
	private ArrayList<Part> serviceBParts = new ArrayList<Part>();
	private ArrayList<Part> serviceCParts = new ArrayList<Part>();
	private int aMiles = 0;
	private int bMiles = 0;
	private int cMiles = 0;
	private int aMonths = 0;
	private int bMonths = 0;
	private int cMonths = 0;
	private int aMaintenanceID = 0;
	private int bMaintenanceID = 0;
	private int cMaintenanceID = 0;

	public int getaMaintenanceID() {
		return aMaintenanceID;
	}

	public void setaMaintenanceID(int aMaintenanceID) {
		this.aMaintenanceID = aMaintenanceID;
	}

	public int getbMaintenanceID() {
		return bMaintenanceID;
	}

	public void setbMaintenanceID(int bMaintenanceID) {
		this.bMaintenanceID = bMaintenanceID;
	}

	public int getcMaintenanceID() {
		return cMaintenanceID;
	}

	public void setcMaintenanceID(int cMaintenanceID) {
		this.cMaintenanceID = cMaintenanceID;
	}

	public int getaMonths() {
		return aMonths;
	}

	public void setaMonths(int aMonths) {
		this.aMonths = aMonths;
	}

	public int getbMonths() {
		return bMonths;
	}

	public void setbMonths(int bMonths) {
		this.bMonths = bMonths;
	}

	public int getcMonths() {
		return cMonths;
	}

	public void setcMonths(int cMonths) {
		this.cMonths = cMonths;
	}

	private int vid;

	public int getaMiles() {
		return aMiles;
	}

	public void setaMiles(int aMiles) {
		this.aMiles = aMiles;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public ArrayList<Part> getServiceAParts() {
		return serviceAParts;
	}

	public void setServiceAParts(ArrayList<Part> serviceAParts) {
		this.serviceAParts = serviceAParts;
	}

	public ArrayList<Part> getServiceBParts() {
		return serviceBParts;
	}

	public void setServiceBParts(ArrayList<Part> serviceBParts) {
		this.serviceBParts = serviceBParts;
	}

	public ArrayList<Part> getServiceCParts() {
		return serviceCParts;
	}

	public void setServiceCParts(ArrayList<Part> serviceCParts) {
		this.serviceCParts = serviceCParts;
	}

	public int getbMiles() {
		return bMiles;
	}

	public void setbMiles(int bMiles) {
		this.bMiles = bMiles;
	}

	public int getcMiles() {
		return cMiles;
	}

	public void setcMiles(int cMiles) {
		this.cMiles = cMiles;
	}

	public int getVid() {
		return vid;
	}

	public void setVid(int vid) {
		this.vid = vid;
	}

	public ArrayList<Integer> getServiceAIDs() {
		return serviceAIDs;
	}

	public void setServiceAIDs(ArrayList<Integer> serviceAIDs) {
		this.serviceAIDs = serviceAIDs;
	}

	public ArrayList<Integer> getServiceBIDs() {
		return serviceBIDs;
	}

	public void setServiceBIDs(ArrayList<Integer> serviceBIDs) {
		this.serviceBIDs = serviceBIDs;
	}

	public ArrayList<Integer> getServiceCIDs() {
		return serviceCIDs;
	}

	public void setServiceCIDs(ArrayList<Integer> serviceCIDs) {
		this.serviceCIDs = serviceCIDs;
	}

	public String detailPartsToString(ArrayList<Part> partsList) {
		String returnString = "";
		for (int i = 0; i < partsList.size(); i++) {
			Part part = partsList.get(i);
			returnString += "\t\t\t- " + part.getPartName() + " | " + part.getUnitsRequired() + " unit(s)\n";
		}
		return returnString;
	}

	public String toString() {
		return "\n\tMake | Model | Year :\t" + this.make + " | " + this.model + " | " + this.year + "\n\tService A:"
				+ "\n\t\tMiles  : " + this.aMiles + "\n\t\tMonths : " + this.aMonths
				+ "\n\t\tParts  : Required Parts Listed Below\n\t\t\t--------------------------------\n" + detailPartsToString(this.serviceAParts)
				+ "\n\tService B:" + "\n\t\tMiles  : " + this.bMiles + "\n\t\tMonths : " + this.bMonths
				+ "\n\t\tParts  : Additional Required Parts Listed Below\n\t\t\t--------------------------------\n" + detailPartsToString(this.serviceBParts)
				+ "\n\tService C:" + "\n\t\tMiles  : " + this.cMiles + "\n\t\tMonths : " + this.cMonths
				+ "\n\t\tParts  : Additional Required Parts Listed Below\n\t\t\t--------------------------------\n" + detailPartsToString(this.serviceCParts)
				+ "\n";
	}
}
