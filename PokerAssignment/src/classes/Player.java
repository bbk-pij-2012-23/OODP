package classes;

import interfaces.PokerHand;

public class Player {
	private final String userID; //check conventions for naming final
	private PokerHand hand;
	
	public Player(String userID){
		this.userID = userID;
	}
	
	public String getUserID() {
		return userID;
	}
	
	public PokerHand getHand() {
		return hand;
	}
	public void setHand(PokerHand hand) {
		this.hand = hand;
	}
	
	
}
