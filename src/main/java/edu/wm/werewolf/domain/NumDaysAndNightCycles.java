package edu.wm.werewolf.domain;

public class NumDaysAndNightCycles {
	private float numDays;
	private boolean isNight;
	
	public NumDaysAndNightCycles(float numDays, boolean isNight) {
		super();
		this.numDays = numDays;
		this.isNight = isNight;
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
