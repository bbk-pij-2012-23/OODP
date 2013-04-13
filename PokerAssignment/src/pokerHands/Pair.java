package pokerHands;

import interfaces.Card;
import interfaces.PokerHand;

import java.util.ArrayList;

import classes.Calculator;



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
/*
 * another nasty implementation. I'm sleepy.
 */
	@Override
	public ArrayList<Card> discard() {
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
		return discards;
	}
	
	
}
