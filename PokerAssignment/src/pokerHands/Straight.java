package pokerHands;

import interfaces.Card;
import interfaces.PokerHand;

import java.util.ArrayList;


public class Straight extends AbstractPokerHand implements PokerHand {
	private final int rank = 3;
	
	public int getRank() {
		return rank;
	}
	
	@Override
	public ArrayList<Card> discard() {
		ArrayList<Card> discards = new ArrayList<Card>();
		return discards;
	}
	

}
