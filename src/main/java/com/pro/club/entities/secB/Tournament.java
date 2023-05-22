package com.pro.club.entities.secB;

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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Tournament 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="Tour Id")
	private int Tid;
	@Column (name="Club Name")
	private String TClub;
	@Column (name="Tour Name")
	private String TName;
	@Column (name="Domain")
	private String TDomain;
	private String TSDate;
	private String TEDate;
	private String TPlace;
	
	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "tournament")
	private List<Sponsor> sponsors = new ArrayList<>();
	
	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "tournament")
	private List<Tmatch> tmatches = new ArrayList<>();
	
}
