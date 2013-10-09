package edu.wm.werewolf.dao;

import java.net.UnknownHostException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.mongodb.MongoURI;

import edu.wm.werewolf.domain.Kill;
import edu.wm.werewolf.domain.Player;
import edu.wm.werewolf.mongoDB.SpringMongoConfig;

@Document(collection = "players")
public class MongoKillsDAO implements IKillsDAO {
	
	private MongoOperations mongoOperation;
	
	public MongoKillsDAO() throws UnknownHostException {
	    ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
	    mongoOperation = (MongoOperations)ctx.getBean("mongoTemplate");
	}
	
	@Override
	public void setKill(Kill kill) {
		Query findVictim = new Query(Criteria.where("id").is(kill.getVictimID()));
		mongoOperation.updateFirst(findVictim, Update.update("killer", kill.getKillerID()), Kill.class);
	}

	@Override
	public List<Kill> getKillsBySameKiller(Player player) {
		Query findKills = new Query(Criteria.where("Killer").is(player.getId()));
		List <Kill> allKills = mongoOperation.find(findKills, Kill.class );	
		return allKills;
	}

	@Override
	public void reset()
	{
		mongoOperation.dropCollection(Kill.class);
	}
}
