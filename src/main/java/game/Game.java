package game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import map.BoardInterface;
import output.Output;
import output.OutputImpl;
import output.impl.ConsoleDisplay;
import player.AIPlayer;
import player.HumanPlayer;
import player.DifficultAIPlayer;
import player.Player;
import player.impl.PlayerConsole;
import score.Score;
import map.Board;
import map.BoardViewer;


public class Game {
	public static void main(String[] args) {		
		BoardInterface board = new Board();
		BoardViewer boardViewer = new BoardViewer();
		board.initializeBoard(3);
		boardViewer.setViewedBoard(board);
		
		Score score = new Score();
		
		Output oc = new OutputImpl(new ConsoleDisplay());
		Player player1 = new HumanPlayer(new PlayerConsole());
		Player player2;
		String gameMode = "";
		
		try {
			gameMode = initializeGame(oc,"Please choose a game mode\n1.  Player vs. Computer\n2.  Player vs. Player");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		if (gameMode.equals("2")) {
			player2 = new HumanPlayer(new PlayerConsole());
		}
		else {
			try {
				gameMode = initializeGame(oc,"Please choose a difficulty\n1.  Difficult\n2.  Easy");
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			if (gameMode.equals("2")) {
				player2 = new AIPlayer(new PlayerConsole());
			}
			else {
				player2 = new DifficultAIPlayer(new PlayerConsole());
				//player2.setReferenceBoard(board);
			}
		}
		
		oc.drawBoard(boardViewer);
		//Move move = new Move();
		
		player1.setPersonalSymbol("x");
		player2.setPersonalSymbol("o");
		
		oc.writeToScreen("Choose your fate");

        score.setTurnCounter(0);
		
		while (true) {
			if (score.isTie(boardViewer)) {
				break;
			}
			if (!continueGame(player1, oc, boardViewer, score)) {
				oc.writeToScreen("Player 1 has won the game!");
				return;
			}
			
			if (score.isTie(boardViewer)) {
				break;
			}
			if (!continueGame(player2, oc, boardViewer, score)) {
				oc.writeToScreen("Player 2 has won the game!");
				return;
			}
		}
		
		oc.clearScreen();
		oc.drawBoard(boardViewer);
		oc.writeToScreen("Game is a draw");
		
	}
	
	private static boolean continueGame(Player player, Output oc, BoardViewer board, Score score) {
		
		while (!player.makeMove(board)) {
			oc.clearScreen();
			oc.drawBoard(board);
			oc.writeToScreen("Choose your fate");
		}
		oc.clearScreen();
		oc.drawBoard(board);
		if (score.isWinConditionMet(board)) {
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
