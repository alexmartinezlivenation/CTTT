package score;

import static org.junit.Assert.*;

import map.BoardInterface;
import map.Board;
import map.BoardViewer;

import org.junit.Test;
import player.Move;

public class ScoreTest {
	BoardInterface testMap = new Board();
	BoardViewer testView = new BoardViewer();
	Score testScore = new Score();

	@Test
	public void testRowWin() {
		assertNotNull(testScore);

        //test for a single row
		testMap.initializeBoard(3);
		testView.setViewedBoard(testMap);
		assertFalse(testScore.isWinConditionMet(testView));

        Move moveX = new Move();
        moveX.setPlayer("x");
        moveX.setPosition("0");
        testView.updateBoard(moveX);
        assertFalse(testScore.isWinConditionMet(testView));

        moveX.setPosition("1");
        testView.updateBoard(moveX);
        assertFalse(testScore.isWinConditionMet(testView));

        moveX.setPosition("2");
        testView.updateBoard(moveX);
        assertTrue(testScore.isWinConditionMet(testView));

        //test for a full row with mixed symbols

        testMap.initializeBoard(3);
        testView = new BoardViewer();
        testView.setViewedBoard(testMap);
        assertFalse(testScore.isWinConditionMet(testView));

        Move moveO = new Move();
        moveO.setPlayer("o");
        moveO.setPosition("0");
        testView.updateBoard(moveO);
        assertFalse(testScore.isWinConditionMet(testView));

        moveX.setPosition("1");
        testView.updateBoard(moveX);
        assertFalse(testScore.isWinConditionMet(testView));

        moveO.setPosition("2");
        testView.updateBoard(moveO);
        assertFalse(testScore.isWinConditionMet(testView));

        //the weird case
        testMap.initializeBoard(3);
        testView = new BoardViewer();
        testView.setViewedBoard(testMap);
        assertFalse(testScore.isWinConditionMet(testView));

        moveX.setPosition("4");
        testView.updateBoard(moveX);
        assertFalse(testScore.isWinConditionMet(testView));

        moveO.setPosition("5");
        testView.updateBoard(moveO);
        assertFalse(testScore.isWinConditionMet(testView));

        moveX.setPosition("1");
        testView.updateBoard(moveX);
        assertFalse(testScore.isWinConditionMet(testView));

        moveO.setPosition("8");
        testView.updateBoard(moveO);
        assertFalse(testScore.isWinConditionMet(testView));

        moveX.setPosition("2");
        testView.updateBoard(moveX);
        assertFalse(testScore.isWinConditionMet(testView));

        moveO.setPosition("3");
        testView.updateBoard(moveO);
        assertFalse(testScore.isWinConditionMet(testView));

        moveX.setPosition("0");
        testView.updateBoard(moveX);
        assertTrue(testScore.isWinConditionMet(testView));

        //the second weird case
        testMap.initializeBoard(3);
        testView = new BoardViewer();
        testView.setViewedBoard(testMap);
        assertFalse(testScore.isWinConditionMet(testView));

        moveX.setPosition("4");
        testView.updateBoard(moveX);
        assertFalse(testScore.isWinConditionMet(testView));

        moveO.setPosition("2");
        testView.updateBoard(moveO);
        assertFalse(testScore.isWinConditionMet(testView));

        moveX.setPosition("0");
        testView.updateBoard(moveX);
        assertFalse(testScore.isWinConditionMet(testView));

        moveO.setPosition("5");
        testView.updateBoard(moveO);
        assertFalse(testScore.isWinConditionMet(testView));

        moveX.setPosition("1");
        testView.updateBoard(moveX);
        assertFalse(testScore.isWinConditionMet(testView));

        moveO.setPosition("7");
        testView.updateBoard(moveO);
        assertFalse(testScore.isWinConditionMet(testView));


        //moveX.setPosition("6");
        //testView.updateBoard(moveX);
        //assertTrue(testScore.isWinConditionMet(testView));
		
	}

    @Test
    public void testColumnWin() {
        //test for a single column
        testMap.initializeBoard(3);
        testView.setViewedBoard(testMap);
        assertFalse(testScore.isWinConditionMet(testView));

        Move moveX = new Move();
        moveX.setPlayer("x");
        moveX.setPosition("0");
        testView.updateBoard(moveX);
        assertFalse(testScore.isWinConditionMet(testView));

        moveX.setPosition("3");
        testView.updateBoard(moveX);
        assertFalse(testScore.isWinConditionMet(testView));

        moveX.setPosition("6");
        testView.updateBoard(moveX);
        assertTrue(testScore.isWinConditionMet(testView));

        //test for a full column with mixed symbols

        testMap.initializeBoard(3);
        testView = new BoardViewer();
        testView.setViewedBoard(testMap);
        assertFalse(testScore.isWinConditionMet(testView));

        Move moveO = new Move();
        moveO.setPlayer("o");
        moveO.setPosition("1");
        testView.updateBoard(moveO);
        assertFalse(testScore.isWinConditionMet(testView));

        moveX.setPosition("4");
        testView.updateBoard(moveX);
        assertFalse(testScore.isWinConditionMet(testView));

        moveO.setPosition("7");
        testView.updateBoard(moveO);
        assertFalse(testScore.isWinConditionMet(testView));
    }

    @Test
    public void testDiagonalWin() {
        //test for a single diagonal
        testMap.initializeBoard(3);
        testView.setViewedBoard(testMap);
        assertFalse(testScore.isWinConditionMet(testView));

        Move moveX = new Move();
        moveX.setPlayer("x");
        moveX.setPosition("0");
        testView.updateBoard(moveX);
        assertFalse(testScore.isWinConditionMet(testView));

        moveX.setPosition("4");
        testView.updateBoard(moveX);
        assertFalse(testScore.isWinConditionMet(testView));

        moveX.setPosition("8");
        testView.updateBoard(moveX);
        assertTrue(testScore.isWinConditionMet(testView));


        testMap.initializeBoard(3);
        testView = new BoardViewer();
        testView.setViewedBoard(testMap);
        assertFalse(testScore.isWinConditionMet(testView));

        moveX.setPosition("6");
        testView.updateBoard(moveX);
        assertFalse(testScore.isWinConditionMet(testView));

        moveX.setPosition("4");
        testView.updateBoard(moveX);
        assertFalse(testScore.isWinConditionMet(testView));

        moveX.setPosition("2");
        testView.updateBoard(moveX);
        assertTrue(testScore.isWinConditionMet(testView));

        //test for a full diagonal with mixed symbols

        testMap.initializeBoard(3);
        testView = new BoardViewer();
        testView.setViewedBoard(testMap);
        assertFalse(testScore.isWinConditionMet(testView));

        Move moveO = new Move();
        moveO.setPlayer("o");
        moveO.setPosition("0");
        testView.updateBoard(moveO);
        assertFalse(testScore.isWinConditionMet(testView));

        moveX.setPosition("4");
        testView.updateBoard(moveX);
        assertFalse(testScore.isWinConditionMet(testView));

        moveO.setPosition("8");
        testView.updateBoard(moveO);
        assertFalse(testScore.isWinConditionMet(testView));
    }

}
