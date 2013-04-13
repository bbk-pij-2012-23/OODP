package pokerHands;

import interfaces.Card;
import interfaces.PokerHand;

import java.util.ArrayList;


public class Flush implements PokerHand{
	private ArrayList<Card> hand;
	private final int rank = 2;

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
		ArrayList<Card> discards = new ArrayList<Card>();
		return discards;
	}
	


	
}