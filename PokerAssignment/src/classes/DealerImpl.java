package classes;

import java.util.ArrayList;

import classes.DealersBrain.Hand;

import interfaces.Card;
import interfaces.Dealer;
import interfaces.Deck;

public class DealerImpl implements Dealer {
	private final String userID = "Dealer"; //is this equivalent to Player?
	private Player otherPlayer;	
	private final Deck<Card> deck = new DeckImpl<Card>();
	private ArrayList<Card> hand;

	
	public DealerImpl(){
		
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
		
		int dealNum = findDealNum();
		int i = 0;
		
		ArrayList<Card> player1 = new ArrayList<Card>();
		ArrayList<Card> player2 = new ArrayList<Card>();
		while (i < dealNum){
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
	public boolean removeCards(Card card) {
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
	public ArrayList determineDiscard() {
		// TODO Auto-generated method stub
		return null;
	}



	public String discard(String discards) {
		
		return null;
	}

	

	
}
