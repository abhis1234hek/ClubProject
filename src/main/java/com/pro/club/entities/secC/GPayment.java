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
public class GPayment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int GPid;
	@Column (name="Full Name")
	private String GPname;
	@Column (name="email")
	private String GPemail;
	@Column (name="Contact")
	private String GPcontact;
	@Column (name="Date")
	private String GPDate;
	@Column (name="PAYmethode")
	private String GPMethod;
	@Column (name="Game Mode")
	private String GPmode;
	@Column (name="Kit Name")
	private String GPkit;
	@Column (name="transation Id")
	private String GPtransation;
	@Column (name="Amount")
	private String GPAmount;
}
