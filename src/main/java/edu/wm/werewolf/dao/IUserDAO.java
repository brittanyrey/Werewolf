package edu.wm.werewolf.dao;

import java.util.List;

import edu.wm.werewolf.domain.User;

public interface IUserDAO {
	
	void createUser(User user);

	User getUserByName(String userName);

	User getUserbyID(String id);
	List <User> getAllUsers ();
	void updateHighScore(int incrementBy, String userID);
}
