package edu.wm.werewolf.domain;

import java.util.Date;

public class Kill {

	private String killerID;
	private String victimID;
	private Date timestampDate;
	private GPSLocation location;
	
	public Kill(String killerID, String victimID, Date timestampDate,
			GPSLocation location) {
		super();
		this.killerID = killerID;
		this.victimID = victimID;
		this.timestampDate = timestampDate;
		this.location = location;
	}
	
	public String getKillerID() {
		return killerID;
	}
	public void setKillerID(String killerID) {
		this.killerID = killerID;
	}
	public String getVictimID() {
		return victimID;
	}
	public void setVictimID(String victimID) {
		this.victimID = victimID;
	}
	public Date getTimestampDate() {
		return timestampDate;
	}
	public void setTimestampDate(Date timestampDate) {
		this.timestampDate = timestampDate;
	}
	public GPSLocation getLocation() {
		return location;
	}
	public void setLat(GPSLocation location) {
		this.location = location;
	}
	
	
}
