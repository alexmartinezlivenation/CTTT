package score;

import static org.junit.Assert.*;

import map.Map;

import org.junit.Test;

public class ScoreTest {
	Map testMap = new Map();
	Score testScore = new Score();

	@Test
	public void testIsWinConditionMet() {
		assertNotNull(testScore);
		
		testMap.initializeMap(3);
		assertFalse(testScore.isWinConditionMet(testMap));
		
		testMap.setMapField(new String[] {	"o","1","2",
											"o","4","5",
											"o","7","8"});
		assertTrue(testScore.isWinConditionMet(testMap));
		
		testMap.setMapField(new String[] {	"x","x","x",
											"3","4","5",
											"6","7","8"});
		assertTrue(testScore.isWinConditionMet(testMap));
		
		testMap.setMapField(new String[] {	"0","1","x",
											"3","4","x",
											"6","7","x"});
		assertTrue(testScore.isWinConditionMet(testMap));
		
		testMap.setMapField(new String[] {	"0","1","2",
											"3","4","5",
											"x","x","x"});
		assertTrue(testScore.isWinConditionMet(testMap));
		
		testMap.setMapField(new String[] {	"0","1","x",
											"3","x","5",
											"x","7","8"});
		assertTrue(testScore.isWinConditionMet(testMap));

		testMap.setMapField(new String[] {	"x","1","2",
											"3","x","5",
											"6","7","x"});
		assertTrue(testScore.isWinConditionMet(testMap));
		
		testMap.setMapField(new String[] {	"0","1","2",
											"x","x","x",
											"6","7","8"});
		assertTrue(testScore.isWinConditionMet(testMap));

		testMap.setMapField(new String[] {	"0","x","2",
											"3","x","5",
											"6","x","8"});
		assertTrue(testScore.isWinConditionMet(testMap));
	}

}
