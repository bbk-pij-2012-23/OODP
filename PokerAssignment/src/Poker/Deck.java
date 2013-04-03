package Poker;

import java.util.ArrayList;

/**
 * adapted from @author Owen Astrachan, Object-Oriented Design Concepts via Playing Cards 
 * http://www.cs.duke.edu/csed/ap/cards/cardstuff.pdf
 * @author eleanormann
 * 
 * Generic Deck allows ArrayList to be implemented as list of Cards or Integers or whatever. 
 * ***need better understanding of generics - though interfaces shouldn't be changed, I may have to
 */
public interface Deck<T> {
	
	public ArrayList<T> shuffleDeck();
	public ArrayList<T> iterateDeck();

}
