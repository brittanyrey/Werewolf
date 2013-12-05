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
import edu.wm.werewolf.domain.NumDaysAndNightCycles;
import edu.wm.werewolf.domain.Player;
import edu.wm.werewolf.domain.Stats;
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
			} else {
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
		System.out.println("Is night: " + gameDAO.getGame().isNight());
		try {
			Player killerObj = playerDAO.getPlayerByUserID(killer);
			Player victimObj = playerDAO.getPlayerByUserID(victim);
			if (killerObj.isWerewolf() && !victimObj.isWerewolf()
					&& !victimObj.isDead() && gameDAO.getGame().isNight()) {
				return true;
			} else {
				return false;
			}
		} catch (NoPlayerFoundException e) {
			e.printStackTrace();
		}
		return false;
	}

	public void setKill(String killerID, String victimID) {
		if (gameDAO.getIsRunning()) {
			try {
				Player killerObj = playerDAO.getPlayerByUserID(killerID);
				Player victimObj = playerDAO.getPlayerByUserID(victimID);
				Kill kill = new Kill(killerID, victimID, new Date(),
						killerObj.getLat(), killerObj.getLng());
				killsDAO.setKill(kill);
				playerDAO.setDead(victimID);
			} catch (NoPlayerFoundException e) {
				e.printStackTrace();
			}
		}
	}

	public String getPassword(String usr) {
		User user = userDAO.getUserbyID(usr);
		return user.getHashedPassword() == null ? "fail" : user
				.getHashedPassword();
	}

	public boolean isAdmin(String id) {
		User user = userDAO.getUserbyID(id);
		return user.isAdmin();
	}

	public void newGame(int dayNightFreq) {
		List<Player> ps = playerDAO.getAllAlive();
		if (ps.size() > 0) {
			for (Player p : ps) {
				userDAO.updateHighScore(100, p.getId());
			}
		}

		killsDAO.reset();
		playerDAO.reset();
		gameDAO.reset();

		Game game = new Game(dayNightFreq * 60000);
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
		int werewolfindex = allPlayers.size() / 3;

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
		if (gameDAO.getIsRunning() && !gameDAO.getGame().isNight()) {
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
			List<Player> aliveList = playerDAO.getAllAlive();
			for (int x = 0; x < aliveList.size(); x++) {
				userDAO.updateHighScore(1, aliveList.get(x).getUserId());
			}
		} else {
			Game game = gameDAO.getGame();
			Date currentDate = new Date();
			float timeElapsed = currentDate.getTime()
					- game.getCreatedDate().getTime();
			int numOfcycles = (int) (timeElapsed / game.getDayNightFreq());
			if (timeElapsed - ((numOfcycles) * game.getDayNightFreq()) < 51000) {
				List<Player> players = playerDAO.getAllAlive();
				List<String> votesList = new ArrayList<String>();
				for (int x = 0; x < players.size(); x++) {
					if (players.get(x).getVotedAgainst() != null) {
						votesList.add(players.get(x).getVotedAgainst());
					}
				}
				String voteOUT = mostVotedFor(votesList);
				playerDAO.setDead(voteOUT);
			}
		}
	}

	private String mostVotedFor(List<String> votes) {
		int count = 1, tempCt;
		String popular = votes.get(0);
		String temp = "";
		for (int x = 0; x < votes.size() - 1; x++) {
			temp = votes.get(x);
			tempCt = 0;
			for (int y = 0; y < votes.size(); y++) {
				if (temp == votes.get(y))
					tempCt++;
			}
			if (tempCt > count) {
				popular = temp;
				count = tempCt;
			}
		}
		return popular;
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

	public NumDaysAndNightCycles getStatus() {
		if (gameDAO == null) {
		} else if (gameDAO.getIsRunning()) {
			Game game = gameDAO.getGame();
			return new NumDaysAndNightCycles(game.getDays(), game.isNight(),
					playerDAO.getAllWerewolves().size(), playerDAO
							.getAllAlive().size(), game.getDayNightFreq());
		}
		return new NumDaysAndNightCycles(0, true, 0, 0, 0);
	}

	public Stats getStats(String user) {
		User u = userDAO.getUserbyID(user);
		Player p;
		try {
			p = playerDAO.getPlayerByUserID(user);
			return new Stats(u.getScore(), p.isDead(), p.isWerewolf(), 0,
					u.getImageURL());
		} catch (NoPlayerFoundException e) {
			e.printStackTrace();
		}
		return null;

	}
}
