package pokerHands;

import interfaces.Card;
import interfaces.PokerHand;

import java.util.ArrayList;


import classes.Calculator;


public class TwoPairs extends AbstractPokerHand implements PokerHand {
	private final int rank = 5;

	public int getRank() {
		return rank;
	}

	@Override
	public ArrayList<Card> discard() {
		ArrayList<Card> discards = new ArrayList<Card>();
		
		int[]valuesArray = new int[hand.size()];
		int i=0;
		while(i<hand.size()){
			valuesArray[i]= hand.get(i).getValue();
			i++;
		}
		Calculator cal = new Calculator();
		
		discards.addAll(hand);
		ArrayList<Integer> temp = cal.sameValues(valuesArray);
		i=discards.size()-1;
		while(i>=0){
			if(discards.get(i).getValue()==temp.get(0)){
				discards.remove(i);
			}
			i--;
		}
		i=discards.size()-1;
			while(i>=0){
				if(discards.get(i).getValue()==temp.get(2)){
					discards.remove(i);
				}
				i--;
			}
		return discards;
	}
	

}
