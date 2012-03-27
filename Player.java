import java.util.ArrayList;
import java.util.Scanner;

public class Player {
	
	private ArrayList<Card> hand = new ArrayList<Card>(); // user's hand is created as a blank array
	private Scanner input = new Scanner(System.in);
	
	public Player() {
	
	}
	
	public void addCard(Card card) { //method for adding a card to hand array
		hand.add(card); 
		
		
	}
	
	public String toString() {
		String info = "";
		for(Card card : hand) {
			info += card.toString() + "\n"; //getting information of the cards only in the user's hand
		}
		return info;
		
	}

	public void rejectCards() {
		int reject;
		String rejected = ""; //Rejected card numbers will be taken as a string
		System.out.println("Would you like to reject any cards? (1-yes/0-no)");
		reject = input.nextInt();
		
		if (reject ==1) {
			System.out.println("Which card(s) would you like to reject? example: (13) rejects your first and third cards");
			rejected = input.next();
			
		}
		
		replace(rejected); //calls method for replacing cards
	}
	
	private void replace(String rejected) {
		if (!rejected.equals("")) { //if the rejected string is not empty
			for (int j=0; j<rejected.length(); j++) {//the length condition allows us to replace the number 
													 //of cards the user rejected.
				int cardToRemove=Integer.parseInt(rejected.substring(j, j+1)); 
				Card card = Game.deck.draw(); //static variable deck is used here. Draws a card from it.
				hand.set(cardToRemove-1,card); //replacing the rejected card with the new card at appropriate index.
			}
			System.out.println("Your new cards are\n");
			System.out.println(toString());	
			
			
		}
	}
	
	public String categorizeHand(){ //method for scoring hand
		for (int i = 0; i<5; i++){ // nested for loops are part of sorting the hand
			for (int j = 0; j<4; j++) {
				int compare = hand.get(j).compareTo(hand.get(j+1)); //compareTo is called. Compares values
				if (compare>0){ //will arrange cards in ascending order of values
					Card temp=hand.get(j);
					hand.set(j,hand.get(j+1));
					hand.set(j+1, temp);
				}
			}
		}
		boolean pair = false, twopair = false, // booleans that set each score to false.
				threeofakind = false,straight = false,flush = false,
				fullhouse = false, fourofakind = false, straightflush = false, 
				royalflush = false;
				
		for (int k = 0; k<4; k++) { //primary for loop. Will go through each of the five cards
			
			if (hand.get(k).getValue() == hand.get(k+1).getValue() //criteria for pair
					&& (k-1<0||hand.get(k-1).getValue()!=hand.get(k).getValue()) // boundary conditions for just being pair.
					&& (k+2>4||hand.get(k+2).getValue()!=hand.get(k).getValue())) {
				if (pair == true) {
					twopair = true; //since we have a loop. this will be true if pair is true twice.
					
				}
				
				pair = true;
			
			}
			
			if ((k<2) && hand.get(k).getValue() == hand.get(k+1).getValue() && hand.get(k+1).getValue() 
					== hand.get(k+2).getValue() && hand.get(k+2) == hand.get(k+3)) {
				fourofakind = true; // hand with four cards of the same value.
			}
			
			if (!fourofakind && (k<3) && hand.get(k).getValue() == hand.get(k+1).getValue() 
					&& hand.get(k+1).getValue() == hand.get(k+2).getValue()) {
				threeofakind = true; //is a subset of four a kind. Three values must be the same.
				
			}
			if ((k<1) && (hand.get(k+4).getValue()==12 && hand.get(k).getValue()==0|| //checking to see if we have an ace 
					hand.get(k).getValue() + 1 == hand.get(k+1).getValue()) 		  // and king (special case).
					&& hand.get(k+1).getValue() +1 == hand.get(k+2).getValue() && //checks for consecutive values.
					hand.get(k+2).getValue() +1 == hand.get(k+3).getValue() &&
					hand.get(k+3).getValue() +1 == hand.get(k+4).getValue()) {
				
				straight=true;
			}
			if ((k<1) && hand.get(k).getSuit() == hand.get(k+1).getSuit() && //compares suit values. 
				hand.get(k+1).getSuit() == hand.get(k+2).getSuit() &&
				hand.get(k+2).getSuit() == hand.get(k+3).getSuit() &&
				hand.get(k+3).getSuit() == hand.get(k+4).getSuit()) {
			
				flush = true; // is true if the suit values of each card is same.
				if (straight == true) {
					straightflush = true; // will be true if straight is true since flush will already be true.
						royalflush = hand.get(0).getValue() == 0 && hand.get(1).getValue() == 9;
					 
					//royal flush is special case. If first card in sorted hand is ace
					//and second card is 10 and since straight flush is true, we have 
					//royal flush is true.
						
					} 
				
			}
		}
		
		fullhouse= threeofakind & pair; //only true if pair and three of a kind are true.
	
		//Hierarchy ensures that only the highest hand is scored.
		if (royalflush)
			return "You have a Royal Flush!!";
		if (straightflush)
			return "You have a Straight Flush!!";
		if (fourofakind)
			return "You have a Four of a Kind!!";
		if (fullhouse)
			return "You have a Full House!!";
		if (flush)
			return "You have a Flush!!";
		if (straight)
			return "You have a Straight!!";
		if (threeofakind)
			return "You have a Three of a Kind!";
		if (twopair)
			return "You have Two Pairs!";
		if (pair)
			return "You have One Pair!";
		else
			return "You have No Pair";
	
	}
}
