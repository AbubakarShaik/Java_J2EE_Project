package com.testbean;

public class Employee {
	private String Name;
	private String Mail_Id;
	private String Password;
	private String conform_Password;
	private int Mobile_Number;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getMailId() {
		return Mail_Id;
	}
	public void setMailId(String mailId) {
		Mail_Id = mailId;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getConformPassword() {
		return conform_Password;
	}
	public void setConformPassword(String conformPassword) {
		this.conform_Password = conformPassword;
	}
	public int getMobileNumber() {
		return Mobile_Number;
	}
	public void setMobileNumber(int mobileNumber) {
		Mobile_Number = mobileNumber;
	}

}
