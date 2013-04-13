package classes;

import java.util.ArrayList;

import interfaces.Card;
import interfaces.IDealer;

public class UserInterface<T> {
	private ArrayList<?> cards;
	private String playingAgainst;
	
	
	private void setCards(ArrayList<?> arrayList) {
		this.cards = arrayList;	
	}

	
	public ArrayList<?> getCards() {
		return cards;
	}


	public String getPlayingAgainst() {
		return playingAgainst;
	}


	public void setPlayingAgainst(String playingAgainst) {
		this.playingAgainst = playingAgainst;
	}


	
	
	private void launch() {
		
		System.out.println("Play Poker with me. It's ace! Ace... geddit? Oh dear. Anyway, enter your name to begin:");
		setPlayingAgainst(System.console().readLine());
		System.out.println("Hello, " + getPlayingAgainst() + ", lets play Poker.");
		System.out.println("This is a simplified version, so if you would like to see the rules first, enter R, else to start playing enter P. If you want to exit the game enter -1");
		menu();
		
		
	}

	private void menu() {
		System.out.println("P to play, R to see the rules. Enter -1 to exit");
		String choice = System.console().readLine();
		if(choice.equalsIgnoreCase("R")){
			rules();
		}
		else if(choice.equalsIgnoreCase("P")){
			play();
		}
		else if(choice.equals("-1")){
			exit();
		}	
		else{	
			System.out.println("I'm sorry, I did not recognise that");
			menu();
		}
		
	}

	private void exit() {
		System.out.println("Goodbye!");
	}
//COUPLING WITH DEALER TO BE REMOVED
	private void play() {
		dealer = IDealer.newDealer();
		
		System.out.println("OK, I'll deal. You cards will show on the screen, but don't worry, I can't see them because I am behind the screen.");
		//DealerImpl dealer = new DealerImpl(); //don't like having to pass things to dealer
		String hand = dealer.deal(); //not sure I want the dealer to format string, its UI's job
		System.out.println("You: " + hand);
		System.out.println("Dealer: [] [] [] [] [] ");
		System.out.println("Do you want to discard any of your cards? If so, enter the card number of each card, separated  by a space"); 
		String str = System.console().readLine();
		hand = parseHand(hand, str);
		String replacements = dealer.replace();
		hand = parseHand(hand, replacements);
		System.out.println("Your new hand is " + hand + ", " + replacements);
		setCards(dealer.replace());
		System.out.println("I am going to discard " + cards);
		setCards(dealer.getHand());
		System.out.println("OK, I've got " + cards + ". What have you got?");
		String playersHand = System.console().readLine();
		System.out.println("hmmm, highly unlikely. I'll have to check your cards...");
		System.out.println(dealer.winner());
		System.out.println("Play again? (hit any key to continue)");
		System.console().readLine();
		menu();
	}


	private String cleanup(String readLine) {
		// TODO Auto-generated method stub
		return null;
	}

	private void rules() {
		//load pdf of assignment
		System.out.println("Enter P to play or -1 to exit");
		String choice = System.console().readLine();
		if(choice.equalsIgnoreCase("P")){
			play();
		}
		else if(choice.equals("-1")){
			exit();
		}	
		else{	
			System.out.println("I'm sorry, I did not recognise that");
			menu();
		}
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UserInterface<String> run = new UserInterface<String>();
		run.launch();
	}
}