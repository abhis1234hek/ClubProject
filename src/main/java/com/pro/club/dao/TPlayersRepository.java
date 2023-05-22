package com.pro.club.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pro.club.entities.secB.Tplayers;

public interface TPlayersRepository extends JpaRepository<Tplayers, Integer> 
{
	@Query("select p from Tplayers p where p.tmatch.Mid =:Mid")
	public List<Tplayers> getPlayersByMatch(@Param("Mid") int Mid);
}
