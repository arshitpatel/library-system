package com.library.lending.model;

import java.io.Serializable;

public class Item implements Serializable{

	private static final long serialVersionUID = 1L;
	private int itemId;
	private String name;
	private int totalQty;
	private int available;
	
	public Item() {
		//default
	}

	public Item(int itemId, String name, int totalQty) {
		this.itemId = itemId;
		this.name = name;
		this.totalQty = totalQty;
		this.available = totalQty;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTotalQty() {
		return totalQty;
	}

	public void setTotalQty(int totalQty) {
		this.totalQty = totalQty;
	}

	public int getAvailable() {
		return available;
	}

	public void setAvailable(int available) {
		this.available = available;
	}
	
	@Override
	public int hashCode() {
		return itemId;
	}
	
	@Override
    public boolean equals(Object obj) {
		return ((Item) obj).getItemId() == this.itemId;
	}

}
