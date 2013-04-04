package classes;

import java.util.ArrayList;
import java.util.Collections;

import interfaces.Card;
import interfaces.Deck;

public class DeckImpl<T> implements Deck<T> {
	private ArrayList<Card> cards;
	
	/**
	 * factory to create a Card object for each value & suit combo in a deck of cards
	 */
	public DeckImpl(){
		cards = new ArrayList<Card>();
		for(int suit = 1; suit <= 4; suit++){
			for(int value = 1; value <= 13; value++){
				 Card card = new CardImpl(suit,value);
				 cards.add(card);
			}
		}
		Collections.shuffle(cards);
	}
	
	public ArrayList<Card> getCards() {
		return cards;
	}
		
		
	@Override
	public ArrayList<Card> shuffleDeck() {
		Collections.shuffle(cards);
		return cards;
	}

	/**
	 * I can't see how I'm going to use this but I guess one can look through a deck of cards
	 * I'll implement it when I see how it might be useful
	 */
	@Override
	public ArrayList iterateDeck() {
		return null;
	}
	
	public Card dealCard(){
		Card dealtCard = cards.get(0);
		cards.remove(dealtCard);
		return dealtCard;
	}

}
