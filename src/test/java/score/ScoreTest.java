package score;

import static org.junit.Assert.*;

import map.Map;

import org.junit.Test;

public class ScoreTest {
	Map testMap = new Map();
	Score testScore = new Score();

	@Test
	public void testIsWinConditionMet() {
		testMap.setMapField(new String[] {	" 0 | 1 | 2 ",
											"-----------",
											" 3 | 4 | 5 ",
											"-----------",
											" 6 | 7 | 8 "});
		
		assertNotNull(testScore);
		assertFalse(testScore.isWinConditionMet(testMap));
	}

}
