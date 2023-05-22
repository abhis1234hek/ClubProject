package com.pro.club.entities.secA;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Players 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="Player Id")
	private int CPid;
	@Column (name="Player Name")
	private String CPName;
	@Column (name="Player Age")
	private int CPAge;
	@Column (name="Contact")
	private String CPContact;
	@Column (name="Email")
	private String CPEmail;
	@Column (name="Player Image")
	private String CPImage;
	@Column (name="Player Domain")
	private String CPDomain;
	@Column (name="Player Address")
	private String CPAddress;
	@Column (name="Gender")
	private String CPGender;
	
	@JsonBackReference
	@ManyToOne
	private User user;

	public String getCPGender() {
		return CPGender;
	}

	public void setCPGender(String cPGender) {
		CPGender = cPGender;
	}

	public int getCPid() {
		return CPid;
	}

	public void setCPid(int cPid) {
		CPid = cPid;
	}

	public String getCPName() {
		return CPName;
	}

	public void setCPName(String cPName) {
		CPName = cPName;
	}

	public int getCPAge() {
		return CPAge;
	}

	public void setCPAge(int cPAge) {
		CPAge = cPAge;
	}

	public String getCPContact() {
		return CPContact;
	}

	public void setCPContact(String cPContact) {
		CPContact = cPContact;
	}

	public String getCPEmail() {
		return CPEmail;
	}

	public void setCPEmail(String cPEmail) {
		CPEmail = cPEmail;
	}

	public String getCPImage() {
		return CPImage;
	}

	public void setCPImage(String cPImage) {
		CPImage = cPImage;
	}

	public String getCPDomain() {
		return CPDomain;
	}

	public void setCPDomain(String cPDomain) {
		CPDomain = cPDomain;
	}

	public String getCPAddress() {
		return CPAddress;
	}

	public void setCPAddress(String cPAddress) {
		CPAddress = cPAddress;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Players [CPid=" + CPid + ", CPName=" + CPName + ", CPAge=" + CPAge + ", CPContact=" + CPContact
				+ ", CPEmail=" + CPEmail + ", CPImage=" + CPImage + ", CPDomain=" + CPDomain + ", CPAddress="
				+ CPAddress + ", CPGender=" + CPGender + ", user=" + user + "]";
	}

	public Players(int cPid, String cPName, int cPAge, String cPContact, String cPEmail, String cPImage,
			String cPDomain, String cPAddress, User user, String cPGender) {
		super();
		CPid = cPid;
		CPName = cPName;
		CPAge = cPAge;
		CPContact = cPContact;
		CPEmail = cPEmail;
		CPImage = cPImage;
		CPDomain = cPDomain;
		CPAddress = cPAddress;
		CPGender = cPGender;
		this.user = user;
	}

	public Players() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
