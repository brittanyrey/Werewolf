package edu.wm.werewolf.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import edu.wm.werewolf.domain.GPSLocation;
import edu.wm.werewolf.domain.Kill;
import edu.wm.werewolf.domain.Player;
import edu.wm.werewolf.domain.User;
import edu.wm.werewolf.mongoDB.SpringMongoConfig;

//@Document(collection = "players")
public class MongoKillsDAO implements IKillsDAO {
	@Autowired DB db;
	
//	private MongoOperations mongoOperation;
//	
//	public MongoKillsDAO() throws UnknownHostException {
//	    ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
//	    mongoOperation = (MongoOperations)ctx.getBean("mongoTemplate");
//	}
	
	@Override
	public void setKill(Kill kill) {
		DBCollection table = db.getCollection("kills");
		BasicDBObject documentDetail = new BasicDBObject();
		documentDetail.put("killer", kill.getKillerID());
		documentDetail.put("location", kill.getLocation());
		documentDetail.put("victim", kill.getVictimID());
		documentDetail.put("time", kill.getTimestampDate());
	 
		table.insert(documentDetail);
	}

	@Override
	public List<Kill> getKillsBySameKiller(Player player) {
		DBCollection table = db.getCollection("kills");
		BasicDBObject query = new BasicDBObject("killer", player.getId());
		DBCursor cursor = table.find(query);
		List <Kill> allKills = new ArrayList<Kill>();
		while (cursor.hasNext())
		{
			DBObject kill = cursor.next();
			Kill killItem = new Kill((String)kill.get("killer"), (String)kill.get("victim"),
					(Date)kill.get("time"), (GPSLocation)kill.get("location"));
		
			allKills.add(killItem);
		}
		return allKills;
	}

	@Override
	public void reset()
	{
		DBCollection table = db.getCollection("kills");
		table.drop();
	}
}
