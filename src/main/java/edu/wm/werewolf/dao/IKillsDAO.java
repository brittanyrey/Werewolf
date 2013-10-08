package edu.wm.werewolf.dao;

import java.util.List;

import edu.wm.werewolf.domain.Kill;
import edu.wm.werewolf.domain.Player;

public interface IKillsDAO {
	void setKill(Kill kill);
	List<Kill> getKillsBySameKiller(Player player);
	void reset();
	
}
