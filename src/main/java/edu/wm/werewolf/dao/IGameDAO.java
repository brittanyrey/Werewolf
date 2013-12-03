package edu.wm.werewolf.dao;

import edu.wm.werewolf.domain.Game;
import edu.wm.werewolf.domain.NumDaysAndNightCycles;

public interface IGameDAO {

	boolean getIsRunning();

	NumDaysAndNightCycles isNight();

	void createGame(Game game);

	void endGame();

	void reset();

}
