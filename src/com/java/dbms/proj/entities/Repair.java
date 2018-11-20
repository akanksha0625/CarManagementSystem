package com.java.dbms.proj.entities;

import java.util.ArrayList;

public class Repair extends Service {
	String diagnosis;
	double diagnosisFee;
	String service; 
	String repairID; // options 1-8
	ArrayList<String> subServices =  new ArrayList<String>();
	public ArrayList<Part> partsList = new ArrayList<Part>();
	
	public ArrayList<String> getSubServices() {
		return subServices;
	}
	public void setSubServices(ArrayList<String> subServices) {
		this.subServices = subServices;
	}
	public void setPartsList(ArrayList<Part> partsList) {
		this.partsList = partsList;
	}
	
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public double getDiagnosisFee() {
		return diagnosisFee;
	}
	public void setDiagnosisFee(double diagnosisFee) {
		this.diagnosisFee = diagnosisFee;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getRepairID() {
		return repairID;
	}
	public void setRepairID(String repairID) {
		this.repairID = repairID;
	}
	public String getRepairName() {
		return super.getServiceName();
	}
	public void setRepairName(String repairName) {
		super.setServiceName(repairName);
	}
	public ArrayList<Part> getPartsList() {
		return partsList;
	}
	
	public String repairPartsToString() {
		return super.partsToString(partsList);
	}
}
