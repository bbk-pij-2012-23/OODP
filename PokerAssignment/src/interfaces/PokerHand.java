package interfaces;

import java.util.ArrayList;

public interface PokerHand {
	int getRank();
	ArrayList<Card> discard();
	void setHand(ArrayList<Card> hand);
	
	
}
