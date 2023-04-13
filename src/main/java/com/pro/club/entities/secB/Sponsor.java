package com.pro.club.entities.secB;

import java.util.List;

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
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Sponsor 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int SPid;
	private String SPName;
	private String SPLocation;
	
	@JsonBackReference
	@ManyToOne
	private Tournament tournament;
}
