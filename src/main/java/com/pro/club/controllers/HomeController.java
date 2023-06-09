package com.pro.club.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.pro.club.dao.AddressRepository;
import com.pro.club.dao.UserRepository;
import com.pro.club.entities.secA.Address;
import com.pro.club.entities.secA.User;
import com.pro.club.service.UserService;


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
	
	@Autowired
	private UserService userService;
	
	
	// -----------------| Show welcome page handler |-----------------
	@RequestMapping("/")
	public String welcome()
	{
		return "welcome";
	}
	
	// -----------------| Show Home page handler |-----------------
	@RequestMapping("/home")
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
							  @RequestParam("file") MultipartFile file,
							  @RequestParam("CStreet")String CStreet,
							  @RequestParam("CArea")String CArea,
							  @RequestParam("CCity")String CCity,
							  @RequestParam("CState")String CState,
							  @RequestParam("CPincode")String CPincode
							  ) throws IOException
	{
		Address address = new Address(CStreet,CArea,CCity,CState,CPincode,user);
		
		String UPLOAD_DIR = "E:\\ClubAPI\\ClubAPI-master\\src\\main\\resources\\static\\images\\users";
		Files.copy(file.getInputStream(), Paths.get(UPLOAD_DIR+File.separator+file.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
		user.setImage(file.getOriginalFilename());
		
		System.out.println(file.getOriginalFilename());
		user.setRole("ROLE_USER");
		user.setAddress(address);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		this.userService.addUser(user);
//		this.userRepository.save(user);
		return "redirect:/home";
	}
}
