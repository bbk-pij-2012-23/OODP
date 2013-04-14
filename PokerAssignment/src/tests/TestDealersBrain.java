/**
 * 
 */
package tests;

import static org.junit.Assert.*;

import interfaces.Card;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import classDump.DealersBrain;
import classes.CardImpl;

/**
 * @author eleanormann
 *
 * DealersBrain is a mess. Have fun testing bestCard
 */
public class TestDealersBrain {
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}
	
	@Test
	public void testfindBestHand() {
		ArrayList<Card> testHand = new ArrayList<Card>();
		testHand.add(new CardImpl(2,4));
		testHand.add(new CardImpl(1,10));
		testHand.add(new CardImpl(2,10));
		testHand.add(new CardImpl(4,4));
		testHand.add(new CardImpl(3,13));
		
		DealersBrain testBrain = new DealersBrain();
		String output = testBrain.findBestHand(testHand).toString();
		String expected = "two pairs";
		assertEquals(expected, output);
		
	}
	
	

}
