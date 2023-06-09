package com.pro.club.entities.secA;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity

public class Address 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="Address Id")
	private int CAid;
	@Column (name="Street")
	private String CStreet;
	@Column (name="Area")
	private String CArea;
	@Column (name="City")
	private String CCity;
	@Column (name="State")
	private String CState;
	@Column (name="Pincode")
	private String CPincode;
	
	@JsonBackReference
	@OneToOne
	private User user;

	public int getCAid() {
		return CAid;
	}

	public void setCAid(int cAid) {
		CAid = cAid;
	}

	public String getCStreet() {
		return CStreet;
	}

	public void setCStreet(String cStreet) {
		CStreet = cStreet;
	}

	public String getCArea() {
		return CArea;
	}

	public void setCArea(String cArea) {
		CArea = cArea;
	}

	public String getCCity() {
		return CCity;
	}

	public void setCCity(String cCity) {
		CCity = cCity;
	}

	public String getCState() {
		return CState;
	}

	public void setCState(String cState) {
		CState = cState;
	}

	public String getCPincode() {
		return CPincode;
	}

	public void setCPincode(String cPincode) {
		CPincode = cPincode;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Address(String cStreet, String cArea, String cCity, String cState, String cPincode, User user) {
		super();
		CStreet = cStreet;
		CArea = cArea;
		CCity = cCity;
		CState = cState;
		CPincode = cPincode;
		this.user = user;
	}

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Id -> " + CAid + "\nCAid" + CAid + "\nStreet -> " + CStreet + "\nArea " + CArea + "\nCity -> " + CCity + "\nState -> " + CState + "\nPincode " + CPincode;
	}
	
	
	
}
