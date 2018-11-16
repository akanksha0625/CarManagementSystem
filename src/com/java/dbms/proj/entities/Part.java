package com.java.dbms.proj.entities;

public class Part {
	int partID;
	String partName;
	double unitCost;
	String requiredFor;
	int unitsRequired;
	double installTime;
	String chargeType;
	
	public int getUnitsRequired() {
		return unitsRequired;
	}
	public void setUnitsRequired(int unitsRequired) {
		this.unitsRequired = unitsRequired;
	}

	public String getChargeType() {
		return chargeType;
	}
	public void setChargeType(String chargeType) {
		this.chargeType = chargeType;
	}
	double installCharge;
	

	public String getRequiredFor() {
		return requiredFor;
	}
	public void setRequiredFor(String requiredFor) {
		this.requiredFor = requiredFor;
	}
	public double getInstallTime() {
		return installTime;
	}
	public void setInstallTime(double installTime) {
		this.installTime = installTime;
	}
	public double getInstallCharge() {
		return installCharge;
	}
	public void setInstallCharge(double installCharge) {
		this.installCharge = installCharge;
	}
	public double getUnitCost() {
		return unitCost;
	}
	public void setUnitCost(double unitCost) {
		this.unitCost = unitCost;
	}
	public Part( String partName, int partID){
		this.setPartID(partID);
		this.setPartName(partName);
	}
	public Part() {
		this(null,0);
	}
	public int getPartID() {
		return partID;
	}
	
	public void setPartID(int partID) {
		this.partID = partID;
	}
	public String getPartName() {
		return partName;
	}
	public void setPartName(String partName) {
		this.partName = partName;
	}
}
