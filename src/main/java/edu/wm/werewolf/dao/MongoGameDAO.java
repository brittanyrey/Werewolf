package edu.wm.werewolf.dao;

import java.net.UnknownHostException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.mapping.Document;

import edu.wm.werewolf.domain.Game;
import edu.wm.werewolf.mongoDB.SpringMongoConfig;

@Document(collection = "game")
public class MongoGameDAO implements IGameDAO{
	
	private MongoOperations mongoOperation;
	
	public MongoGameDAO() throws UnknownHostException {
	    ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
	    mongoOperation = (MongoOperations)ctx.getBean("mongoTemplate");
	}
	
	@Override
	public void createGame(Game game) {
		
	}
	

	@Override
	public boolean getIsRunning() {
		return false;
	}

	@Override
	public boolean isNight() {
		return false;
	}

	@Override
	public void endGame() {
		// set is running to false
		
	}
	

}
