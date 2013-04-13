package pokerHands;

import interfaces.Card;
import interfaces.PokerHand;

import java.util.ArrayList;
import java.util.Iterator;

import classes.Calculator;


public class TwoPairs implements PokerHand {
	private ArrayList<Card> hand;
	private final int rank = 5;

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
		discards.addAll(hand);
	/*	
		
		int[]valuesArray = new int[5];
		int i=0;
		while(i<hand.size()){
			valuesArray[i]= hand.get(i).getValue();
			i++;
		}
		Calculator cal = new Calculator();
		ArrayList<Card> discards = new ArrayList<Card>();
		discards.addAll(hand);
		ArrayList<Integer> temp = cal.sameValues(valuesArray);
		i=hand.size()-1;
		
		while(i>=0){
			if(discards.get(i).getValue()==temp.get(0)){
				discards.remove(i);
			}
			i--;
		}
		*/
		return discards;
	}
	
	

}
