package edu.wm.werewolf.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

import org.springframework.beans.factory.annotation.Autowired;

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
	
	private Game game;
	
	public List<Player> getAllAlive()
	{
		return playerDAO.getAllAlive();
	}
	
	public List<Player> getAllPlayersNear(Player player)
	{
		return playerDAO.getAllNear(player);
	}
	
	public void updatePosition(String userName, GPSLocation location)
	{
		User user = userDAO.getUserbyID(userName);
		playerDAO.setPlayerLocation(user.getId(), location);	
	}
	
	public boolean canKill(Player killer, Player victim) {
		System.out.println(game.isNight());
		if (killer.isWerewolf() && !victim.isWerewolf() && !victim.isDead() && game.isNight())
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
		killsDAO.setKill(kill);
		try {
			playerDAO.setDead(playerDAO.getPlayerByID(kill.getVictimID()));
		} catch (NoPlayerFoundException e) {
			e.printStackTrace();
		}
	}
	
	public boolean isAdmin(Player player)
	{
		User user = userDAO.getUserbyID(player.getId());
		return user.isAdmin();
	}
	
	public void newGame(int dayNightFreq)
	{
		killsDAO.reset();
		playerDAO.reset();
		game = new Game(dayNightFreq, new Date());

		List <Player> players = new ArrayList<>();
		//List <MyUser> users = userDAO.getAllUsers();
		List <User> users = userDAO.getAllUsers();
		
		//for(MyUser u: users)
		for (User u: users)
		{
			Player p = new Player();
			p.setUserId(u.getId());
			playerDAO.createPlayer(p);
			players.add(p);
		}
		
		Collections.shuffle(players, new Random(System.currentTimeMillis()));
		int werewolfindex = (int) (players.size() * .3f);
		
		for (Player gamePlayer : players)
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
		playerDAO.vote(player, votee);		
	}
	
	public void checkGame()
	{
		if ((playerDAO.getAllWerewolves().size() == 0) ||  
				(playerDAO.getAllWerewolves().size() > playerDAO.getAllTownspeople().size()))
		{
			game.setIsRunning(false);
		}
	}
}