package com.pro.club.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pro.club.entities.secA.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> 
{

}
