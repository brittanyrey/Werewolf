package edu.wm.werewolf.domain;

public class NumDaysAndNightCycles {
	private long numDays;
	private boolean isNight;
	
	public NumDaysAndNightCycles(long numDays, boolean isNight) {
		super();
		this.numDays = numDays;
		this.isNight = isNight;
	}
	public long getNumDays() {
		return numDays;
	}
	public void setNumDays(long numDays) {
		this.numDays = numDays;
	}
	public boolean isNight() {
		return isNight;
	}
	public void setNight(boolean isNight) {
		this.isNight = isNight;
	}
	
	

}
