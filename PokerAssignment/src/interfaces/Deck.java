package interfaces;

import java.util.ArrayList;

/** @author eleanormann
 * 
 * Basically a Card factory and Iterator
 * Adapted from @author Owen Astrachan, Object-Oriented Design Concepts via Playing Cards 
 * http://www.cs.duke.edu/csed/ap/cards/cardstuff.pdf
 *
 * Stuff generics
 * 
 */
public interface Deck<T> {
	
	public ArrayList shuffleDeck();
	public ArrayList iterateDeck();
	public Card dealCard();
	

}
