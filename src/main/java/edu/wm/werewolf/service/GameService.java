package edu.wm.werewolf.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
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

	@Autowired
	private IPlayerDAO playerDAO;
	@Autowired
	private IUserDAO userDAO;
	@Autowired
	private IKillsDAO killsDAO;
	@Autowired
	private IGameDAO gameDAO;

	public List<Player> getAllAlive() {
		if (!gameDAO.getIsRunning()) {
			return null;
		}
		return playerDAO.getAllAlive();
	}

	public List<Player> getAllPlayersNear(String name) {
		if (!gameDAO.getIsRunning()) {
			return null;
		}
		
		try {
			User user = userDAO.getUserByName(name);
			Player player = playerDAO.getPlayerByUserID(user.getId());
			if (player != null) {
				if (player.isWerewolf()) {
					return playerDAO.getAllNear(player);
				}
			}
			else {
				System.out.println("PLAYER WAS NULL");
			}
		} catch (NoPlayerFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void updatePosition(String userName, double lat, double lng) {
		if (gameDAO.getIsRunning()) {
			Date now = new Date();
			GPSLocation location = new GPSLocation(lat, lng, now);
			playerDAO.setPlayerLocation(userName, location);
		}
	}

	public boolean canKill(String killer, String victim) {
		if (!gameDAO.getIsRunning()) {
			return false;
		}
		// TODO Add back in isNight()
		System.out.println("Is night: " + gameDAO.isNight());
		try {
			Player killerObj = playerDAO.getPlayerByUserID(killer);
			Player victimObj = playerDAO.getPlayerByUserID(victim);
			if (killerObj.isWerewolf() && !victimObj.isWerewolf() && !victimObj.isDead()) {
				//	&& gameDAO.isNight()) {
				return true;
			} else {
				return false;
			}
		} catch (NoPlayerFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public void setKill(String killerID, String victimID) {
		if (gameDAO.getIsRunning()) {
			try {
				Player killerObj = playerDAO.getPlayerByUserID(killerID);
				Player victimObj = playerDAO.getPlayerByUserID(victimID);
				Kill kill = new Kill(killerID, victimID, new Date(), killerObj.getLat(), killerObj.getLng());
				killsDAO.setKill(kill);
				playerDAO.setDead(victimID);
			} catch (NoPlayerFoundException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean isAdmin(String id) {
		User user = userDAO.getUserbyID(id);
		return user.isAdmin();
	}

	public void newGame(int dayNightFreq) {
		killsDAO.reset();
		playerDAO.reset();
		gameDAO.reset();

		Game game = new Game(dayNightFreq);
		gameDAO.createGame(game);

		// List <MyUser> users = userDAO.getAllUsers();
		List<User> users = userDAO.getAllUsers();
		List<Player> allPlayers = new ArrayList<Player>();

		// for(MyUser u: users)
		for (User u : users) {
			Player p = new Player();
			p.setUserId(u.getId());
			p.setDead(false);
			playerDAO.createPlayer(p);
			allPlayers.add(p);
		}

		Collections.shuffle(allPlayers, new Random(System.currentTimeMillis()));
		int werewolfindex = (int) (allPlayers.size() / 3);

		if (werewolfindex == 0) {
			werewolfindex = 1;
		}

		for (Player gamePlayer : allPlayers) {
			if (werewolfindex > 0) {
				playerDAO.setWerewolfStatus(gamePlayer.getUserId(), true);
				werewolfindex--;
			} else {
				playerDAO.setWerewolfStatus(gamePlayer.getUserId(), false);
			}
		}
	}

	public void vote(String voter, String suspect) {
		// TODO take out comment
		if (gameDAO.getIsRunning() ) {//&& !gameDAO.isNight()) {
			playerDAO.vote(voter, suspect);
		}
	}

	public void checkGame() {
		if (gameDAO == null) {
		}

		else if (!gameDAO.getIsRunning()) {
		}
		
		else if ((playerDAO.getAllWerewolves().size() == 0)
				|| (playerDAO.getAllWerewolves().size() > playerDAO
						.getAllTownspeople().size())) {
			gameDAO.endGame();
			List <Player> aliveList = playerDAO.getAllAlive();
			for (int x = 0; x < aliveList.size(); x++)
			{
				userDAO.updateHighScore(1, aliveList.get(x).getUserId());
			}
		}
		// TODO 
		// -if it's time to collect votes.
		// -must vote off person who is voted most
	}

	public void addUser(String id, String firstName, String lastName,
			String username, String hashedPassword, String imageURL,
			Boolean isAdmin) {
		User user = new User(id, firstName, lastName, username, hashedPassword,
				imageURL, isAdmin);
		userDAO.createUser(user);
	}

	public void endGame() {
		gameDAO.endGame();		
	}
}
