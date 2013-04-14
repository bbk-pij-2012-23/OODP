package interfaces;

import java.util.ArrayList;
/**
 * 
 * @author eleanormann
 * 
 * Dealer is the Controller. 
 * 
 * 1. deal two five-card poker hands, dealer's face down
 * 
 * 2. Evaluate either player's hand for best hand and reevaluate as needed
 *
 * 3. evaluate dealer's hand for best potential hand, and choose up to 3 cards to discard and replace.
 *
 * 4. allow the player to decide which of the cards in their hand should be replaced 
 *
 * 5. Draw one, two, or three more cards to replace the corresponding number of
 *unneeded cards in the player's original hand. 
 *
 * 6. compare both hands (the dealer and the player) and determine who wins 
 * 
 *
 */
public interface IDealer {
	
	
	/**
	 * 'start' method to allow game parameters to be set as needed
	 * @param otherPlayer
	 */
	public void play(String otherPlayer);
	
	/**
	 * method to deal initial hand and extra cards as needed
	 * returns an ArrayList of cards, data type not set - Likely to be Card object but could be String or Integer
	 */
	public PokerHand dealCards();
	
	/**
	 * 
	 * @param card
	 * @return true if successfully removed from hand
	 */
	public void removeCards(Card card);
	
	
	public String determineWinner();
	
	
	public ArrayList<Card> chooseCardsToReplace();

	
	

	
}
