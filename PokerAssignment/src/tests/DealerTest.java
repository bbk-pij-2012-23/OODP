package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import interfaces.Card;
import interfaces.IDealer;

import org.junit.BeforeClass;
import org.junit.Test;

import classes.Dealer;
import classes.Deck;
;

public class DealerTest {
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}


	@Test
	public void testDealCards() {
		IDealer testDealer = new Dealer(Deck.newDeck());
		ArrayList<Card> testHand = testDealer.dealCards();
		assertEquals(5, testHand.size());
	}

	@Test
	public void testRemoveCards() {
		fail("Not yet implemented");
	}

	@Test
	public void testDetermineWinner() {
	
		fail("Not yet implemented");
	}

	@Test
	public void testDetermineDiscard() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testPotentialHand(){
		
	}
	

}
