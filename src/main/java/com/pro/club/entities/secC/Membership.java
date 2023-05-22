package com.pro.club.entities.secC;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Membership {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int MSid;
	@Column (name="First Name")
	private String MSfname;
	@Column (name="Last Name")
	private String MSlname;
	@Column (name="Date of Birth")
	private String MSbdate;
	@Column (name="Gender")
	private String MSgender;
	@Column (name="Email")
	private String MSemail;
	@Column (name="Phone")
	private String MSphone;
	@Column (name="Address")
	private String MSaddress;
	@Column (name="City")
	private String MScity;
	@Column (name="State")
	private String MSstate;
	@Column (name="Pincode")
	private String MSpincode;
	@Column (name="type")
	private String MStype;
	@Column (name="Club Name")
	private String MScname;
	@Column (name="Date")
	private String MSdate;
	@Column (name="Amount")
	private String MSamount;
	@Column (name="Transation")
	private String MStransation;
}
