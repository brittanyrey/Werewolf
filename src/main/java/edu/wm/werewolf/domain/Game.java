package edu.wm.werewolf.domain;

import java.util.Date;

public class Game {

	private int dayNightFreq;
	private Date createdDate;
	private boolean isRunning;
	private long timer;
	
	public Game(int dayNightFreq) {
		super();
		this.dayNightFreq = dayNightFreq;
		this.createdDate = new Date();
		this.isRunning = true;
		this.timer = 0;

		System.out.println(dayNightFreq + " "+ this.dayNightFreq);
	}
	public int getDayNightFreq() {
		return dayNightFreq;
	}
	public void setDayNightFreq(int dayNightFreq) {
		this.dayNightFreq = dayNightFreq;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public boolean getIsRunning() {
		return isRunning;
	}
	public void setIsRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}
	public long getTimer() {
		return timer;
	}
	public void setTimer(long timer) {
		this.timer = timer;
	}
	public NumDaysAndNightCycles isNightAndNumDays() { 
		NumDaysAndNightCycles daysAndIsNight;
		Date currentDate = new Date();
		float timeElapsed = currentDate.getTime() - this.createdDate.getTime();
		int numOfcycles = (int) (timeElapsed/this.dayNightFreq);
		int numOfDays = (numOfcycles/2) + 1;
		float dayOrNight= numOfcycles%2;
		System.out.println("\ncreated Date: " + this.createdDate + 
							" \ncurrent date: " + currentDate + 
							" \ntime passed:  " + timeElapsed + 
							"\nnum of cylces: " + numOfcycles +
							"\nnum of days: " + numOfDays + 
							"\nday or Night: " + dayOrNight +
							"\ncycle length: "+ this.dayNightFreq);
		if (dayOrNight != 0) {
			daysAndIsNight = new NumDaysAndNightCycles(numOfDays, true);
			return daysAndIsNight;
		}
		else {
			daysAndIsNight = new NumDaysAndNightCycles(numOfDays, false);
			return daysAndIsNight;
		}
		
	}
}