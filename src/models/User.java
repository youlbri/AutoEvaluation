package models;

import util.PhoneNumbre;

public class User { 
	private String name;
	private String familyName;
	private PhoneNumbre phoneNum;
	private Compte account;
	
	
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFamilyName() {
		return familyName;
	}
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	public PhoneNumbre getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(PhoneNumbre phoneNum) {
		this.phoneNum = phoneNum;
	}
	public Compte getAccount() {
		return account;
	}
	public void setAccount(Compte account) {
		this.account = account;
	}
	

}
