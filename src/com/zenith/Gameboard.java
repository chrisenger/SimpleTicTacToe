package com.zenith;


public class Gameboard {

	
	private String[] exoh = {" ", " ", " ", " ", " ", " ", " ", " ", " "};
	private String player = "X";
	private int turnCount = 0;
	private boolean isGameOver = false;
	private String winner;
	
	// exohGetter
	public String[] getExoh() {
		return exoh;
	}
	// exohSetter
	public void setExoh(String[] exoh) {
		this.exoh = exoh;
	}
	
	// playerGetter
	public String getPlayer() {
		return player;
	}
	// playerSetter
	public void setPlayer(String player) {
		this.player = player;
	}
	
	// turnCount Getter
	public int getTurnCount() {
		return turnCount;
	}
	// turnCount Setter
	public void setTurnCount(int turnCount) {
		this.turnCount = turnCount;
	}
	
	// isGameOver Getter
	public boolean getIsGameOver() {
		return isGameOver;
	}
	// isGameOver Setter
	public void setIsGameOver(boolean isGameOver) {
		this.isGameOver = isGameOver;
	}
	// winner Getter
	public String getWinner() {
		return winner;
	}
	// winner Setter not implemented
	public void setWinner(String winner) {
		this.winner = winner;
	}
	
	
	// constructor
	public Gameboard() {
		
	}
	
	
	public void draw() {
	
		// first row
		System.out.println("    |   |");
		System.out.println("  " + exoh[0] + " | " + exoh[1] + " | " + exoh[2]);
		System.out.println("----|---|----");
		// second row
		System.out.println("  " + exoh[3] + " | " + exoh[4] + " | " + exoh[5]);
		System.out.println("----|---|----");
		// third row
		System.out.println("  " + exoh[6] + " | " + exoh[7] + " | " + exoh[8]);
		System.out.println("    |   |");
		
	}
	
	public String nextTurn() {
		
		if (player.equals("X")) {
			player = "O";
		} else {
			player = "X";
		}
		return player;
	}
	
	public boolean validateInput(String input) {
		
		int inputInt = -1;
		boolean isValidMove = true;
		
		switch(input) {
		case "guide":
			break;
		case "1":
			inputInt = 0;
			break;
		case "2":
			inputInt = 1;
			break;
		case "3":
			inputInt = 2;
			break;
		case "4":
			inputInt = 3;
			break;
		case "5":
			inputInt = 4;
			break;
		case "6":
			inputInt = 5;
			break;
		case "7":
			inputInt = 6;
			break;
		case "8":
			inputInt = 7;
			break;
		case "9":
			inputInt = 8;
			break;
		default:
			isValidMove = false;	
		}
		
		if (inputInt < 0 || inputInt > 8) {
			isValidMove = false;
		} else if (exoh[inputInt] == "X" || exoh[inputInt] == "O") {
			isValidMove = false;
			System.out.println("You can't do that.");
		}
		if (input.equals("guide")) {
			drawGuide();
		}
		if (input.equals("board")) {
			draw();
		}
		
		
		
		//TODO: Actual return statement
		return isValidMove;
	}
	
	
	public void update(String input) {
		
		switch(input) {
		case "1":
			exoh[0] = getPlayer();
			break;
		case "2":
			exoh[1] = getPlayer();
			break;
		case "3":
			exoh[2] = getPlayer();
			break;
		case "4":
			exoh[3] = getPlayer();
			break;
		case "5":
			exoh[4] = getPlayer();
			break;
		case "6":
			exoh[5] = getPlayer();
			break;
		case "7":
			exoh[6] = getPlayer();
			break;
		case "8":
			exoh[7] = getPlayer();
			break;
		case "9":
			exoh[8] = getPlayer();
			break;
		}
		
		
	}
	
