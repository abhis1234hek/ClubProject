package com.pro.club.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.pro.club.dao.PlayersRepository;
import com.pro.club.dao.SponsorRepository;
import com.pro.club.dao.TPlayersRepository;
import com.pro.club.dao.TmatchRepository;
import com.pro.club.dao.TournamentRepository;
import com.pro.club.dao.UserRepository;
import com.pro.club.entities.secA.Players;
import com.pro.club.entities.secA.User;
import com.pro.club.entities.secB.Sponsor;
import com.pro.club.entities.secB.Tmatch;
import com.pro.club.entities.secB.Tournament;
import com.pro.club.entities.secB.Tplayers;

@Controller
@RequestMapping("/user")
public class UserController 
{
	// -----------------| Repository objects for doing CRUD with the database |-----------------
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TournamentRepository tournamentRepository;
	
	@Autowired
	private SponsorRepository sponsorRepository;
	
	@Autowired
	private TmatchRepository tmatchRepository;
	
	@Autowired
	private PlayersRepository playersRepository;
	
	@Autowired
	private TPlayersRepository tPlayersRepository;
	
	// -----------------| Handler after successful login |-----------------
	@GetMapping("/index")
	public String index(Model model,Principal principal)
	{
		String email = principal.getName();
		User user = this.userRepository.getUserByUserName(email);
		model.addAttribute("name",user.getCName());
		model.addAttribute("contact",user.getCContact());
		model.addAttribute("image",user.getImage());
		model.addAttribute("email",user.getEmail());
		model.addAttribute("address",user.getAddress());
		return "success";
	}
	
	//                                     | SECTION A |
	/*--------------------------------------------------------------------------------------------------------------------*/
	// -----------------| Main Players CRUD |-----------------
	@GetMapping("/viewPlayers")
	public String viewPlayers(Model model,Principal principal)
	{
		String email = principal.getName();
		User user = this.userRepository.getUserByUserName(email);
		List<Players> players = user.getPlayers();
		model.addAttribute("players",players);
		return "/working/showplayers";
	}
	
