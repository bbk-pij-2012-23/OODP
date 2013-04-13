package pokerHands;

import interfaces.Card;
import interfaces.PokerHand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

import classes.Calculator;


public class FourKind implements PokerHand {
	private ArrayList<Card> hand;
	private final int rank = 1;

	public ArrayList<Card> getHand() {
		return hand;
	}

	public void setHand(ArrayList<Card> hand) {
		this.hand = hand;
	}

	public int getRank() {
		return rank;
	}

	/**
	 * we know 4 cardValues are the same so look for the cardValue that does not match the rest and return it
	 * it only increments 1 so it repeats comparisons for cards it knows are not the target card
	 * 
	 * this is a horrible method
	 */
	@Override
	public ArrayList<Card> discard() {
		ArrayList<Card> discards = new ArrayList<Card>();		
		int i = 1;
		Card testCard = hand.get(i);
		Card baseCard = hand.get(i-1);
		while(i<hand.size()){
			if (baseCard.getValue()!=testCard.getValue()){
				if (i+1==hand.size()){
					discards.add(testCard);
					return discards;
				}
				else{
					testCard=hand.get(i+1);
					if(baseCard.getValue()!=testCard.getValue()){
						discards.add(baseCard);
						return discards;
					}	
					else{
						discards.add(hand.get(i));
						return discards;
					}
				}
			}
			i++;
			testCard=hand.get(i);
		}	
		return discards;
	}
	

}
