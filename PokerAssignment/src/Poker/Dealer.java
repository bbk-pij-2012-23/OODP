package Poker;

import java.util.ArrayList;
/**
 * 
 * @author eleanormann
 * 
 * Dealer is the Controller. 
 * There are 4 key tasks: 
 * - deal cards to create a Hand, returned as an ArrayList (which allows the same method to be used for dealing
 * subsequent cards, otherwise a Hand could have been returned).
 * 
 * - remove cards to improve Hands, returning a boolean true if successfully removed (could basically 
 * implement iterator)
 * 
 * - determine which cards to remove from a Hand, returning the cards in an ArrayList
 * 
 * - compare two Hands and determine a winner
 *  
 * additional methods could include validation functions and feedback.
 *  
 * ***Think about design patterns for this controller*** 
 * 
 * I have left ArrayLists unspecified right now because I am not clear enough about generics to know 
 * whether to specify a type or generify the interface. 
 * 
 *
 */
public interface Dealer {

	public ArrayList dealCards();
	public boolean removeCards();
	public String determineWinner();
	public ArrayList determineDiscard();
	

	
}
