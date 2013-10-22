package edu.wm.werewolf.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

import edu.wm.werewolf.dao.IGameDAO;
import edu.wm.werewolf.dao.IKillsDAO;
import edu.wm.werewolf.dao.IPlayerDAO;
import edu.wm.werewolf.dao.IUserDAO;
import edu.wm.werewolf.domain.GPSLocation;
import edu.wm.werewolf.domain.Game;
import edu.wm.werewolf.domain.Kill;
import edu.wm.werewolf.domain.Player;
import edu.wm.werewolf.domain.User;
import edu.wm.werewolf.exceptions.NoPlayerFoundException;

public class GameService {
	
	@Autowired private IPlayerDAO playerDAO;
	@Autowired private IUserDAO userDAO;
	@Autowired private IKillsDAO killsDAO;
	@Autowired private IGameDAO gameDAO;
	
	public List<Player> getAllAlive()
	{
		if(!gameDAO.getIsRunning()) {
			return null;
		}
		return playerDAO.getAllAlive();
	}
	
	public List<Player> getAllPlayersNear(Player player)
	{
		if(!gameDAO.getIsRunning()) {
			return null;
		}
		return playerDAO.getAllNear(player);
	}
	
	public void updatePosition(String userName, GPSLocation location)
	{
		if(gameDAO.getIsRunning()) {
			User user = userDAO.getUserbyID(userName);
			playerDAO.setPlayerLocation(user.getId(), location);
		}	
	}
	
	public boolean canKill(Player killer, Player victim) {
		if(!gameDAO.getIsRunning()) {
			return false;
		}
		
		System.out.println("Is night: " + gameDAO.isNight());
		if (killer.isWerewolf() && !victim.isWerewolf() && !victim.isDead() && gameDAO.isNight())
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	public void setKill (Kill kill)
	{
		if(gameDAO.getIsRunning()) {
			killsDAO.setKill(kill);
			try {
				playerDAO.setDead(playerDAO.getPlayerByID(kill.getVictimID()));
			} catch (NoPlayerFoundException e) {
				e.printStackTrace();
			}
		}
	}
	
	public boolean isAdmin(String id)
	{
		User user = userDAO.getUserbyID(id);
		return user.isAdmin();
	}
	
	public void newGame(int dayNightFreq)
	{
		killsDAO.reset();
		playerDAO.reset();
		gameDAO.reset();
		
		Game game = new Game(dayNightFreq); 
		System.out.println(game.getDayNightFreq()+ " "+ game.getCreatedDate()+" "+ game.getIsRunning());
		gameDAO.createGame(game);

		//List <MyUser> users = userDAO.getAllUsers();
		List <User> users = userDAO.getAllUsers();
		
		//for(MyUser u: users)
		for (User u: users)
		{
			Player p = new Player();
			p.setUserId(u.getId());
			playerDAO.createPlayer(p);
		}
		
		List <Player> allPlayers = playerDAO.getAllAlive();
		Collections.shuffle(allPlayers, new Random(System.currentTimeMillis()));
		int werewolfindex = (int) (allPlayers.size() * .3f);
		if (werewolfindex == 0) {
			werewolfindex = 1;
		}
		
		for (Player gamePlayer : allPlayers)
		{
			if (werewolfindex>0) {
				gamePlayer.setWerewolf(true);
				werewolfindex--;
			}
			else {
				gamePlayer.setWerewolf(false);
			}
		}
	}

	public void vote(Player player, Player votee) {
		if(gameDAO.getIsRunning()) {
			playerDAO.vote(player, votee);
		}		
	}
	
	public void checkGame()
	{
		if (gameDAO == null) {}
		
		else if (!gameDAO.getIsRunning()) {}
		
		else if ((playerDAO.getAllWerewolves().size() == 0) ||  
				(playerDAO.getAllWerewolves().size() > playerDAO.getAllTownspeople().size()))
		{
			gameDAO.endGame();
		}
		//TODO add another else if that checks if its time to vote
		//& also if it's time to collect votes.
		// must vote off person who is voted most
	}
	
	public void addPlayer(Player player)
	{
		playerDAO.createPlayer(player);
	}
	
	public void addUser (String id, String firstName, String lastName, String username, 
			String hashedPassword, String imageURL, Boolean isAdmin)
	{
		User user = new User(id, firstName, lastName, username, hashedPassword, imageURL, isAdmin);
		userDAO.createUser(user);
	}
}
