package classes;

import java.util.ArrayList;

import classes.DealersBrain.Hand;

import interfaces.Card;
import interfaces.IDealer;
import interfaces.Deck;

public class Dealer implements IDealer {
	private final String userID = "Dealer";
	private Player otherPlayer;	
	private final Deck<Card> deck = new DeckImpl<Card>();
	private ArrayList<Card> hand;

	
	public Dealer(){
	}
	
	public ArrayList<Card> getHand() {
		return hand;
	}


	public void setHand(ArrayList<Card> hand) {
		this.hand = hand;
	}


	public Deck<Card> getDeck() {
		return deck;
	}



	@Override
	public ArrayList<Card> dealCards() {
		int i = 0;
		ArrayList<Card> player1 = new ArrayList<Card>();
		ArrayList<Card> player2 = new ArrayList<Card>();
		while (i < 5){
			player1.add(deck.dealCard());
			player2.add(deck.dealCard());
			setHand(player1);
			otherPlayer.setHand(player2);
			i++;
		}
		return hand;
	}

	private int findDealNum() {
		int dealNum = 5;
		//some way of specifying cards to deal
		return dealNum;
	}

	/**
	 * there is no point in this method
	 */
	@Override
	public boolean removeCards(String card) {
		return hand.remove(card);
	}
	
	@Override
	public String determineWinner() {
		
		String winner;
		DealersBrain think = new DealersBrain();
		
		Hand otherPlayerBestHand = think.findBestHand(otherPlayer.getHand());
		Hand dealerBestHand = think.findBestHand(hand);
		
		if(otherPlayerBestHand.compareTo(dealerBestHand)==1){
			winner = otherPlayer.getUserID();
		}
		else if (otherPlayerBestHand.compareTo(dealerBestHand)==0){
			winner = "It's a draw";
		}
		else { //should I handle exceptions in this method?
			winner = userID;
		}
		return winner;
	}

	@Override
	public ArrayList<Card> determineDiscard() {	
		DealersBrain think = new DealersBrain();
		ArrayList<Card> replacementHand = think.bestPotentialHand(getHand());
		int numCards = replacementHand.size();
		int i = 0;
		while(i<numCards){
			Card card = replacementHand.get(i);
			getHand().remove(card);
			i++;
		}
		i=0;
		while(i<numCards){
			replacementHand.add(deck.dealCard());
			i++;
		}
		return replacementHand;
	}



	public String discard(String discards) {
		
		return null;
	}

	@Override
	public void play(String otherPlayerName) {
		otherPlayer = new Player(otherPlayerName);	
	}

	


	

	
}
