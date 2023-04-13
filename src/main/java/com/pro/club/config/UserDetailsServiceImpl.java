package com.pro.club.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.pro.club.dao.UserRepository;
import com.pro.club.entities.secA.User;

public class UserDetailsServiceImpl implements UserDetailsService 
{
	@Autowired
	private UserRepository userRepositoy;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = this.userRepositoy.getUserByUserName(username);
		if(user == null)
		{
			throw new UsernameNotFoundException("Could not found user !!");
		}
		CustomUserDetails customUserDetails = new CustomUserDetails(user);
		return customUserDetails;
	}

}
