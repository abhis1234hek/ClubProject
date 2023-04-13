package com.pro.club.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pro.club.entities.secA.User;
import com.pro.club.entities.secB.Tournament;

public interface TournamentRepository extends JpaRepository<Tournament, Integer> 
{
	@Query("select t from Tournament t where t.TClub =:Name")
	public List<Tournament> getTourByClubName(@Param("Name") String Name);
}
