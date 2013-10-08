package edu.wm.werewolf;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;

import edu.wm.werewolf.dao.MongoPlayerDAO;
import edu.wm.werewolf.domain.Player;

public class TestMongoPlayerDAO {
	
	@Autowired
	public MongoPlayerDAO mongoPlayerDAO;
	
	private MongoOperations mongoOperation;
	
//	@Test
//	public void testCreatePlayer()
//	{
//		Player bob = new Player();
//		bob.setUserId("1");
//		bob.setWerewolf(true);
//		bob.setLat(40.3f);
//		bob.setLng(32.5f);
//		bob.setDead(true);
//		mongoPlayerDAO.createPlayer(bob);
//	}
//	
//	
//	@Test
//	public void testGetAllAlive() {
//		Player bob = new Player();
//		bob.setUserId("1");
//		bob.setWerewolf(true);
//		bob.setLat(40.3f);
//		bob.setLng(32.5f);
//		bob.setDead(true);
//		mongoPlayerDAO.createPlayer(bob);
//		
//		Player bob1 = new Player();
//		bob1.setUserId("2");
//		bob1.setWerewolf(false);
//		bob1.setLat(29.3f);
//		bob1.setLng(31.5f);
//		bob1.setDead(false);
//		mongoPlayerDAO.createPlayer(bob1);
//		
//		System.out.println(mongoPlayerDAO.getAllAlive());
//		
//	}

}
