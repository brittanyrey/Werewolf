package edu.wm.werewolf.dao;

import java.util.List;

import edu.wm.werewolf.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

@Document(collection = "users")
public class MongoUserDao implements IUserDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(MongoUserDao.class);
	
	@Autowired
	private MongoOperations mongoOperation;
		
	@Override
	public void createUser(User user) {
		mongoOperation.save(user);
	}

	@Override
	public User getUserbyID (String id) {
		User user = new User("123", "reynoso",  "brittany", "brittany", "yes", null, true);
		createUser(user);
		
		Query findUserQuery = new Query(Criteria.where("id").is(id));
		User usersfound = (User) mongoOperation.find(findUserQuery, User.class );
		return usersfound;
	}
	
	@Override
	public User getUserByName (String name) {
		User user = new User("123", "reynoso",  "brittany", "brittany", "yes", null, true);
		createUser(user);
		
		Query findUserQuery = new Query(Criteria.where("username").is(name));
		User usersfound = (User) mongoOperation.find(findUserQuery, User.class );
		return usersfound;
	}

	@Override
	public List<User> getAllUsers() {
		List <User> AllUsers = mongoOperation.findAll(User.class);
		return AllUsers;
	}
}
