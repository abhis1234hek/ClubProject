package com.pro.club.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pro.club.entities.secB.Tmatch;

public interface TmatchRepository extends JpaRepository<Tmatch, Integer> 
{
	@Query("select t from Tmatch t where t.tournament.Tid =:Tid")
	public List<Tmatch> getMatchByTour(@Param("Tid") int Tid);
	
}
