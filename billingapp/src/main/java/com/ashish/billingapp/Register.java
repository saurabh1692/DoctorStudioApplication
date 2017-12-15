package com.ashish.billingapp;

import java.sql.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Register {
	/*@Override
	public String toString() {
		return "Register [username=" + username + ", pswd=" + pswd + ", shopname=" + shopname + ", address=" + address
				+ ", mobilenumber=" + mobilenumber + ", emailid=" + emailid + ", gstnumber=" + gstnumber
				+ ", accountlock=" + accountlock + ", substartdate=" + substartdate + ", subenddate=" + subenddate
				+ "]";
	}*/
	private int subid;
	public int getSubid() {
		return subid;
	}
	public void setSubid(int subid) {
		this.subid = subid;
	}
	private String username;
	private String password;
	private String shopname;
	private String address;
	private  String mobilenumber;
	private String emailid;
	private String gstnumber;
	private String accountlock;
	private String substartdate;
	private String subenddate;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getShopname() {
		return shopname;
	}
	public void setShopname(String shopname) {
		this.shopname = shopname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public String getGstnumber() {
		return gstnumber;
	}
	public void setGstnumber(String gstnumber) {
		this.gstnumber = gstnumber;
	}
	public String getAccountlock() {
		return accountlock;
	}
	public void setAccountlock(String accountlock) {
		this.accountlock = accountlock;
	}
	public String getSubstartdate() {
		return substartdate;
	}
	public void setSubstartdate(String substartdate) {
		this.substartdate = substartdate;
	}
	public String getSubenddate() {
		return subenddate;
	}
	public void setSubenddate(String subenddate) {
		this.subenddate = subenddate;
	}
	/*public Register(String username,String pswd,String shopname,String address,int mobilenumber,String emailid,boolean accountlock,
			         String gstnumber,String substartdate,String subenddate) {

		this.username=username;
		this.pswd=pswd;
		this.shopname=shopname;
		this.address=address;
		this.mobilenumber=mobilenumber;
		this.emailid=emailid;
		this.gstnumber=gstnumber;
		this.accountlock=accountlock;
		this.substartdate=substartdate;
		this.subenddate=subenddate;

	}
	*/
	}
	
	
	


