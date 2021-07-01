package com.library.lending.model;

import java.util.Calendar;
import java.util.Date;

public class RentedItem {

	private long userId;
	private int itemId;
	private Date rentedTime;
	private int dueForItem;
	private Date dueDate;

	public RentedItem(long userId, int itemId) {
		this.userId = userId;
		this.dueForItem = 0;
		this.itemId = itemId;
		this.rentedTime = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(rentedTime);
		c.add(Calendar.DATE, 7);
		this.dueDate = c.getTime();
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public Date getRentedTime() {
		return rentedTime;
	}

	public void setRentedTime(Date rentedTime) {
		this.rentedTime = rentedTime;
	}

	public int getDueForItem() {
		return dueForItem;
	}

	public void setDueForItem(int dueForItem) {
		this.dueForItem = dueForItem;
	}

	public Date getDueDate() {
		return dueDate;
	}

	@Override
	public int hashCode() {
		return String.valueOf(rentedTime.getTime()).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return ((RentedItem) obj).getRentedTime().getTime() == this.rentedTime.getTime();
	}

}
