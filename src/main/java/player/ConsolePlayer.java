package player;

import java.util.Scanner;

import map.Map;

public class ConsolePlayer implements Player {

	private String personalSymbol;
	private Move move;
	
	/*public void makeMove(Move move) {
		String input;
		Scanner in = new Scanner(System.in);
		input = in.nextLine();
		
		move.setPlayer(personalSymbol);
		move.setPosition(input);
	}*/
	
	public boolean makeMove(Map map) {
		move = new Move();
		String input;
		Scanner in = new Scanner(System.in);
		input = in.nextLine();
		
		move.setPlayer(personalSymbol);
		move.setPosition(input);
		
		return map.updateMap(Integer.parseInt(move.getPosition()), move.getPlayer());
	}

	public String getPersonalSymbol() {
		return personalSymbol;
	}

	public void setPersonalSymbol(String personalSymbol) {
		this.personalSymbol = personalSymbol;
	}
}
