package edu.wm.werewolf.exceptions;


public class NoPlayerFoundException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userID;
	
	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public NoPlayerFoundException(String userId) {
		super();
		this.userID = userId;
	}
}
