package pokerHands;

import interfaces.Card;
import interfaces.PokerHand;

import java.util.ArrayList;

import classes.Calculator;


public class ThreeKind extends AbstractPokerHand implements PokerHand {
	private final int rank = 4;

	public int getRank() {
		return rank;
	}

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
