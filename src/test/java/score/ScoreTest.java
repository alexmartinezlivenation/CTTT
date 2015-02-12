package score;

import static org.junit.Assert.*;

import map.Map;
import map.MapViewer;

import org.junit.Test;
import player.Move;

public class ScoreTest {
	Map testMap = new Map();
	MapViewer testView = new MapViewer();
	Score testScore = new Score();

	@Test
	public void testRowWin() {
		assertNotNull(testScore);

        //test for a single row
		testMap.initializeMap(3);
		testView.setViewedMap(testMap);
		assertFalse(testScore.isWinConditionMet(testView));

        Move moveX = new Move();
        moveX.setPlayer("x");
        moveX.setPosition("0");
        testView.updateMap(moveX);
        assertFalse(testScore.isWinConditionMet(testView));

        moveX.setPosition("1");
        testView.updateMap(moveX);
        assertFalse(testScore.isWinConditionMet(testView));

        moveX.setPosition("2");
        testView.updateMap(moveX);
        assertTrue(testScore.isWinConditionMet(testView));

        //test for a full row with mixed symbols

        testMap.initializeMap(3);
        testView = new MapViewer();
        testView.setViewedMap(testMap);
        assertFalse(testScore.isWinConditionMet(testView));

        Move moveO = new Move();
        moveO.setPlayer("o");
        moveO.setPosition("0");
        testView.updateMap(moveO);
        assertFalse(testScore.isWinConditionMet(testView));

        moveX.setPosition("1");
        testView.updateMap(moveX);
        assertFalse(testScore.isWinConditionMet(testView));

        moveO.setPosition("2");
        testView.updateMap(moveO);
        assertFalse(testScore.isWinConditionMet(testView));

        //the weird case
        testMap.initializeMap(3);
        testView = new MapViewer();
        testView.setViewedMap(testMap);
        assertFalse(testScore.isWinConditionMet(testView));

        moveX.setPosition("4");
        testView.updateMap(moveX);
        assertFalse(testScore.isWinConditionMet(testView));

        moveO.setPosition("5");
        testView.updateMap(moveO);
        assertFalse(testScore.isWinConditionMet(testView));

        moveX.setPosition("1");
        testView.updateMap(moveX);
        assertFalse(testScore.isWinConditionMet(testView));

        moveO.setPosition("8");
        testView.updateMap(moveO);
        assertFalse(testScore.isWinConditionMet(testView));

        moveX.setPosition("2");
        testView.updateMap(moveX);
        assertFalse(testScore.isWinConditionMet(testView));

        moveO.setPosition("3");
        testView.updateMap(moveO);
        assertFalse(testScore.isWinConditionMet(testView));

        moveX.setPosition("0");
        testView.updateMap(moveX);
        assertTrue(testScore.isWinConditionMet(testView));
		
	}

    @Test
    public void testColumnWin() {
        //test for a single column
        testMap.initializeMap(3);
        testView.setViewedMap(testMap);
        assertFalse(testScore.isWinConditionMet(testView));

        Move moveX = new Move();
        moveX.setPlayer("x");
        moveX.setPosition("0");
        testView.updateMap(moveX);
        assertFalse(testScore.isWinConditionMet(testView));

        moveX.setPosition("3");
        testView.updateMap(moveX);
        assertFalse(testScore.isWinConditionMet(testView));

        moveX.setPosition("6");
        testView.updateMap(moveX);
        assertTrue(testScore.isWinConditionMet(testView));

        //test for a full column with mixed symbols

        testMap.initializeMap(3);
        testView = new MapViewer();
        testView.setViewedMap(testMap);
        assertFalse(testScore.isWinConditionMet(testView));

        Move moveO = new Move();
        moveO.setPlayer("o");
        moveO.setPosition("1");
        testView.updateMap(moveO);
        assertFalse(testScore.isWinConditionMet(testView));

        moveX.setPosition("4");
        testView.updateMap(moveX);
        assertFalse(testScore.isWinConditionMet(testView));

        moveO.setPosition("7");
        testView.updateMap(moveO);
        assertFalse(testScore.isWinConditionMet(testView));
    }

    @Test
    public void testDiagonalWin() {
        //test for a single diagonal
        testMap.initializeMap(3);
        testView.setViewedMap(testMap);
        assertFalse(testScore.isWinConditionMet(testView));

        Move moveX = new Move();
        moveX.setPlayer("x");
        moveX.setPosition("0");
        testView.updateMap(moveX);
        assertFalse(testScore.isWinConditionMet(testView));

        moveX.setPosition("4");
        testView.updateMap(moveX);
        assertFalse(testScore.isWinConditionMet(testView));

        moveX.setPosition("8");
        testView.updateMap(moveX);
        assertTrue(testScore.isWinConditionMet(testView));


        testMap.initializeMap(3);
        testView = new MapViewer();
        testView.setViewedMap(testMap);
        assertFalse(testScore.isWinConditionMet(testView));

        moveX.setPosition("6");
        testView.updateMap(moveX);
        assertFalse(testScore.isWinConditionMet(testView));

        moveX.setPosition("4");
        testView.updateMap(moveX);
        assertFalse(testScore.isWinConditionMet(testView));

        moveX.setPosition("2");
        testView.updateMap(moveX);
        assertTrue(testScore.isWinConditionMet(testView));

        //test for a full diagonal with mixed symbols

        testMap.initializeMap(3);
        testView = new MapViewer();
        testView.setViewedMap(testMap);
        assertFalse(testScore.isWinConditionMet(testView));

        Move moveO = new Move();
        moveO.setPlayer("o");
        moveO.setPosition("0");
        testView.updateMap(moveO);
        assertFalse(testScore.isWinConditionMet(testView));

        moveX.setPosition("4");
        testView.updateMap(moveX);
        assertFalse(testScore.isWinConditionMet(testView));

        moveO.setPosition("8");
        testView.updateMap(moveO);
        assertFalse(testScore.isWinConditionMet(testView));
    }

}
