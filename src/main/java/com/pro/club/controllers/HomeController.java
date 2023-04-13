package com.pro.club.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pro.club.dao.AddressRepository;
import com.pro.club.dao.UserRepository;
import com.pro.club.entities.secA.Address;
import com.pro.club.entities.secA.User;


@Controller
public class HomeController 
{
	// -----------------| Repository objects |-----------------
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	// -----------------| Show Home page handler |-----------------
	@RequestMapping("/")
	public String home()
	{
		return "home";
	}
	
	// -----------------| URL showing all the clubs available |-----------------
	@GetMapping("/read")
	@ResponseBody
	public List<User> getclubs()
	{
		return this.userRepository.findAll();
	}
	
	// -----------------| Show About page handler |-----------------
	@RequestMapping("/about")
	public String about()
	{
		return "about";
	}
	
	// -----------------| Show Contact page handler |-----------------
	@RequestMapping("/contact")
	public String contact()
	{
		return "contact";
	}
	
	// -----------------| Show Gallery page handler |-----------------
	@RequestMapping("/gallery")
	public String gallery()
	{
		return "gallery";
	}
	
	// -----------------| Show login page |-----------------
	@GetMapping("/signin")
	public String loginHandler()
	{
		return "login";
	}
	
	// -----------------| Sign-in handler |-----------------
	@PostMapping("/sign_user")
	public String signinuser(@ModelAttribute("user") User user,
							  @RequestParam("CStreet")String CStreet,
							  @RequestParam("CArea")String CArea,
							  @RequestParam("CCity")String CCity,
							  @RequestParam("CState")String CState,
							  @RequestParam("CPincode")String CPincode
							  )
	{
		Address address = new Address(CStreet,CArea,CCity,CState,CPincode,user);
		user.setRole("ROLE_USER");
		user.setAddress(address);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		this.userRepository.save(user);
		return "redirect:/";
	}
}
