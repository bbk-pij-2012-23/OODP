package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import interfaces.Card;
import interfaces.PokerHand;

import org.junit.BeforeClass;
import org.junit.Test;

import classes.CardImpl;
import classes.Dealer;

import pokerHands.Flush;
import pokerHands.FourKind;
import pokerHands.Pair;
import pokerHands.ThreeKind;
import pokerHands.TwoPairs;

public class TestPokerHand {
	

	@Test
	public void testFlushDiscard() {
		PokerHand flush = new Flush();
		ArrayList<Card> discards = flush.discard();
		int output = discards.size();
		int expected = 0;
		assertEquals(expected, output);
	}
	
	@Test
	public void testFourKindDiscard() {
		PokerHand fourKind = new FourKind();
		Card a = new CardImpl(1,6);
		Card b = new CardImpl(3,6);
		Card c = new CardImpl(2,6);
		Card d = new CardImpl(4,6);
		Card e = new CardImpl(1,7);
		ArrayList<Card> testHand = new ArrayList<Card>();
		testHand.add(a);
		testHand.add(b);
		testHand.add(c);
		testHand.add(d);
		testHand.add(e);
		fourKind.setHand(testHand);
		ArrayList<Card> discards = fourKind.discard();
		int output = discards.size();
		int expected = 1;
		assertEquals(expected, output);
	}
	
	@Test
	public void testFourKind1Discard() {
		PokerHand fourKind = new FourKind();
		Card a = new CardImpl(1,6);
		Card b = new CardImpl(3,7);
		Card c = new CardImpl(2,6);
		Card d = new CardImpl(4,6);
		Card e = new CardImpl(1,6);
		ArrayList<Card> testHand = new ArrayList<Card>();
		testHand.add(a);
		testHand.add(b);
		testHand.add(c);
		testHand.add(d);
		testHand.add(e);
		fourKind.setHand(testHand);
		ArrayList<Card> discards = fourKind.discard();
		int output = discards.get(0).getValue();
		int expected = 7;
		assertEquals(expected, output);
	}

	@Test
	public void testHighPairDiscard(){
		PokerHand pair = new Pair();
		Card a = new CardImpl(1,12);
		Card b = new CardImpl(3,7);
		Card c = new CardImpl(2,6);
		Card d = new CardImpl(4,12);
		Card e = new CardImpl(3,10);
		ArrayList<Card> testHand = new ArrayList<Card>();
		testHand.add(a);
		testHand.add(b);
		testHand.add(c);
		testHand.add(d);
		testHand.add(e);
		pair.setHand(testHand);
		ArrayList<Card> discards = pair.discard();
		int output = discards.size();
		int expected = 3;
		assertEquals(expected, output);
	}
	
	@Test
	public void testLowPairDiscard(){
		PokerHand pair = new Pair();
		Card a = new CardImpl(1,6);
		Card b = new CardImpl(3,7);
		Card c = new CardImpl(2,6);
		Card d = new CardImpl(4,12);
		Card e = new CardImpl(3,10);
		ArrayList<Card> testHand = new ArrayList<Card>();
		testHand.add(a);
		testHand.add(b);
		testHand.add(c);
		testHand.add(d);
		testHand.add(e);
		pair.setHand(testHand);
		ArrayList<Card> discards = pair.discard();
		int output = discards.size();
		int expected = 5;
		assertEquals(expected, output);
	}
	
	@Test
	public void test3KindDiscard(){
		PokerHand threeKind = new ThreeKind();
		Card a = new CardImpl(1,6);
		Card b = new CardImpl(3,7);
		Card c = new CardImpl(2,6);
		Card d = new CardImpl(4,12);
		Card e = new CardImpl(3,6);
		ArrayList<Card> testHand = new ArrayList<Card>();
		testHand.add(a);
		testHand.add(b);
		testHand.add(c);
		testHand.add(d);
		testHand.add(e);
		threeKind.setHand(testHand);
		ArrayList<Card> discards = threeKind.discard();
		int output = discards.size();
		int expected = 2;
		assertEquals(expected, output);
	}	
	
	@Test
	public void test2PairsDiscard(){
		PokerHand twoPairs = new TwoPairs();
		Card a = new CardImpl(1,6);
		Card b = new CardImpl(3,7);
		Card c = new CardImpl(2,6);
		Card d = new CardImpl(4,12);
		Card e = new CardImpl(3,12);
		ArrayList<Card> testHand = new ArrayList<Card>();
		testHand.add(a);
		testHand.add(b);
		testHand.add(c);
		testHand.add(d);
		testHand.add(e);
		twoPairs.setHand(testHand);
		ArrayList<Card> discards = twoPairs.discard();
		int output = discards.size();
		int expected = 1;
		assertEquals(expected, output);
	}	
	
	@Test
	public void testToString(){
		PokerHand flush = new Flush();
		Card a = new CardImpl(1,6);
		Card b = new CardImpl(1,4);
		Card c = new CardImpl(1,12);
		Card d = new CardImpl(1,2);
		Card e = new CardImpl(1,7);
		ArrayList<Card> testHand = new ArrayList<Card>();
		testHand.add(a);
		testHand.add(b);
		testHand.add(c);
		testHand.add(d);
		testHand.add(e);
		flush.setHand(testHand);
		String expected = "\r1. Six of Spades\r2. Four of Spades\r3. Queen of Spades\r4. Two of Spades\r5. Seven of Spades";
		String output = flush.toString();
		assertEquals(expected,output);
		
	}
	
	@Test
	public void testFourKindInheritence() {
		PokerHand fourKind = new FourKind();
		Card a = new CardImpl(1,6);
		Card b = new CardImpl(3,6);
		Card c = new CardImpl(2,6);
		Card d = new CardImpl(4,6);
		Card e = new CardImpl(1,7);
		ArrayList<Card> testHand = new ArrayList<Card>();
		testHand.add(a);
		testHand.add(b);
		testHand.add(c);
		testHand.add(d);
		testHand.add(e);
		fourKind.setHand(testHand);
		assertNotNull(fourKind);
	}
}
