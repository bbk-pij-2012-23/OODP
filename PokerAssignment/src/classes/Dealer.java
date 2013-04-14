package classes;

import java.util.ArrayList;
import java.util.Iterator;



import interfaces.Card;
import interfaces.IDealer;
import interfaces.PokerHand;

public class Dealer implements IDealer {
	private final String userID = "Dealer";
	private Player otherPlayer = new Player("Guest");	
	private Deck deck = null; //test for undermining singleton
	private PokerHand hand;

	
	public Dealer(){
	}

	public void setHand(PokerHand hand) {
		this.hand = hand;
	}
	
	public PokerHand getHand() {
		return hand;
	}

	
	public Deck getDeck() {
		return deck;
	}

	@Override
	public void play(String playerName){
		deck = Deck.newDeck();
		otherPlayer = new Player(playerName);
	}


	@Override
	public PokerHand dealCards() {
		if (deck==null){
			play("Guest"); //eek!
		}
		int i = 0;
		ArrayList<Card> player1 = new ArrayList<Card>();
		ArrayList<Card> player2 = new ArrayList<Card>();
		while (i < 5){
			player1.add(deck.dealCard());
			player2.add(deck.dealCard());
			i++;
		}
		
		setHand(findBestHand(player1));
		otherPlayer.setHand(findBestHand(player2));
		return hand;
		/*getHandAttributes
		 *getArrayLists of hand values
		 *identify hands
		 *set hands
		 * */
	}

	public PokerHand findBestHand(ArrayList<Card> cards){
		int[] suits = getHandAttribute(cards, "suit");
		int[] values = getHandAttribute(cards, "value");
		Calculator cal = new Calculator();
		ArrayList<Integer> consecutives = cal.consecValues(values, 1);
		ArrayList<Integer> sameCardValues = cal.sameValues(values);
		ArrayList<Integer> sameSuits = cal.sameValues(suits);
		HandFactory handFactory = new HandFactory();
		PokerHand pokerHand = handFactory.createPokerHand(sameCardValues, consecutives, sameSuits);
		return pokerHand;
	}
	
	private int[] getHandAttribute(ArrayList<Card> hand, String type) {
		int[] resultsArray = new int[5];
		int i = 0;
		Iterator<Card> it = hand.iterator();
		while (it.hasNext()){
			Card temp = it.next();
			if(type.equals("suit")){
				resultsArray[i]=temp.getSuit();
			}else if (type.equals("value")){
				resultsArray[i]=temp.getValue();
			}
			i++;
		}
		return resultsArray; 
	}
	
	/**
	 * there is no point in this method
	 */
	@Override
	public PokerHand removeCards(Card card) {
		hand.getHand().remove(card);
		return hand;
	}
	
	@Override
	public String determineWinner() {
		String winner;
		int opponent = otherPlayer.getHand().getRank();
		int dealer = getHand().getRank(); 
		if(dealer<opponent){
			winner = otherPlayer.getUserID();
		}
		else if (dealer==opponent){
			winner = "It's a draw";
		}
		else if (dealer<opponent){ //should I handle exceptions in this method?
			winner = userID;
		}
		else{
			throw new IllegalArgumentException("Something has gone wrong, I don't know who won");
		}
		return winner;
	}

	@Override
	public ArrayList<Card> chooseCardsToReplace() {	
		ArrayList<Card> cardsToReplace = hand.discard();
		removeAndReplace(hand, cardsToReplace);
		setHand(findBestHand(hand.getHand()));
		return hand.getHand();
	}



	private PokerHand removeAndReplace(PokerHand hand, ArrayList<Card> cardsToReplace) {
	
		int numCards = cardsToReplace.size();
		int i = 0;
		while(i<numCards){
			Card card = cardsToReplace.get(i);
			hand.getHand().remove(card);
			i++;
		}
		i=0;
		while(i<numCards){
			cardsToReplace.add(deck.dealCard());
			i++;
		}
		hand.getHand().addAll(cardsToReplace);
		PokerHand replacementHand = findBestHand(hand.getHand());
		return replacementHand;
	}

	

	

	
}
