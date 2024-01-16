package ticTacToe;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {
	String[][] grid = new String[3][3];
	int rowNumber;
	int columnNumber;
	String markSelected = "X";
	Scanner input;
	int gridMarks = 0;
	
	void displayWelcomeMessage() {
		System.out.println("Welcome to Tic Tac Toe");
	}
	
	void displayGrid() {
		System.out.println();
		System.out.println("+---+---+---+");
		String c1;
		String c2;
		String c3;
		for (int i = 0; i < grid[0].length; i++) {
			 c1 = grid[i][0] != null ? grid[i][0] : " ";
			 c2 = grid[i][1] != null ? grid[i][1] : " ";
			 c3 = grid[i][2] != null ? grid[i][2] : " ";
			 System.out.println("| " + c1 + " | " + c2 + " | " + c3 + " |");
			 System.out.println("+---+---+---+");
		}
	}
	
	void startGame(boolean toPlay) {
		for (int i = 0; i < grid[0].length; i++) {
			 Arrays.fill(grid[i], null);
		}
		gridMarks = 0;
		input = new Scanner(System.in);
		while(toPlay) {
			toPlay = takeTurn();
		}
		input.close();
	}
	
	boolean takeTurn() {
		boolean res = true;
		try {
			System.out.println(markSelected + "'s turn");
			System.out.print("Pick a row (1, 2, 3):  ");
			rowNumber = input.nextInt() - 1;
			System.out.print("Pick a column (1, 2, 3):  ");
			columnNumber = input.nextInt() - 1;
		}
		catch(Exception e) {
			System.out.println(e);
			System.out.println("Try again.");
			return false;
		}
		
		if(rowNumber > 2 || rowNumber < 0 || columnNumber > 2 || columnNumber < 0) {
			System.out.println("try again with 1, 2, or 3.");
			return res;
		}
		if (grid[rowNumber][columnNumber] != null) {
			System.out.println("That square is already taken, pick again.\n");
			return res;
		}
		else {
			grid[rowNumber][columnNumber] = markSelected;
			gridMarks += 1;
		}
		displayGrid();
		if (checkForWinner()) {
			System.out.println(markSelected + " wins!");
			markSelected = markSelected == "X" ? "O" : "X";
			return false;
		}
		if (gridMarks == 9) {
			System.out.println("It's a tie!");
			res = false;
		}
		markSelected = markSelected == "X" ? "O" : "X";
		return res;
	}
	
	boolean checkForWinner() {
		//check for diagonal wins
		if (grid[0][0] == "X" && grid[1][1] == "X"&& grid[2][2] == "X") {
			return true;
		}
		else if (grid[0][0] == "O" && grid[1][1] == "O"&& grid[2][2] == "O") {
			return true;
		}
		else if (grid[0][2] == "O" && grid[1][1] == "O"&& grid[2][0] == "O") {
			return true;
		}
		else if (grid[0][2] == "X" && grid[1][1] == "X"&& grid[2][0] == "X") {
			return true;
		}
		//check for vertical wins
		else if (grid[0][0] == "X" && grid[1][0] == "X"&& grid[2][0] == "X") {
			return true;
		}
		else if (grid[0][1] == "X" && grid[1][1] == "X"&& grid[2][1] == "X") {
			return true;
		}
		else if (grid[0][2] == "X" && grid[1][2] == "X"&& grid[2][2] == "X") {
			return true;
		}
		else if (grid[0][0] == "O" && grid[1][0] == "O"&& grid[2][0] == "O") {
			return true;
		}
		else if (grid[0][1] == "O" && grid[1][1] == "O"&& grid[2][1] == "O") {
			return true;
		}
		else if (grid[0][2] == "O" && grid[1][2] == "O"&& grid[2][2] == "O") {
			return true;
		}
		//check for horizontal wins
		for (int i = 0; i < grid.length; i++) {
			if (Arrays.asList(grid[i]).stream().allMatch(val -> val == "X") || Arrays.asList(grid[i]).stream().allMatch(val -> val == "O")) {
				return true;
			}
		}
		return false;
	}
	
}
