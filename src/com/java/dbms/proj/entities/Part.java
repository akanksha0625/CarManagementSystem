package com.java.dbms.proj.entities;

public class Part {
	int partID;
	String partName;
	
	public Part( String partName, int partID ){
		this.setPartID(partID);
		this.setPartName(partName);
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
