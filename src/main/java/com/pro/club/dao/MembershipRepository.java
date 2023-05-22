package com.pro.club.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pro.club.entities.secC.Membership;

public interface MembershipRepository extends JpaRepository<Membership, Integer>
{

}
