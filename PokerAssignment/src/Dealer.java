import java.util.ArrayList;


public class Dealer {

	
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

}
