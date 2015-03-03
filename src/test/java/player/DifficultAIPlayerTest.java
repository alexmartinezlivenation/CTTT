package player;

import static org.junit.Assert.*;

import map.Board;
import map.BoardViewer;

import org.junit.Test;
import player.impl.PlayerConsole;

public class DifficultAIPlayerTest {
	DifficultAIPlayer ai = new DifficultAIPlayer(new PlayerConsole());
	Board board = new Board();
	BoardViewer boardViewer = new BoardViewer();
	
	@Test
	public void testmakeMove() {
		board.initializeBoard(3);
		boardViewer.setViewedBoard(board);
		ai.setPersonalSymbol("o");
//		
//		//test for correct horizontal win moves
        Move playerO = new Move();
        playerO.setPlayer("o");

        playerO.setPosition("0");
        boardViewer.updateBoard(playerO);
        playerO.setPosition("2");
        boardViewer.updateBoard(playerO);

        assertTrue(ai.makeMove(boardViewer));
        assertTrue(boardViewer.getBoard().containsKey("1"));


        playerO.setPosition("4");
        boardViewer.updateBoard(playerO);
        playerO.setPosition("5");
        boardViewer.updateBoard(playerO);

        assertTrue(ai.makeMove(boardViewer));
        assertTrue(boardViewer.getBoard().containsKey("3"));


        playerO.setPosition("6");
        boardViewer.updateBoard(playerO);
        playerO.setPosition("7");
        boardViewer.updateBoard(playerO);

        assertTrue(ai.makeMove(boardViewer));
        assertTrue(boardViewer.getBoard().containsKey("8"));

        //test for correct vertical win moves
        board.initializeBoard(3);
        boardViewer.setViewedBoard(board);
        boardViewer.clearTables();

        playerO.setPosition("5");
        boardViewer.updateBoard(playerO);
        playerO.setPosition("8");
        boardViewer.updateBoard(playerO);

        assertTrue(ai.makeMove(boardViewer));
        assertTrue(boardViewer.getBoard().containsKey("2"));

	}
}
