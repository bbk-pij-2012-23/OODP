package pokerHands;

import interfaces.Card;
import interfaces.PokerHand;

import java.util.ArrayList;


public class Nothing extends AbstractPokerHand implements PokerHand {
	private final int rank = 7;


	public int getRank() {
		return rank;
	}

	@Override
	public ArrayList<Card> discard() {		
		return hand;
	}
	

}
