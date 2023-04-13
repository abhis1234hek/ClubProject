package com.pro.club.entities.secB;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
public class Tmatch 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Mid;
	private String Mmteama;
	private String Mmteamb;
	private String Mmdate;
	private String Mmplace;
	
	@JsonBackReference
	@ManyToOne
	private Tournament tournament;
	
	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "tmatch")
	private List<Tplayers> tplayers = new ArrayList<>();

	@Override
	public String toString() {
		return "Tmatch [Mid=" + Mid + ", Mmteama=" + Mmteama + ", Mmteamb=" + Mmteamb + ", Mmdate=" + Mmdate
				+ ", Mmplace=" + Mmplace + ", tournament=" + tournament + ", tplayers=" + tplayers + "]";
	}
	
	
	
}
