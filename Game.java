

public class Game {
		
		private Player user; 
		public static Deck deck; // allows this variable to be used in other parts of the program.
								 // Necessary for replacement of cards- as it must come from this 
								// specific deck.
		
		public Game() {
			user = new Player();
			deck = new Deck();
		}
		
		public void play() {
			for(int i = 0; i<5; i++) { // drawing 5 cards
				Card card = deck.draw();
				user.addCard(card); //adds a card to the array hand (in player class)
			}
			
			System.out.println("Your cards are\n");
			System.out.println(user.toString()); //shows user initial cards
			
			user.rejectCards();	// carries out method in player class if user rejects cards.
			
			System.out.println();
			
			System.out.println(user.categorizeHand()); //Scores the user's hand.
		}
		
		
			
		
		
		
			
			
		

}
