package game;

//import java.io.IOException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import output.Output;
import output.impl.OutputConsole;
import player.AIPlayer;
import player.ConsolePlayer;
import player.DifficultAIPlayer;
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
			gameMode = initializeGame(oc,"Please choose a game mode\n1.  Player vs. Computer\n2.  Player vs. Player");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		if (gameMode.equals("2")) {
			player2 = new ConsolePlayer();
		}
		else {
			try {
				gameMode = initializeGame(oc,"Please choose a difficulty\n1.  Difficult\n2.  Easy");
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			if (gameMode.equals("2")) {
				player2 = new AIPlayer();
			}
			else {
				player2 = new DifficultAIPlayer();
				//player2.setReferenceMap(map);
			}
		}
		
		oc.drawMap(map);
		//Move move = new Move();
		
		player1.setPersonalSymbol("x");
		player2.setPersonalSymbol("o");
		
		oc.writeToScreen("Choose your fate");
		
		while (true) {
			if (score.isTie(map)) {
				break;
			}
			if (!continueGame(player1, oc, map, score)) {
				oc.writeToScreen("Player 1 has won the game!");
				return;
			}
			
			if (score.isTie(map)) {
				break;
			}
			if (!continueGame(player2, oc, map, score)) {
				oc.writeToScreen("Player 2 has won the game!");
				return;
			}
		}
		
		/*while (true) {
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
			if (score.isWinConditionMet(map)) {
				oc.writeToScreen("Player 1 has won the game!");
				return;
			}
			oc.writeToScreen("Choose your fate");
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
			if (score.isWinConditionMet(map)) {
				oc.writeToScreen("Player 2 has won the game!");
				return;
			}
			oc.writeToScreen("Choose your fate");
			score.setTurnCounter(score.getTurnCounter() + 1);
		}*/
		
		oc.clearScreen();
		oc.drawMap(map);
		oc.writeToScreen("Game is a draw");
		
	}
	
	private static boolean continueGame(Player player, Output oc, Map map, Score score) {
		
		while (!player.makeMove(map)) {
			oc.clearScreen();
			oc.drawMap(map);
			oc.writeToScreen("Choose your fate");
		}
		oc.clearScreen();
		oc.drawMap(map);
		if (score.isWinConditionMet(map)) {
			return false;
		}
		oc.writeToScreen("Choose your fate");
		score.setTurnCounter(score.getTurnCounter() + 1);
		return true;
	}
	
	private static String initializeGame(Output oc, String message) throws IOException {
		oc.writeToScreen(message);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		return br.readLine();

	}
}
