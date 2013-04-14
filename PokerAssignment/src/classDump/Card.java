package classDump;

public class Card {
	private final int cardValue;
	private final String cardSuit;
	
	public Card(int cardValue, String cardSuit){
		this.cardValue = cardValue;
		this.cardSuit = cardSuit;
	}
	
	public final int getCardValue() {
		return cardValue;
	}
	public final String getCardSuit() {
		return cardSuit;
	}
	
	
}
