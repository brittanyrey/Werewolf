package edu.wm.werewolf.domain;

import java.util.Date;

public class Stats {
	private int score;
	private boolean isDead;
	private boolean isWerewolf;
	private int numKills;
	private String image;
	
	public Stats(int score, boolean isDead, boolean isWerewolf, int numKills,
			String image) {
		super();
		this.score = score;
		this.isDead = isDead;
		this.isWerewolf = isWerewolf;
		this.numKills = numKills;
		this.image = image;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public boolean isDead() {
		return isDead;
	}
	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}
	public boolean isWerewolf() {
		return isWerewolf;
	}
	public void setWerewolf(boolean isWerewolf) {
		this.isWerewolf = isWerewolf;
	}
	public int getNumKills() {
		return numKills;
	}
	public void setNumKills(int numKills) {
		this.numKills = numKills;
	}

}
