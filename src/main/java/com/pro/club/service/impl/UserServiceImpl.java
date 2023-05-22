package com.pro.club.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pro.club.dao.UserRepository;
import com.pro.club.entities.secA.User;
import com.pro.club.service.UserService;

@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserRepository userRepository;

	@Override
	public User addUser(User user) {
		return this.userRepository.save(user);
	}

	@Override
	public User readUserById(int id) {
		// TODO Auto-generated method stub
		return this.userRepository.findById(id).orElseThrow();
	}

	@Override
	public List<User> readAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
