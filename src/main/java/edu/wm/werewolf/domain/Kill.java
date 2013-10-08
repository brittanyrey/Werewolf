package edu.wm.werewolf.domain;

import java.util.Date;

public class Kill {

	private String killerID;
	private String victimID;
	private Date timestampDate;
	private double lat;
	private double lng;
	
	public Kill(String killerID, String victimID, Date timestampDate,
			double lat, double lng) {
		super();
		this.killerID = killerID;
		this.victimID = victimID;
		this.timestampDate = timestampDate;
		this.lat = lat;
		this.lng = lng;
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
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}
	
	
}
