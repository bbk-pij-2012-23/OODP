package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;

import interfaces.Card;


import org.junit.Test;

import classes.Deck;


public class TestDeck {

	@Test
	public void testDeckImpl() {
		
		assertNotNull(Deck.newDeck());
	}	
		
		
		
	@Test
	public void testShuffleDeck() {
		Deck testDeck = new Deck();
		ArrayList<Card> testCards = testDeck.getCards();
		String list1 = "Card1: " + testCards.get(0).getSuit() + ":" + testCards.get(0).getValue();
		testDeck.shuffleDeck();
		String list2 = "Card1: " + testCards.get(0).getSuit() + ":" + testCards.get(0).getValue();
		System.out.println(list1 + " "+  list2);
		assertFalse(list1.equals(list2));
	}

	@Test
	public void testIterateDeck() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testDealCard(){
		DeckImpl<Card> testDeck = new DeckImpl<Card>();
		Card testCard = testDeck.dealCard();
		assertFalse(testDeck.getCards().contains(testCard));
		assertEquals(51, testDeck.getCards().size());
	}

}
