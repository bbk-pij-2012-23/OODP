package classes;

import java.util.ArrayList;

public class Player {
	private final String userID; //check conventions for naming final
	private ArrayList hand;
	
	public Player(String userID){
		this.userID = userID;
	}
	
	public String getUserID() {
		return userID;
	}
	
	public ArrayList getHand() {
		return hand;
	}
	public void setHand(ArrayList hand) {
		this.hand = hand;
	}
	
	
}
