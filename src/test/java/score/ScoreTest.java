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
	public void testIsWinConditionMet() {
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
		
	}

}
