package com.pro.club.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.pro.club.dao.GPaymentRepository;
import com.pro.club.dao.MembershipRepository;
import com.pro.club.dao.TournamentRepository;
import com.pro.club.dao.UserRepository;
import com.pro.club.entities.secA.User;
import com.pro.club.entities.secB.Tournament;
import com.pro.club.entities.secC.EmailDetails;
import com.pro.club.entities.secC.GPayment;
import com.pro.club.entities.secC.Membership;
import com.pro.club.service.EmailService;

@Controller
public class WorkingController {
	// -----------------| Repository objects |-----------------
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private TournamentRepository tournamentRepository;

	@Autowired
	private MembershipRepository membershipRepository;

	@Autowired
	private GPaymentRepository gpaymentRepository;
	
	@Autowired
	private EmailService emailService; 

	// -----------------| Handler of render Sports component |-----------------
	@GetMapping("/showSport")
	public String showsports() {
		return "/working/showsport";
	}

	// -----------------| Handler of render Sports component |-----------------
	@GetMapping("/indoor")
	public String Indoors() {
		return "/working/Indoor";
	}

	// -----------------| Handler of render Clubs component |-----------------
	@GetMapping("/showClub")
	public String showclubs(Model m) {
		List<User> clubs = this.userRepository.findAll();
		m.addAttribute("clubs", clubs);
		return "/working/showClub";
	}

	// -----------------| Handler of render Tournament component |-----------------
	@GetMapping("/showTour")
	public String showtournaments(Model model) {
		List<Tournament> tournaments = this.tournamentRepository.findAll();
		model.addAttribute("tournaments", tournaments);
		List<String> names = new ArrayList<>();
		model.addAttribute("names", names);
		return "/working/showTour";
	}

	// -----------------| Handler of render ShowKit component |-----------------
	@GetMapping("/showKit")
	public String showkit() {
		return "/working/showKit";
	}

	// -----------------| Handler of render ShowKit component |-----------------
	@GetMapping("/payment")
	public String payment() {
		return "/working/payment";
	}

	// -----------------| Handler of payment component |-----------------
	@PostMapping("/payment")
	public String payment(@ModelAttribute("gpayment") GPayment gpayment) {
		Random random = new Random();
		Integer rvalue = (int)random.nextInt(1000,2000);
		UUID randomUUID = UUID.randomUUID();
		String rid = randomUUID.toString();
		gpayment.setGPtransation(rid);
		EmailDetails email = EmailDetails.builder().msgBody(rvalue.toString()).recipient(gpayment.getGPemail()).subject("OTP from the Sports Club").attachment(null).build();
		this.emailService.sendSimpleMail(email);
		this.gpaymentRepository.save(gpayment);
		return "/working/payment";
	}

	// -----------------| Handler of render MemberShip component |-----------------
	@GetMapping("/showMember")
	public String showmembership() {
		return "/working/showMember";
	}

	// -----------------| Handler of render Registration component
	// |-----------------
	@GetMapping("/showRegister")
	public String showregister() {
		return "/working/showRegister";
	}

	// -----------------| Handler of render Registration component
	// |-----------------
	@PostMapping("/showRegister")
	public String showRegister(@ModelAttribute("membership") Membership membership) {
		UUID randomUUID = UUID.randomUUID();
		String rid = randomUUID.toString();
		membership.setMStransation(rid);
		this.membershipRepository.save(membership);
		return "/working/showRegister";
	}

}
