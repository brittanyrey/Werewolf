package edu.wm.werewolf;

import java.security.Principal;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import edu.wm.werewolf.domain.GPSLocation;
import edu.wm.werewolf.domain.Game;
import edu.wm.werewolf.domain.Kill;
import edu.wm.werewolf.domain.NumDaysAndNightCycles;
import edu.wm.werewolf.domain.Player;
import edu.wm.werewolf.domain.User;
import edu.wm.werewolf.service.GameService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired 
	private GameService gameService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) 
	{
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate);
		
		return "home";
	}
	
	@RequestMapping(value = "/addUser", method=RequestMethod.POST)
	public void newUser(String id, String firstName, String lastName, String username, 
			String hashedPassword, String imageURL, boolean isAdmin)
	{
		logger.info("Adding new user : " +  username);
		gameService.addUser(id, firstName, lastName, username, hashedPassword, imageURL, isAdmin);
	}
	
	@RequestMapping(value = "admin/newGame", method=RequestMethod.POST)
	public void newGame(String id, int dayNightFreq)
	{
		if (gameService.isAdmin(id)) 
		{
			gameService.newGame(dayNightFreq);
			logger.info("New game started by: " + id +"with DNF "+ dayNightFreq);
		}
		else  
		{
			logger.info("New game could not be created. User is not Admin");
		}
	}
	
	@RequestMapping(value = "admin/endGame", method=RequestMethod.POST)
	public void endGame(String id)
	{
		if (gameService.isAdmin(id)) 
		{
			gameService.endGame();
			logger.info("New game started by: " + id );
		}
		else 
		{
			logger.info("User is not Admin. Game is still in session");
		}
	}
	
	@RequestMapping(value = "/login", method=RequestMethod.POST)
	public @ResponseBody List<String> login(String user)
	{
		logger.info("login attempt return pass for "+user);
		String pwrd = gameService.getPassword(user);
		logger.info("pwrd ="+ pwrd);
		List <String> info = new ArrayList<String>();
		info.add(pwrd);
		info.add(String.valueOf(gameService.isAdmin(user)));
		return info;
	}
	
	@RequestMapping(value = "/players/alive", method=RequestMethod.GET)
	public @ResponseBody List<Player> getAllAlive()
	{
		logger.info("Get all alive");
		List<Player> players = gameService.getAllAlive();
		return players;
	}
	
	@RequestMapping(value = "/getStatus", method=RequestMethod.GET)
	public @ResponseBody NumDaysAndNightCycles isNight()
	{
		logger.info("isNight?");
		NumDaysAndNightCycles isNight = gameService.getStatus();
		return isNight;
	}

	@RequestMapping(value = "/players/findAllNear", method=RequestMethod.GET)
	public @ResponseBody List<Player> getAllPlayersNear(Principal principal)
	{
		// SCENT
		logger.info("Get all players near "+ principal.getName());
		List<Player> players = gameService.getAllPlayersNear(principal.getName());
		return players;
	}
	
	@RequestMapping(value = "players/kill", method=RequestMethod.POST)
	public void setKill(String killer, String victim)
	{
		logger.info("in kill with killer " + killer + " victim "+victim);
		if (gameService.canKill(killer, victim))
		{
			gameService.setKill(killer, victim);
			logger.info("Set kill");
		}
	}
	
	@RequestMapping(value = "/players/location", method=RequestMethod.POST)
	public void setPlayerLocation(String userID, double lat, double lng)
	{
		logger.info("Setting location");
		gameService.updatePosition(userID, lat, lng);
	}
	
	@RequestMapping(value = "players/vote", method=RequestMethod.POST)
	public void vote(String voterID, String suspectID)
	{
		logger.info("voterID" + " "+voterID + "susid"  +suspectID);
		gameService.vote(voterID, suspectID);
		logger.info("Vote cast");
	}
	
	@RequestMapping(value = "players/stats", method=RequestMethod.GET)
	public void vote(String user)
	{
		logger.info("voterID" + user);
		gameService.getStats(user);
	}
	
	public void CheckGameOperation () {
		logger.info("Checking game operation...");
		gameService.checkGame();
	}
}
