package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import interfaces.Card;
import interfaces.Dealer;
import interfaces.Deck;

import org.junit.BeforeClass;
import org.junit.Test;

import classes.DealerImpl;
import classes.DealersBrain.Hand;
import classes.DeckImpl;
import classes.Player;

public class DealerTest {
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}


	@Test
	public void testDealCards() {
		DeckImpl<Card> testDeck = new DeckImpl<Card>();
		Dealer testDealer = new DealerImpl(testDeck, new Player("bob"));
		ArrayList<Card> testHand = testDealer.dealCards(null);
		assertEquals(5, testHand.size());
	}

	@Test
	public void testRemoveCards() {
		fail("Not yet implemented");
	}

	@Test
	public void testDetermineWinner() {
		Hand.FLUSH
		fail("Not yet implemented");
	}

	@Test
	public void testDetermineDiscard() {
		fail("Not yet implemented");
	}

}
