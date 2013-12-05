package edu.wm.werewolf.domain;

public class NumDaysAndNightCycles {
	private float numDays;
	private boolean isNight;
	private float alivePlayers; //error alive players == werewolves....
	private float allPlayers;
	private float dayNightCycle;
	
	public NumDaysAndNightCycles(float numDays, boolean isNight,
			float alivePlayers, float allPlayers, float dayNightCycle) {
		super();
		this.numDays = numDays;
		this.isNight = isNight;
		this.alivePlayers = alivePlayers;
		this.allPlayers = allPlayers;
		this.dayNightCycle = dayNightCycle;
	}
	
	public float getAlivePlayers() {
		return alivePlayers;
	}
	public void setAlivePlayers(float alivePlayers) {
		this.alivePlayers = alivePlayers;
	}
	public float getAllPlayers() {
		return allPlayers;
	}
	public void setAllPlayers(float allPlayers) {
		this.allPlayers = allPlayers;
	}
	public float getDayNightCycle() {
		return dayNightCycle;
	}
	public void setDayNightCycle(float dayNightCycle) {
		this.dayNightCycle = dayNightCycle;
	}
	public float getNumDays() {
		return numDays;
	}
	public void setNumDays(float numDays) {
		this.numDays = numDays;
	}
	public boolean isNight() {
		return isNight;
	}
	public void setNight(boolean isNight) {
		this.isNight = isNight;
	}
	
	

}
