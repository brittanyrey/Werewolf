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
		
		Query findUserQuery = new Query(Criteria.where("id").is("123"));
		List<User> usersfound = mongoOperation.find(findUserQuery, User.class );
		if (usersfound.size()>0) {
			return (User) usersfound.get(0);
		}else {
			return null;
		}
	}
	
	@Override
	public User getUserByName (String name) {
		User user = new User("123", "reynoso",  "brittany", "brittany", "yes", null, true);
		createUser(user);
		
		Query findUserQuery = new Query(Criteria.where("username").is(name));
		List<User> usersfound = mongoOperation.find(findUserQuery, User.class );
		if (usersfound.size()>0) {
			return (User) usersfound.get(0);
		}else {
			return null;
		}
	}

	@Override
	public List<User> getAllUsers() {
		List <User> AllUsers = mongoOperation.findAll(User.class);
		return AllUsers;
	}
}
