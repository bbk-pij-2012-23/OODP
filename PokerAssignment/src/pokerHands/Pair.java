package pokerHands;

import interfaces.Card;
import interfaces.PokerHand;

import java.util.ArrayList;



public class Pair implements PokerHand {
	private ArrayList<Card> hand;
	private final int rank = 6;
	
	public ArrayList<Card> getHand() {
		return hand;
	}

	public void setHand(ArrayList<Card> hand) {
		this.hand = hand;
	}

	public int getRank() {
		return rank;
	}

	@Override
	public ArrayList<Card> discard() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
