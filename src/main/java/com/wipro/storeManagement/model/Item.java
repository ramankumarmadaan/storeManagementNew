package com.wipro.storeManagement.model;

public class Item {
	
	private int itemNo;
	private String name;        // Product description
	private int inventoryCode;  // product ID
	private int volume;         // amount available in stock
	

	// Get & Set for itemNo
	public int getItemNo() { return itemNo; }
	public void setItemNo(int itemNo) { this.itemNo = itemNo; }
	
	// Get & Set for name
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	// Get & Set for amount
	public int getAmount() { return volume; }

	public void setAmount(int volume) { this.volume = volume; }

	public void setVolume(int volume) { this.volume = volume; }

	// Get & Set for inventoryCode
	public int getInventoryCode() { return inventoryCode; }
	public void setInventoryCode(int inventoryCode) { this.inventoryCode = inventoryCode; }

	// Update an item amount by changedQuantity (Withdrawal/Deposit)
	public void updateAmount(int changedQuantity) {
		volume += changedQuantity;
	}
	
}

