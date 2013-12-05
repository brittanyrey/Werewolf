package edu.wm.werewolf.dao;

import java.util.List;

import edu.wm.werewolf.domain.GPSLocation;
import edu.wm.werewolf.domain.Player;
import edu.wm.werewolf.exceptions.NoPlayerFoundException;

public interface IPlayerDAO {
	
	void createPlayer(Player player);
	List<Player> getAllAlive();
	void setDead(String userID);
	Player getPlayerByUserID(String id) throws NoPlayerFoundException;
	void setPlayerLocation(String id, GPSLocation loc);
	void reset();
	Player getPlayerWithMostVotes();
	List<Player> getAllNear(Player player);
	void vote(String userID, String suspect);
	List<Player> getAllWerewolves();
	List<Player> getAllTownspeople();
	void setWerewolfStatus(String userID, boolean isWerewolf);
	
}
