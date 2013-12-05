package edu.wm.werewolf.dao;

import edu.wm.werewolf.domain.Game;
import edu.wm.werewolf.domain.NumDaysAndNightCycles;

public interface IGameDAO {

	boolean getIsRunning();

	void createGame(Game game);

	void endGame();

	void reset();

	Game getGame();

}
