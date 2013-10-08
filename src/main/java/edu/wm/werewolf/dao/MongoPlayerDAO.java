package edu.wm.werewolf.dao;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.geo.GeoResults;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.NearQuery;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import edu.wm.werewolf.domain.GPSLocation;
import edu.wm.werewolf.domain.Player;
import edu.wm.werewolf.exceptions.NoPlayerFoundException;
import edu.wm.werewolf.mongoDB.SpringMongoConfig;

@Document(collection = "players")
public class MongoPlayerDAO implements IPlayerDAO {
	
	private MongoOperations mongoOperation;
	
	public MongoPlayerDAO() throws UnknownHostException {
	    ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
	    mongoOperation = (MongoOperations)ctx.getBean("mongoTemplate");
	}

	@Override
	public void createPlayer(Player player) {
		mongoOperation.save(player);
	}
	
	@Override
	public List<Player> getAllAlive() {	
		Query allAliveQuery= new Query(Criteria.where("isDead").is(false));
		List<Player> players = mongoOperation.find(allAliveQuery, Player.class);
		return players;
	}

	@Override
	public void setDead(Player p) {
		Query findPlayerQuery = new Query(Criteria.where("id").is(p.getId()));
		mongoOperation.updateFirst(findPlayerQuery, Update.update("isDead", true), Player.class);		
	}
	
	@Override
	public void setPlayerLocation (String id, GPSLocation loc) {
		Query findPlayerQuery = new Query(Criteria.where("id").is(id));
		mongoOperation.updateFirst(findPlayerQuery, Update.update("lat", loc.getLatitude()), Player.class);	
		mongoOperation.updateFirst(findPlayerQuery, Update.update("lng", loc.getLongitude()), Player.class);
		mongoOperation.updateFirst(findPlayerQuery, Update.update("lastUpdate", loc.getTime()), Player.class);
	}

	@Override
	public Player getPlayerByID(String id) throws NoPlayerFoundException {
		Query findPlayerQuery = new Query(Criteria.where("id").is(id));
		return (Player) mongoOperation.find(findPlayerQuery, Player.class );	
	}

	@Override
	public List<Player> getAllNear(Player player) {
		if (player.isWerewolf()) 
		{
			List <Player> allPlayersNear = new ArrayList<Player>();
			BasicDBObject locQuery = new BasicDBObject();
			locQuery.put("loc", new BasicDBObject("$near", new Double[]{player.getLng(), player.getLat()}));
			DBCursor locCursor = mongoOperation.getCollection("players").find( locQuery );
			
			while (locCursor.hasNext())
			{
				DBObject result = locCursor.next();
				try {
					if ((String)result.get("isDead") != "false") {
						allPlayersNear.add((Player)(getPlayerByID((String)result.get("id"))));
					}
				} catch (NoPlayerFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return allPlayersNear;	
		}
		else 
		{
			return null;
		}	
	}
	
	@Override
	public void reset()
	{
		mongoOperation.dropCollection(Player.class);
	}

	@Override
	public void vote(Player player, Player votee) {
		player.setVotedAgainst(votee.getId());
		Query vote= new Query(Criteria.where("id").is(player.getId()));
		mongoOperation.updateFirst(vote, Update.update("votedAgainst", player.getVotedAgainst()), Player.class);
	}

	@Override
	public List<Player> getAllWerewolves() {
		Query werewolfQuery= new Query(Criteria.where("isWerewolf").is(true));
		List<Player> players = mongoOperation.find(werewolfQuery, Player.class);
		return players;
	}

	@Override
	public List<Player> getAllTownspeople() {
		Query townspeopleQuery= new Query(Criteria.where("isWerewolf").is(false));
		List<Player> players = mongoOperation.find(townspeopleQuery, Player.class);
		return players;
	}

}
