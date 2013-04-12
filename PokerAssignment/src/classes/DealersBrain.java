package classes;
import interfaces.Card;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;


public class DealersBrain {

	/**Not sure of the value of this. I could do it without it, just use a string. 
	 * 
	 * @author eleanormann
	 * adapted from @author missingfaktor Mar'2010, StackOverflow (http://stackoverflow.com/questions/2497521/implementing-tostring-on-java-enums) 
	 */
	public enum Hand {
		NOTHING, PAIR, TWOPAIR,THREEKIND,STRAIGHT,FLUSH,FOURKIND;
		
		@Override
		public String toString(){
			switch(this){
				case NOTHING: return "nothing";
				case PAIR: return "a pair"; 
				case TWOPAIR: return "two pairs";
				case THREEKIND: return "three of a kind";
				case STRAIGHT: return "a straight";
				case FLUSH: return "a flush";
				case FOURKIND: return "four of a kind";
				default: throw new IllegalArgumentException(); 
			}
		
		}
	}
	
	
	/**long-winded interpretation of calculator results by process of elimination
	 * note that a full house is treated as three of a kind and a straight flush is treated as a flush. 
	 * 
	 * @param calcSameValues
	 * @param calcConsecValues
	 * @param calcSameSuits
	 * @return hand
	 */
	public Hand bestHand(ArrayList<Integer> calcSameValues, ArrayList<Integer> calcConsecValues, ArrayList<Integer> calcSameSuits) {
		Hand hand; 
		if(calcSameSuits.size()==4){
			hand = Hand.FLUSH;
		}
		else if(calcConsecValues.size()==5){
			hand = Hand.STRAIGHT;
		}
		else{
			if(calcSameValues.isEmpty()){
				hand = Hand.NOTHING;
			}
			else if(calcSameValues.size()==1){
				hand = Hand.PAIR;
			}
			else if(calcSameValues.size()==2) {
				if(calcSameValues.get(0)==calcSameValues.get(1)){
					hand= Hand.THREEKIND;
				}
				else{
					hand= Hand.TWOPAIR;
				}
			}
			else {
				if(calcSameValues.get(0)==calcSameValues.get(1) && calcSameValues.get(0)==calcSameValues.get(2)){
					hand = Hand.FOURKIND;
				}
				else{
					hand= Hand.THREEKIND;
				}
			}
		}
		return hand;
	}

	public Hand findBestHand(ArrayList<Card> hand) {
		int[] suitArray = new int[5];
		int[] valueArray = new int[5];
		int i = 0;
		Iterator<Card> it = hand.iterator();
		while (it.hasNext()){
			Card temp = it.next();
			suitArray[i]=temp.getSuit();
			valueArray[i]=temp.getValue();
			i++;
		}
		Calculator<Integer> cal = new Calculator<Integer>();
		ArrayList<Integer> consecutiveValues = cal.consecValues(valueArray);
		ArrayList<Integer> sameValues = cal.sameValues(valueArray);
		ArrayList<Integer> sameSuits = cal.sameValues(suitArray);
		Hand bestHand = bestHand(sameValues, consecutiveValues, sameSuits);
		return bestHand;
	}
	
	public ArrayList<Card> bestPotentialHand(ArrayList<Card> hand){
		Hand bestHand = findBestHand(hand);
		if(bestHand.compareTo(Hand.PAIR)>0){
			if(/*check for awesome hand*/){
					//behave appropriately
			}
			else{
			//do something to extract the other cards not in the best hand
			}	
		}
		else if (bestHand.compareTo(Hand.PAIR)==0){
			//check whether a high pair
		}
		else if(/*check for broken conseq and no. same suits*/){
			//behave approp
		}
		else{
		 
		}
		ArrayList<Card> cardsToDiscard;
		
		return cardsToDiscard;
	}

}
