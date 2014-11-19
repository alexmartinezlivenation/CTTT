package game;

//import java.io.IOException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import output.Output;
import output.impl.OutputConsole;
import player.AIPlayer;
import player.ConsolePlayer;
import player.Move;
import player.Player;
import score.Score;
import map.Map;


public class Game {
	public static void main(String[] args) {
		
		Map map = new Map();
		map.initializeMap(3);
		
		Score score = new Score();
		
		OutputConsole oc = new OutputConsole();
		ConsolePlayer player1 = new ConsolePlayer();
		Player player2;
		String gameMode = "";
		
		try {
			gameMode = initializeGame(oc);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		if (gameMode.equals("2")) {
			player2 = new ConsolePlayer();
		}
		else {
			player2 = new AIPlayer();
		}
		
		oc.drawMap(map);
		Move move = new Move();
		
		player1.setPersonalSymbol("x");
		player2.setPersonalSymbol("o");
		
		while (true) {
			if (score.isTie(map)) {
				break;
			}
			player1.makeMove(move);
			while (!map.updateMap(Integer.parseInt(move.getPosition()), move.getPlayer())) {
				oc.clearScreen();
				oc.drawMap(map);
				oc.writeToScreen("Choose your fate");
				player1.makeMove(move);
			}
			oc.clearScreen();
			oc.drawMap(map);
			oc.writeToScreen("Choose your fate");
			if (score.isWinConditionMet(map)) {
				oc.writeToScreen("Player 1 has won the game!");
				return;
			}
			score.setTurnCounter(score.getTurnCounter() + 1);
			
			if (score.isTie(map)) {
				break;
			}
			player2.makeMove(move);
			while(!map.updateMap(Integer.parseInt(move.getPosition()), move.getPlayer())) {
				oc.clearScreen();
				oc.drawMap(map);
				oc.writeToScreen("Choose your fate");
				player2.makeMove(move);
			}
			oc.clearScreen();
			oc.drawMap(map);
			oc.writeToScreen("Choose your fate");
			if (score.isWinConditionMet(map)) {
				oc.writeToScreen("Player 2 has won the game!");
				return;
			}
			score.setTurnCounter(score.getTurnCounter() + 1);
		}
		oc.writeToScreen("Game is a draw");
		
	}
	
	public static String initializeGame(Output oc) throws IOException {
		oc.writeToScreen("Please choose a game mode\n1.  Player vs. Computer\n2.  Player vs. Player");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		return br.readLine();
		
		/*if (gameMode.equals("2")) {
			oc.clearScreen();
			return "PVP";
		}
		else {
			oc.clearScreen();
			return "PVC";
		}*/
	}
}