	@PostMapping("/savePlayer")
	public String addPlayers(@ModelAttribute("player") Players player,@RequestParam("pimage") MultipartFile pimage,Principal principal) throws IOException
	{
		String UPLOAD_DIR = "E:\\ClubAPI\\ClubAPI-master\\src\\main\\resources\\static\\images\\mainplay";
		Files.copy(pimage.getInputStream(), Paths.get(UPLOAD_DIR+File.separator+pimage.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
		player.setCPImage(pimage.getOriginalFilename());
		
		System.out.println(player);
		String email = principal.getName();
		User user = this.userRepository.getUserByUserName(email);
		player.setUser(user);
		user.getPlayers().add(player);
		this.userRepository.save(user);
		return "redirect:/user/index";
	}
	
	@GetMapping("/showupdatePlayer/{CPid}")
	public String showupdatePlayer(@PathVariable("CPid") int CPid,Model model)
	{
		Players p = this.playersRepository.findById(CPid).orElseThrow();
		model.addAttribute("p",p);
		return "/working/updateMainPlayer";
	}
	
	@PostMapping("/updateMainPlayer/{CPid}")
	public String updateMainPlayer(@ModelAttribute("player") Players player,@PathVariable("CPid") int CPid)
	{
		Players play = this.playersRepository.findById(CPid).orElseThrow();
		User user = this.userRepository.findById(play.getUser().getCId()).orElseThrow();
		player.setUser(user);
		this.playersRepository.save(player);
		return "redirect:/user/viewPlayers";
	}
	
	@GetMapping("/deletemainPlayer/{CPid}")
	public String deleteMainPlayer(@PathVariable("CPid") int CPid)
	{
		System.out.println(CPid);
		Players player = this.playersRepository.findById(CPid).orElseThrow();
		player.setUser(null);
		this.playersRepository.deleteById(CPid);
		return "redirect:/user/viewPlayers";
	}
    /*--------------------------------------------------------------------------------------------------------------------*/
	
	/*||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||*/
	
	/*--------------------------------------------------------------------------------------------------------------------*/
	

	//                                        | SECTION B |
	/*--------------------------------------------------------------------------------------------------------------------*/
	// -----------------| Tournament CRUD |-----------------
	@PostMapping("/saveTour")
	public String addTour(@ModelAttribute("tournament") Tournament tournament,@RequestParam("TDomain") String TDomain,Principal principal)
	{
		String email = principal.getName();
		User user = this.userRepository.getUserByUserName(email);
		tournament.setTClub(user.getCName());
		System.out.println(tournament);
		this.tournamentRepository.save(tournament);
		return "redirect:/user/index";
		
	}
	
	@GetMapping("/viewclubtour")
	public String viewTour(Model model,Principal principal)
	{
		String email = principal.getName();
		User user = this.userRepository.getUserByUserName(email);
		String cname = user.getCName();
		List<Tournament> tournaments = this.tournamentRepository.getTourByClubName(cname);
		model.addAttribute("tournaments",tournaments);
		return "/working/viewClubTour";
	}
	
	@PostMapping("/updateTour/{Tid}")
	public String updateTour(@ModelAttribute("tournament") Tournament tournament,@PathVariable("Tid") int Tid)
	{
		Tournament tour = this.tournamentRepository.findById(Tid).orElseThrow();
		tournament.setTmatches(tour.getTmatches());
		this.tournamentRepository.save(tournament);
		return "redirect:/user/viewclubtour";
	}
	
	@GetMapping("/showupdatetour/{Tid}")
	public String showupdateTour(@PathVariable("Tid") int Tid,Model model)
	{
		Tournament tour = this.tournamentRepository.findById(Tid).orElseThrow();
		model.addAttribute("tour",tour);
		return "working/updateTour";
	}	
	
	@GetMapping("/deleteTour/{Tid}")
	public String deleteTour(@PathVariable("Tid") int Tid)
	{
		System.out.println(Tid);
		this.tournamentRepository.deleteById(Tid);
		return "redirect:/user/viewclubtour";
	}
	/*--------------------------------------------------------------------------------------------------------------------*/
	
	/*||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||*/
	
	/*--------------------------------------------------------------------------------------------------------------------*/
	// -----------------| Matches CRUD |-----------------
	@PostMapping("/addMatch")
	public String addMatch(@ModelAttribute("tmatch") Tmatch tmatch,@RequestParam("Tourid") int Tourid)
	{
		Tournament tournament = this.tournamentRepository.findById(Tourid).orElseThrow();
		tmatch.setTournament(tournament);
		tournament.getTmatches().add(tmatch);
		this.tournamentRepository.save(tournament);
		int id = tournament.getTid();
		return "redirect:/user/viewTourMatches/"+id;
	}
	
	@GetMapping("/viewTourMatches/{Tid}")
	public String viewTourMatches(Model model,@PathVariable("Tid") Integer Tid)
	{
		List<Tmatch> mats = this.tmatchRepository.getMatchByTour(Tid);
		model.addAttribute("matches", mats);
		model.addAttribute("tid", Tid);
		return "/working/viewMatches";
	}
	
	@GetMapping("/showupdatematch/{Mid}")
	public String showupdatematch(@PathVariable("Mid") int Mid,Model model)
	{
		Tmatch tmatch = this.tmatchRepository.findById(Mid).orElseThrow();
		model.addAttribute("m",tmatch);
		model.addAttribute("Mid",tmatch.getTournament().getTid());
		return "working/updateMatch";
	}
	
	@PostMapping("/updateMatch/{Mid}")
	public String updateMatch(@ModelAttribute("tmatch") Tmatch tmatch,@PathVariable("Mid") int Mid)
	{
		Tmatch tm = this.tmatchRepository.findById(Mid).orElseThrow();
		System.out.println(tmatch);
		tmatch.setTournament(tm.getTournament());
		tmatch.setTplayers(tm.getTplayers());
		this.tmatchRepository.save(tmatch);
		int id = tmatch.getTournament().getTid();
		return "redirect:/user/viewTourMatches/"+id;
	}
	
	@RequestMapping("/deleteMatch/{Mid}")
	public String deleteMatch(@ModelAttribute("tmatch") Tmatch tmatch,@PathVariable("Mid") int Mid)
	{
		Tmatch tm = this.tmatchRepository.findById(Mid).get();
		int id = tm.getTournament().getTid();
		tm.setTournament(null);
		this.tmatchRepository.delete(tm);
		return "redirect:/user/viewTourMatches/"+id;
	}
	/*--------------------------------------------------------------------------------------------------------------------*/
	
	/*||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||*/
	
	/*--------------------------------------------------------------------------------------------------------------------*/
	// -----------------| Tournament Players CRUD |-----------------
	@PostMapping("/addPlayer/{Mmid}")
	public String addPlayer(@ModelAttribute("tplayers") Tplayers tplayers,@PathVariable("Mmid") int Mmid)
	{
		Tmatch tmatch = this.tmatchRepository.findById(Mmid).orElseThrow();
		tplayers.setTmatch(tmatch);
		tmatch.getTplayers().add(tplayers);
		Tournament tournament = this.tournamentRepository.findById(tmatch.getTournament().getTid()).orElseThrow();
		this.tournamentRepository.save(tournament);
		int id = tournament.getTid();
		return "redirect:/user/viewTourMatches/"+id;
	}
	
	@GetMapping("/viewTPlayers/{Mid}")
	public String viewPlayers(@PathVariable("Mid") int Mid,Model m)
	{
		List<Tplayers> players = this.tPlayersRepository.getPlayersByMatch(Mid);
		m.addAttribute("players",players);
		Tmatch tmatch = this.tmatchRepository.findById(Mid).orElseThrow();
		int Tid = tmatch.getTournament().getTid();
		m.addAttribute("Mid",Tid);
		return "/working/viewPlayers";
	}
	
	@PostMapping("/updateplayer")
	public String updatePlayer(@ModelAttribute("tplayer") Tplayers tplayer)
	{
		Tplayers tplay = this.tPlayersRepository.findById(tplayer.getMpid()).orElseThrow();
		Tmatch tmatch = this.tmatchRepository.findById(tplay.getTmatch().getMid()).orElseThrow();
		tplayer.setTmatch(tmatch);
		this.tPlayersRepository.save(tplayer);
		int id = tplayer.getTmatch().getMid();
		return "redirect:/user/viewTPlayers/"+id;
	}
	
	@GetMapping("/updatetplayer/{Mpid}")
	public String updatePlayerPage(Model m,@PathVariable("Mpid") int Mpid)
	{
		Tplayers tplayer = this.tPlayersRepository.findById(Mpid).orElseThrow();
		m.addAttribute("tplayer",tplayer);
		return "working/updatePlayer";
	}
	
	@RequestMapping("/deleteplayer/{Mpid}")
	public String deletePlayer(@PathVariable("Mpid") int Mpid)
	{
		Tplayers tplay = this.tPlayersRepository.findById(Mpid).get();
		int id = tplay.getTmatch().getMid();
		tplay.setTmatch(null);
		this.tPlayersRepository.delete(tplay);
		return "redirect:/user/viewTPlayers/"+id;
	}
	/*--------------------------------------------------------------------------------------------------------------------*/
	
	/*||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||*/
	
	/*--------------------------------------------------------------------------------------------------------------------*/
	// -----------------| Sponsorship CRUD |-----------------
	@PostMapping("/addSponsor")
	public String addSponsor(@ModelAttribute("sponsor") Sponsor sponsor,@RequestParam("Tourid") int Tid)
	{
		Tournament tournament = this.tournamentRepository.findById(Tid).orElseThrow();
		sponsor.setTournament(tournament);
		tournament.getSponsors().add(sponsor);
		this.tournamentRepository.save(tournament);
		int id = sponsor.getTournament().getTid();
		return "redirect:/user/viewTourSponsor/"+id;
	}
	
	@GetMapping("/viewTourSponsor/{Tid}")
	public String showaddSponsor(@PathVariable("Tid") int Tid,Model model)
	{
		List<Sponsor> sponsors = this.sponsorRepository.getMatchByTour(Tid);
		model.addAttribute("Sponsors", sponsors);
		model.addAttribute("tid", Tid);
		return "working/viewSponsors";
	}
	
	@GetMapping("/showupdatesponsor/{SPid}")
	public String updateSponsor(@PathVariable("SPid") int SPid,Model model)
	{
		Sponsor sponsor = this.sponsorRepository.findById(SPid).orElseThrow();
		model.addAttribute("s",sponsor);
		model.addAttribute("Mid",sponsor.getTournament().getTid());
		return "working/updateSponsor";
	}
	
	@PostMapping("/updateSponsor/{SPid}")
	public String updateSponsorhandler(@ModelAttribute("sponsor") Sponsor sponsor,@PathVariable("SPid") int SPid)
	{
		System.out.println(sponsor.getSPid());
		Sponsor sp = this.sponsorRepository.findById(SPid).orElseThrow();
		sponsor.setTournament(sp.getTournament());
		this.sponsorRepository.save(sponsor);
		int id = sponsor.getTournament().getTid();
		return "redirect:/user/viewTourSponsor/"+id;
	}
	
	@GetMapping("/deleteSponsor/{SPid}")
	public String deleteSponsor(@PathVariable("SPid") int SPid)
	{
		Sponsor sponsor = this.sponsorRepository.findById(SPid).orElseThrow();
		int id = sponsor.getTournament().getTid();
		sponsor.setTournament(null);
		this.sponsorRepository.deleteById(SPid);
		return "redirect:/user/viewTourSponsor/"+id;
	}
	/*--------------------------------------------------------------------------------------------------------------------*/
	
	/*||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||*/
	
	/*--------------------------------------------------------------------------------------------------------------------*/
	
}
