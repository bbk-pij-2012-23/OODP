package interfaces;

import java.util.ArrayList;


/**
 * @author eleanormann
 *PokerHands ranked according to the table shown in http://poker.about.com/od/cardroomscasinos/a/videopokertips.htm
 *(adapted for this version)
 */
public interface PokerHand {
	int getRank();
	void setHand(ArrayList<Card> hand);
	ArrayList<Card> getHand();
	ArrayList<Card> discard();
}
