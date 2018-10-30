package com.java.dbms.proj.main;

public class SupplierInventory {
	int Supplier_ID;
	int Part_ID;
	String DeliveryWindow;
	String UnitCost;
	public int getSupplier_ID() {
		return Supplier_ID;
	}
	public void setSupplier_ID(int supplier_ID) {
		Supplier_ID = supplier_ID;
	}
	public int getPart_ID() {
		return Part_ID;
	}
	public void setPart_ID(int part_ID) {
		Part_ID = part_ID;
	}
	public String getDeliveryWindow() {
		return DeliveryWindow;
	}
	public void setDeliveryWindow(String deliveryWindow) {
		DeliveryWindow = deliveryWindow;
	}
	public String getUnitCost() {
		return UnitCost;
	}
	public void setUnitCost(String unitCost) {
		UnitCost = unitCost;
	}
}
