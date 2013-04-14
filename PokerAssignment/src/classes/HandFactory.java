package classes;

import interfaces.PokerHand;

import java.util.ArrayList;

import pokerHands.Flush;
import pokerHands.FourKind;
import pokerHands.Nothing;
import pokerHands.Pair;
import pokerHands.Straight;
import pokerHands.ThreeKind;
import pokerHands.TwoPairs;

/**
 * 
 * @author eleanormann
 * is this a PokerHand factory?
 */
public class HandFactory{
	
	
	/**
	 * 
	 * @param calcSameValues
	 * @param calcConsecValues
	 * @param calcSameSuits
	 * @return hand
	 */
	public PokerHand createPokerHand(ArrayList<Integer> calcSameValues, ArrayList<Integer> calcConsecValues, ArrayList<Integer> calcSameSuits) {
		PokerHand hand = null;			
			
		if(calcSameSuits.size()==5){ 
			hand = new Flush();
		}
		else if(calcConsecValues.size()==5){
			hand = new Straight();
		}
		else{
			if(calcSameValues.isEmpty()){
				hand = new Nothing();
			}
			else if(calcSameValues.size()==2){
				hand = new Pair();
			}
			else if(calcSameValues.size()==3) {
				hand= new ThreeKind();
			}
			else if(calcSameValues.size()==4){
				int pair1 = calcSameValues.get(0)+ calcSameValues.get(1);
				int pair2 = calcSameValues.get(2)+ calcSameValues.get(3);
				if(pair1==pair2){
					hand = new FourKind();
				}
				else{
					hand= new TwoPairs();
				}
			}
				
		}
		return hand;
	}
	
}

