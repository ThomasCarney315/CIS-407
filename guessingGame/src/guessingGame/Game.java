package guessingGame;
import java.util.Random;

public class Game {
	int number;
	int guessNumber;
	int counter;
	
	void generateNumberToBeGuessed() {
		Random random = new Random();
		this.number = random.nextInt(100) + 1;
	}
	
	void displayWelcomeMessage() {
		System.out.println("Welcome to the Guess the Number Game");
		System.out.println("++++++++++++++++++++++++++++++++++++");
		System.out.println();
	}
	
	void displayPleaseGuessMessage() {
		System.out.println("I'm thinking of a number from 1 to 100.");
		System.out.println("Try to guess it.\n");
	}
	
	void makeGuess(int guess) {
		this.guessNumber = guess;
		this.counter++;
	}
	
	boolean isCorrectGuess() {
		return this.guessNumber == number;
	}
	
	void displayCorrectMessage() {
		System.out.println("You got it in " + counter + " tries.");
		System.out.println();
	}
	//overloaded to handle custom messages
	void displayCorrectMessage(String message) {
		System.out.println("You got it in " + counter + " tries.");
		System.out.println(message);
		System.out.println();
	}
	
	void displayGuessAgainMessage() {
		System.out.println("Guess again.");
		System.out.println();
	}
	//overloaded to handle custom messages
	void displayGuessAgainMessage(String message) {
		System.out.println(message);
		System.out.println();
	}
	
}
