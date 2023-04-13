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
	// -----------------| Repository objects |-----------------
	@Autowired
	private UserRepository userRepository;
	
	// -----------------| Handler of render Sports component |-----------------
	@GetMapping("/showSport")
	public String showsports()
	{
		return "/working/showsport";
	}
	
	// -----------------| Handler of render Clubs component |-----------------
	@GetMapping("/showClub")
	public String showclubs(Model m)
	{
		List<User> clubs = this.userRepository.findAll();
		m.addAttribute("clubs",clubs);
		return "/working/showClub";
	}
	
	// -----------------| Handler of render Tournament component |-----------------
	@GetMapping("/showTour")
	public String showtournaments()
	{
		return "/working/showTour";
	}
	
	// -----------------| Handler of render ShowKit component |-----------------
	@GetMapping("/showKit")
	public String showkit()
	{
		return "/working/showKit";
	}
	
	// -----------------| Handler of render MemberShip component |-----------------
	@GetMapping("/showMember")
	public String showmembership()
	{
		return "/working/showMember";
	}
	
	// -----------------| Handler of render Registration component |-----------------
	@GetMapping("/showRegister")
	public String showregister()
	{
		return "/working/showRegister";
	}
}