	public boolean checkGameOver() {
		
/*
         to		+---+---+---+		+---+---+---+		+---+---+---+
	   find		|---|---|---|		| | | | | | |		| \ |   | / |
	   a win	+---+---+---+		+---+---+---+		+---+---+---+
	   look 	|---|---|---|	&	| | | | | | |   & 	|   | X |   |
	 at these	+---+---+---+		+---+---+---+		+---+---+---+
	8 patterns	|---|---|---|		| | | | | | |		| / |   | \ |
		        +---+---+---+		+---+---+---+		+---+---+---+ 		
 */
		
		boolean isGameOver = false;
		// check X row victories
		if (exoh[0].equals("X") && exoh[1].equals("X") && exoh[2].equals("X")) {
			isGameOver = true;
			winner = "X";
		} else if (exoh[3] == "X" && exoh[4] == "X" && exoh[5] == "X") {
			isGameOver = true;
			winner = "X";
		} else if (exoh[6] == "X" && exoh[7] == "X" && exoh[8] == "X") {
			isGameOver = true;
			winner = "X";
		} 
		// check X column victories
		else if (exoh[0] == "X" && exoh[3] == "X" && exoh[6] == "X") {
			isGameOver = true;
			winner = "X";
		} else if (exoh[1] == "X" && exoh[4] == "X" && exoh[7] == "X") {
			isGameOver = true;
			winner = "X";
		} else if (exoh[2] == "X" && exoh[5] == "X" && exoh[8] == "X") {
			isGameOver = true;
			winner = "X";
		}
		// check X diagonal victories
		else if (exoh[0] == "X" && exoh[4] == "X" && exoh[8] == "X") {
			isGameOver = true;
			winner = "X";
		} else if (exoh[2] == "X" && exoh[4] == "X" && exoh[6] == "X") {
			isGameOver = true;
			winner = "X";
		} 
		
		// check O row victories
		else if (exoh[0] == "O" && exoh[1] == "O" && exoh[2] == "O") {
			isGameOver = true;
			winner = "O";
		} else if (exoh[3] == "O" && exoh[4] == "O" && exoh[5] == "O") {
			isGameOver = true;
			winner = "O";
		} else if (exoh[6] == "O" && exoh[7] == "O" && exoh[8] == "O") {
			isGameOver = true;
			winner = "O";
		} 
		// check O column victories
		else if (exoh[0] == "O" && exoh[3] == "O" && exoh[6] == "O") {
			isGameOver = true;
			winner = "O";
		} else if (exoh[1] == "O" && exoh[4] == "O" && exoh[7] == "O") {
			isGameOver = true;
			winner = "O";
		} else if (exoh[2] == "O" && exoh[5] == "O" && exoh[8] == "O") {
			isGameOver = true;
			winner = "O";
		}
		// check O diagonal victories
		else if (exoh[0] == "O" && exoh[4] == "O" && exoh[8] == "O") {
			isGameOver = true;
			winner = "O";
		} else if (exoh[2] == "O" && exoh[4] == "O" && exoh[6] == "O") {
			isGameOver = true;
			winner = "O";
		} 		
		
		// check for stalemate
		
		int turnCount = getTurnCount();
		
		if (turnCount >= 9) {
			isGameOver = true;
			winner = "draw";
		}
		
		setWinner(winner);
		return isGameOver;
	}
	
	public void drawGuide() {
		
		// first row
		System.out.println("    |   |");
		System.out.println("  1 | 2 | 3");
		System.out.println("----|---|----");
		// second row
		System.out.println("  4 | 5 | 6");
		System.out.println("----|---|----");
		// third row
		System.out.println("  7 | 8 | 9");
		System.out.println("    |   |");
		
	}
	
	
}


/*

    |   |
  0 | 1 | 2
----|---|----
  3 | 4 | 5
----|---|----
  6 | 7 | 8
    |   |


       to		+---+---+---+		+---+---+---+		+---+---+---+
	   find		|---|---|---|		| | | | | | |		| \ |   | / |
	   a win	+---+---+---+		+---+---+---+		+---+---+---+
	   look 	|---|---|---|	&	| | | | | | |   & 	|   | X |   |
	 at these	+---+---+---+		+---+---+---+		+---+---+---+
	8 patterns	|---|---|---|		| | | | | | |		| / |   | \ |
		        +---+---+---+		+---+---+---+		+---+---+---+
		
		




*/