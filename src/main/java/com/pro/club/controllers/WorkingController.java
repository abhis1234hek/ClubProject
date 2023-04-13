package com.pro.club.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.pro.club.dao.UserRepository;
import com.pro.club.entities.secA.User;

@Controller
public class WorkingController 
{
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/showSport")
	public String showsports()
	{
		return "/working/showsport";
	}
	
	@GetMapping("/showClub")
	public String showclubs(Model m)
	{
		List<User> clubs = this.userRepository.findAll();
		m.addAttribute("clubs",clubs);
		return "/working/showClub";
	}
	
	@GetMapping("/showTour")
	public String showtournaments()
	{
		return "/working/showTour";
	}
	
	@GetMapping("/showKit")
	public String showkit()
	{
		return "/working/showKit";
	}
	
	@GetMapping("/showMember")
	public String showmembership()
	{
		return "/working/showMember";
	}
	
	@GetMapping("/showRegister")
	public String showregister()
	{
		return "/working/showRegister";
	}
}

