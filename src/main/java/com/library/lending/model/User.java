package com.library.lending.model;

public class User {

	private long uId;
	private String name;
	private String contactNo;
	private int depositedAmount;
	private int totalDue;
	private static volatile long count = 0;

	public User(String name, String contact) {
		this.name = name;
		this.contactNo = contact;
		this.depositedAmount = 100;
		synchronized (User.class) {
			this.uId = count++;
		}
	}

	public long getuId() {
		return uId;
	}

	public void setuId(long uId) {
		this.uId = uId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public int getDepositedAmount() {
		return depositedAmount;
	}

	public void setDepositedAmount(int depositedAmount) {
		this.depositedAmount = depositedAmount;
	}

	public int getTtalDue() {
		return totalDue;
	}

	public void setTotalDue(int totalDue) {
		this.totalDue = totalDue;
	}

	@Override
	public int hashCode() {
		return (int) uId;
	}

	@Override
	public boolean equals(Object obj) {
		return ((User) obj).getuId() == this.uId;
	}

}
