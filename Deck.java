import java.util.ArrayList; //allows us to use array lists
import java.util.Collections; // An abstract class

public class Deck {
	
	private ArrayList<Card> cards = new ArrayList<Card>(); // creating an initially empty array of cards
	
	public Deck() {
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 13; j++) {
				Card newCard = new Card(i, j);
				cards.add(newCard); //each card with a specific suit and value that is characterized by toSring
									// is added to the array. Thus, we get our deck.
			}
		}
		shuffle(); //method for shuffling deck
	}
	
	public void shuffle() {
		Collections.shuffle(cards); //Pre-written tool that works on an array such as cards.
	}								// randomly orders the cards. Equivalent to shuffling.
	
	public Card draw() { //method that is return type. Will return the card drawn.
		Card returnCard = cards.get(0);  //gets the first card of the array (after shuffling)
		cards.remove(0); //Also removes it from the array. Equivalent to discarding the card.
		return returnCard; 
		
		}
	}


