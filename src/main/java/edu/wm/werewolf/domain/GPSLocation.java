package edu.wm.werewolf.domain;

import java.util.Date;

public class GPSLocation {
	private double latitude;
	private double longitude;
	private Date time;
	
	public GPSLocation (double lat, double lng, Date time){
		super();
		this.latitude = lat;
		this.longitude = lng;
		this.setTime(time);
	}
	
	public GPSLocation() {}
	
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

}
