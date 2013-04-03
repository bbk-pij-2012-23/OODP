/**
 * 
 */
package Poker;

/**
 * @author eleanormann
 * adapted from @author Owen Astrachan, Object-Oriented Design Concepts via Playing Cards 
 * http://www.cs.duke.edu/csed/ap/cards/cardstuff.pdf
 * 
 */
public interface Card {
	public final int DIAMOND = 1;
	public final int SPADE = 2;
	public final int HEART = 3;
	public final int CLUB = 4;
	
	public int getSuit();
	public int getValue();
			
}
