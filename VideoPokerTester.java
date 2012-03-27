import java.util.Scanner;
public class VideoPokerTester {

	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int again = 1;
		while (again == 1) { //as long as the user wants to keep playing
		Game game=new Game(); //starting new game.
		game.play(); //calling play method
		
		System.out.println();
		System.out.println("Would you like to play again?(1 - yes/0 - no)");
		again = input.nextInt(); //integer entered determines if we play or break out of loop
		}
		
		System.out.println("Thank you for playing!");

	}

}
