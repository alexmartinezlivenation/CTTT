package player;

import static org.junit.Assert.*;

import map.Map;
import map.MapViewer;

import org.junit.Test;

public class DifficultAIPlayerTest {
	DifficultAIPlayer ai = new DifficultAIPlayer();
	Map map = new Map();
	MapViewer mapViewer = new MapViewer();
	
	@Test
	public void testMakeMove() {
		map.initializeMap(3);
		mapViewer.setViewedMap(map);
		ai.setPersonalSymbol("o");
		
		//test for correct horizontal moves
		map.updateMap(0, "o");
		map.updateMap(1, "o");
		assertTrue(ai.makeMove(mapViewer));
		assertArrayEquals(new String[] {"o","o","o",
										"3","4","5",
										"6","7","8"}, map.getMapField());
		
		map.initializeMap(3);
		map.updateMap(3, "o");
		map.updateMap(5, "o");
		assertTrue(ai.makeMove(mapViewer));
		assertArrayEquals(new String[] {"0","1","2",
										"o","o","o",
										"6","7","8"}, map.getMapField());
		
		map.initializeMap(3);
		map.updateMap(7, "o");
		map.updateMap(8, "o");
		assertTrue(ai.makeMove(mapViewer));
		assertArrayEquals(new String[] {"0","1","2",
										"3","4","5",
										"o","o","o"}, map.getMapField());
		
		map.initializeMap(3);
		map.updateMap(0, "o");
		map.updateMap(2, "o");
		assertTrue(ai.makeMove(mapViewer));
		assertArrayEquals(new String[] {"o","o","o",
										"3","4","5",
										"6","7","8"}, map.getMapField());
		
		//test for correct vertical moves
		map.initializeMap(3);
		map.updateMap(3, "o");
		map.updateMap(6, "o");
		assertTrue(ai.makeMove(mapViewer));
		assertArrayEquals(new String[] {"o","1","2",
										"o","4","5",
										"o","7","8"}, map.getMapField());
		
		map.initializeMap(3);
		map.updateMap(2, "o");
		map.updateMap(8, "o");
		assertTrue(ai.makeMove(mapViewer));
		assertArrayEquals(new String[] {"0","1","o",
										"3","4","o",
										"6","7","o"}, map.getMapField());
	}
	
	@Test
	public void testMakeMoveUsingStates() {
		map.initializeMap(3);
		mapViewer.setViewedMap(map);
		ai.setPersonalSymbol("o");
		
		//test for correct horizontal moves
		map.updateMap(0, "x");
		map.updateMap(1, "x");
		assertTrue(ai.makeMoveUsingStates(mapViewer));
		assertArrayEquals(new String[] {"x","x","o",
										"3","4","5",
										"6","7","8"}, map.getMapField());
		
		map.initializeMap(3);
		map.updateMap(7, "x");
		map.updateMap(8, "x");
		assertTrue(ai.makeMoveUsingStates(mapViewer));
		assertArrayEquals(new String[] {"0","1","2",
										"3","4","5",
										"o","x","x"}, map.getMapField());
		
		map.initializeMap(3);
		map.updateMap(3, "x");
		map.updateMap(5, "x");
		assertTrue(ai.makeMoveUsingStates(mapViewer));
		assertArrayEquals(new String[] {"0","1","2",
										"x","o","x",
										"6","7","8"}, map.getMapField());
		
		//test block vertical wins
		map.initializeMap(3);
		map.updateMap(0, "x");
		map.updateMap(3, "x");
		assertTrue(ai.makeMoveUsingStates(mapViewer));
		assertArrayEquals(new String[] {"x","1","2",
										"x","4","5",
										"o","7","8"}, map.getMapField());
		
		map.initializeMap(3);
		map.updateMap(4, "x");
		map.updateMap(7, "x");
		assertTrue(ai.makeMoveUsingStates(mapViewer));
		assertArrayEquals(new String[] {"0","o","2",
										"3","x","5",
										"6","x","8"}, map.getMapField());
		
		map.initializeMap(3);
		map.updateMap(2, "x");
		map.updateMap(8, "x");
		assertTrue(ai.makeMoveUsingStates(mapViewer));
		assertArrayEquals(new String[] {"0","1","x",
										"3","4","o",
										"6","7","x"}, map.getMapField());
		
		//test block left diagonal wins
		/*map.initializeMap(3);
		map.updateMap(0, "x");
		map.updateMap(4, "x");
		assertTrue(ai.makeMoveUsingStates(mapViewer));
		assertArrayEquals(new String[] {"x","1","2",
										"3","x","5",
										"6","7","o"}, map.getMapField());*/
	}
	
	@Test
	public void testCheckVertical() {
		//test empty map
		map.initializeMap(3);
		mapViewer.setViewedMap(map);
		Move move = new Move();
		move.setPlayer("o");
		move.setPosition("4");
		
		assertNotNull(ai.checkVertical(move, mapViewer));
		assertTrue(ai.checkVertical(move, mapViewer));
		
		map.updateMap(4, "x");
		assertFalse(ai.checkVertical(move, mapViewer));
		
		map.initializeMap(3);
		map.updateMap(4, "o");
		assertTrue(ai.checkVertical(move, mapViewer));
		
		map.updateMap(1, "x");
		assertFalse(ai.checkVertical(move, mapViewer));
		
		map.initializeMap(3);
		map.updateMap(0, "x");
		assertTrue(ai.checkVertical(move, mapViewer));
		map.updateMap(8, "x");
		assertTrue(ai.checkVertical(move, mapViewer));
	}
	
	@Test
	public void testCheckHorizontal() {
		map.initializeMap(3);
		mapViewer.setViewedMap(map);
		Move move = new Move();
		move.setPlayer("o");
		move.setPosition("4");
		
		assertNotNull(ai.checkHorizontal(move, mapViewer));
		map.updateMap(4, "x");
		assertFalse(ai.checkHorizontal(move, mapViewer));
		
		map.initializeMap(3);
		map.updateMap(4, "o");
		assertTrue(ai.checkHorizontal(move, mapViewer));
		
		map.updateMap(5, "x");
		assertFalse(ai.checkHorizontal(move, mapViewer));
		
		map.initializeMap(3);
		map.updateMap(4, "o");
		map.updateMap(5, "o");
		assertTrue(ai.checkHorizontal(move, mapViewer));
		map.updateMap(6, "x");
		assertTrue(ai.checkHorizontal(move, mapViewer));
		map.updateMap(2, "x");
		assertTrue(ai.checkHorizontal(move, mapViewer));
	}
	
	/*@Test
	public void testCheckDiagonal() {
		map.initializeMap(3);
		Move move = new Move();
		move.setPlayer("o");
		move.setPosition("4");
		
		assertNotNull(ai.checkDiagonal(move, map));
		assertTrue(ai.checkDiagonal(move, map));
		
		map.updateMap(4, "x");
		assertFalse(ai.checkDiagonal(move, map));
	}*/
}
