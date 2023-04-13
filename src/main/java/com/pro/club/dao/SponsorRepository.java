package com.pro.club.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pro.club.entities.secB.Sponsor;
import com.pro.club.entities.secB.Tmatch;

public interface SponsorRepository extends JpaRepository<Sponsor, Integer> 
{

	@Query("select s from Sponsor s where s.tournament.Tid =:Tid")
	public List<Sponsor> getMatchByTour(@Param("Tid") int Tid);
}