package com.pro.club.entities.secB;

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
public class Tplayers 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Mpid;
	private String Mpname;
	private String Mpteam;
	
	@JsonBackReference
	@ManyToOne
	private Tmatch tmatch;
}
