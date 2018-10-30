package com.java.dbms.proj.entities;

public class Repair {
	private int repairID;
	private double repairCost;
	private double diagnosisFee;
	private double hourlyRate;
	
	public int getRepairID() {
		return repairID;
	}
	public void setRepairID(int repairID) {
		this.repairID = repairID;
	}
	public double getRepairCost() {
		return repairCost;
	}
	public void setRepairCost(double repairCost) {
		this.repairCost = repairCost;
	}
	public double getDiagnosisFee() {
		return diagnosisFee;
	}
	public void setDiagnosisFee(double diagnosisFee) {
		this.diagnosisFee = diagnosisFee;
	}
	public double getHourlyRate() {
		return hourlyRate;
	}
	public void setHourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

}
