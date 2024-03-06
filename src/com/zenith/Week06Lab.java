// This is Tic-Tac-Fucking-Toe, bitches
package com.zenith;

import java.io.Console;
import java.util.Scanner;

public class Week06Lab {

	public static void main(String[] args) {
		
		boolean newGame = true;
		int xWins = 0;
		int oWins = 0;
		
		
		while (newGame == true) {
//		Initialize game
		Gameboard game = new Gameboard();
		boolean isGameOver = false;
		
		System.out.println("Welcome to Tic-Tac-Toe!");
		System.out.println("Instructions: type your move (1-9) and hit enter. X goes first."
				+ " Type \"guide\" to see number layout guide.\n\n");
		
		game.draw();
		
		Scanner sc = new Scanner(System.in);
		// TODO: add invalid input detection
		// TODO: add protection from overwriting previous moves
		
		
			// TODO: fix game loop logic, add while not gameOver
			while (isGameOver == false) {
			
		
				String input = sc.next();
				boolean validInput = game.validateInput(input);
				
				if (validInput == false) {
					System.out.println("Please enter 1-9, \"guide\", or \"board\"" + "\nIt is "
							+ game.getPlayer() + "'s turn.");
				} else {
				
				game.getTurnCount();
				game.update(input);
				game.checkGameOver();
				
				
				
				if (game.checkGameOver() == false) {
					System.out.println(game.getPlayer() + " picks position " + input + ". Next person's turn!");
					game.nextTurn();
					game.setTurnCount(game.getTurnCount() + 1);
					game.draw();
				}
				
				if (game.checkGameOver() == true) {
					isGameOver = true;
					String winner = game.getWinner();
					if (winner.equals("X")) {
						xWins++;
					}
					if (winner.equals("O")) {
						oWins++;
					}
					if (winner.equals("draw")) {
						System.out.println("Game over! It's a draw!");
					} else {
					System.out.println("Game over! " + winner + " wins!");
					System.out.println("X wins: " + xWins + "   |   O wins: " + oWins);
					}
					System.out.println("\n\nPlay again? press any key or y/n");
					input = sc.next();
					if (input.equals("n")) {
						System.out.print("Thanks for playing!");
						newGame = false;
						sc.close();
					} else {
						System.out.print("\n\n\n\n\n\n");  
					}
					
					
				}
				
				}
				
			}
			
			
		}
		
		
//		sc.close();
	}

}