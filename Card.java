
public class Card implements Comparable<Card> { // Interface Comparable

		private int suit;
		private int value;
		private final static String[] suits = {"club","diamonds","hearts","spades"}; // final indicates that it cannot be changed 
		private final static String[] values = {"ace", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "jack", "queen", "king"};
												//Static indicates that the variable can be shared through the whole program
		
		public Card(int s, int v) { //Constructor initializes suit and value
			suit = s;
			value = v;
		}
		
		public int getSuit() { //method that returns suit integer
			return suit;
		}
		
		public int getValue() {
			return value;
		}
		
		public String toString() { //method that characterizes the card based on integers: suit and value
			String info = values[value] + " of " + suits[suit];	
			return info;
		}
		
		public int compareTo(Card other) { // method that allows cards to be compared to each other. Will help in sorting.
			if (this.getValue() > other.getValue())
					return 1;
			else if (this.getValue() < other.getValue())
					return -1;
			else
					return 0;
		}
		
	}


