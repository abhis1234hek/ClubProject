package com.pro.club.entities.secA;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
public class Players 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int CPid;
	private String CPName;
	private int CPAge;
	private String CPContact;
	private String CPEmail;
	private String CPImage;
	private String CPDomain;
	private String CPAddress;
	
	@JsonBackReference
	@ManyToOne
	private User user;

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
				+ CPAddress  + "]";
	}

	public Players(int cPid, String cPName, int cPAge, String cPContact, String cPEmail, String cPImage,
			String cPDomain, String cPAddress, User user) {
		super();
		CPid = cPid;
		CPName = cPName;
		CPAge = cPAge;
		CPContact = cPContact;
		CPEmail = cPEmail;
		CPImage = cPImage;
		CPDomain = cPDomain;
		CPAddress = cPAddress;
		this.user = user;
	}

	public Players() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
