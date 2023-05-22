package com.pro.club.service;

import java.util.List;

import com.pro.club.entities.secA.User;

public interface UserService 
{
	// Create
	User addUser(User user);
	
	// Read
	User readUserById(int id);
	List<User> readAllUsers();
}
