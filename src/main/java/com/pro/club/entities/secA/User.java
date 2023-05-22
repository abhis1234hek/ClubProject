package com.pro.club.entities.secA;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="Club Id")
	private int CId;
    @Column (name="Name")
	private String CName;
    @Column (name="Contact")
	private String CContact;
	private String Image;
	private String Password;
	private String Email;
	private String Role;
	
	@JsonManagedReference
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "user")
	private Address address;
	
	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "user")
	private List<Players> players = new ArrayList<>();
	
	
	

	@Override
	public String toString() {
		return "User [CId=" + CId + ", CName=" + CName + ", CContact=" + CContact + ", Image=" + Image + ", Password="
				+ Password + ", Email=" + Email + ", Role=" + Role + ", address=" + address + ", players=" + players
				+ "]";
	}

	public User(int cId, String cName, String cContact, String image, String password, String email, String role,
			Address address, List<Players> players) {
		super();
		CId = cId;
		CName = cName;
		CContact = cContact;
		Image = image;
		Password = password;
		Email = email;
		Role = role;
		this.address = address;
		this.players = players;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
