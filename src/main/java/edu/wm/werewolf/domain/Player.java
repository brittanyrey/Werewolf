package edu.wm.werewolf.domain;

import java.util.Date;

public class Player {

	// Pojo! Plain old java object
	private String id;
	private boolean isDead;
	private GPSLocation location;
	private String userId;
	private boolean isWerewolf;
	private String votedAgainst;
	private Date lastUpdate;
	
	public Player(String id, boolean isDead, GPSLocation location,
			String userId, boolean isWerewolf) {
		super();
		this.id = id;
		this.isDead = isDead;
		this.location = location;
		this.userId = userId;
		this.isWerewolf = isWerewolf;
	}

	public Player() {
	}

	public boolean isWerewolf() {
		return isWerewolf;
	}

	public void setWerewolf(boolean isWerewolf) {
		this.isWerewolf = isWerewolf;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public boolean isDead() {
		return isDead;
	}
	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}
	public GPSLocation getLocation() {
		return location;
	}
	public void setLocation(GPSLocation location) {
		this.location = location;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getVotedAgainst() {
		return votedAgainst;
	}

	public void setVotedAgainst(String votedAgainst) {
		this.votedAgainst = votedAgainst;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpDate) {
		this.lastUpdate = lastUpDate;
	}	
}
