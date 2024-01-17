package guessingGame;
import java.util.Scanner;

public class GuessNumberApp {
	
	public static void main (String args[]) {
		Game game = new Game();
		char toPlay = 'y';
		Scanner input = new Scanner(System.in);
		
		game.displayWelcomeMessage();
		
		while(Character.toLowerCase(toPlay) != 'n') {
				game.generateNumberToBeGuessed();
				game.displayPleaseGuessMessage();
				
				boolean correct = false;
				String message = "";
				int guessDiff;
				int lastGuessDiff = 0;
				int guess;
				
				
				while(!correct) {
					System.out.print("Enter a number between 1 and 100:  ");
					guess = input.nextInt();
					game.makeGuess(guess);
					
					guessDiff = game.guessNumber - game.number;
					
					if (game.isCorrectGuess()) {
						if (game.counter <= 3) {
							message = "Great Work! You are a mathematecal wizard.";
						}
						else if (game.counter > 3 && game.counter < 8) {
							message = "Not too bad! You've got some potential.";
						} 
						else if (game.counter > 7) {
							message = "What took you so long.";
						}
						game.displayCorrectMessage(message);
						correct  = true;
						game.counter = 0;
						
					}
					else {
						if (guessDiff > 0 ) {
							message = "Too high! ";
						}
						else if (guessDiff < 0) {
							message = "Too low! ";
						}
						if (lastGuessDiff != 0) {
							if (Math.abs(guessDiff) > Math.abs(lastGuessDiff)) {
								message += "You're getting colder.";
							}
							else if (Math.abs(guessDiff) < Math.abs(lastGuessDiff)) {
								message += "You're getting warmer.";
							}
							else {
								message += "Same temp.";
							}
						}
						
						game.displayGuessAgainMessage(message);
					}
					lastGuessDiff = guessDiff;
				}
				
				System.out.print("Try again? (y/n):  ");
				toPlay = input.next().charAt(0);
				System.out.println();
				
		}
		System.out.println("Bye - Come back soon!");
		input.close();
	}
}
