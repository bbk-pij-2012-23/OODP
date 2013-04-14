package pokerHands;

import interfaces.Card;
import interfaces.PokerHand;

import java.util.ArrayList;

import classes.Calculator;



public class Pair extends AbstractPokerHand implements PokerHand{ 
	private final int rank = 6;
	

	public int getRank() {
		return rank;
	}
/*
 * another nasty implementation. I'm sleepy.
 */
	@Override
	public ArrayList<Card> discard() {
		int[]valuesArray = new int[hand.size()];
		int i=0;
		while(i<hand.size()){
			valuesArray[i]= hand.get(i).getValue();
			i++;
		}
		Calculator cal = new Calculator();
		ArrayList<Card> discards = new ArrayList<Card>();
		discards.addAll(hand);
		ArrayList<Integer> pairs = cal.sameValues(valuesArray);
		if(pairs.get(0)==1 || pairs.get(0)>=11){
			i=hand.size()-1;
			while(i>=0){
				if(discards.get(i).getValue()==pairs.get(0)){
					discards.remove(i);
				}
				i--;
			}
			return discards;
		}else {
			return discards;
		}
		
	}
	
	
}
