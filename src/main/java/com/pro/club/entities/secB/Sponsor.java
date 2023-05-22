package com.pro.club.entities.secB;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
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
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Sponsor 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="Sponsor Id")
	private int SPid;
	@Column (name="Sponsor Name")
	private String SPName;
	private String SPAmount;
	private String SPLocation;
	
	@JsonBackReference
	@ManyToOne
	private Tournament tournament;
}
