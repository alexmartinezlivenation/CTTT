package player;

import java.util.Scanner;

public class ConsolePlayer implements Player {

	private String personalSymbol;
	
	public void makeMove(Move move) {
		String input;
		Scanner in = new Scanner(System.in);
		input = in.nextLine();
		
		move.setPlayer(personalSymbol);
		move.setPosition(input);
	}

	public String getPersonalSymbol() {
		return personalSymbol;
	}

	public void setPersonalSymbol(String personalSymbol) {
		this.personalSymbol = personalSymbol;
	}
}
