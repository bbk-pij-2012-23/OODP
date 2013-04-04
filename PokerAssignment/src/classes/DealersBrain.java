package classes;
import interfaces.Card;

import java.util.ArrayList;


public class DealersBrain {

	/** THIS DOES NOTHING AT THE MO
	 * 
	 * 
	 * 
	 * @author eleanormann
	 * adapted from @author missingfaktor Mar'2010, StackOverflow (http://stackoverflow.com/questions/2497521/implementing-tostring-on-java-enums) 
	 */
	public enum Hand {
		PAIR, TWOPAIR,THREEKIND,STRAIGHT,FLUSH,FOURKIND;
		
		@Override
		public String toString(){
			switch(this){
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
	public String bestHand(ArrayList<Integer> calcSameValues, ArrayList<Integer> calcConsecValues, ArrayList<Integer> calcSameSuits) {
		String hand = "";
		if(calcSameSuits.size()==4){
			hand = "a flush";
		}
		else if(calcConsecValues.size()==5){
			hand = "a straight";
		}
		else{
			if(calcSameValues.isEmpty()){
				hand = "nothing";
			}
			else if(calcSameValues.size()==1){
				hand = "a pair";
			}
			else if(calcSameValues.size()==2) {
				if(calcSameValues.get(0)==calcSameValues.get(1)){
					hand= "three of a kind";
				}
				else{
					hand= "two pairs";
				}
			}
			else {
				if(calcSameValues.get(0)==calcSameValues.get(1) && calcSameValues.get(0)==calcSameValues.get(2)){
					hand = "four of a kind";
				}
				else{
					hand= "three of a kind";
				}
			}
		}
		return hand;
	}

	public String findBestHand() {
		// TODO Auto-generated method stub
		return null;
	}

}
