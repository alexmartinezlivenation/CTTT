package player;

import java.util.Scanner;

import map.MapViewer;

public class ConsolePlayer implements Player {

	private String personalSymbol;
	private Move move;
	
	public boolean makeMove(MapViewer map) {
		move = new Move();
		String input;
		Scanner in = new Scanner(System.in);
		input = in.nextLine();
		
		move.setPlayer(personalSymbol);
		move.setPosition(input);
		
		return map.updateMap(move);
	}

	public String getPersonalSymbol() {
		return personalSymbol;
	}

	public void setPersonalSymbol(String personalSymbol) {
		this.personalSymbol = personalSymbol;
	}
}
