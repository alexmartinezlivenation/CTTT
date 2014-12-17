package player;

import static org.junit.Assert.*;

import map.Map;

import org.junit.Test;

public class DifficultAIPlayerTest {
	DifficultAIPlayer ai = new DifficultAIPlayer();
	Map map = new Map();
	
	@Test
	public void testMakeMove() {
		map.initializeMap(3);
		
		assertNotNull(ai.makeMove(map));
		
		map.updateMap(4, "x");
	}
	
	@Test
	public void testCheckVertical() {
		//test empty map
		map.initializeMap(3);
		Move move = new Move();
		move.setPlayer("o");
		move.setPosition("4");
		
		assertNotNull(ai.checkVertical(move, map));
		assertTrue(ai.checkVertical(move, map));
		
		map.updateMap(4, "x");
		assertFalse(ai.checkVertical(move, map));
		
		map.initializeMap(3);
		map.updateMap(4, "o");
		assertTrue(ai.checkVertical(move, map));
		
		map.updateMap(1, "x");
		assertFalse(ai.checkVertical(move, map));
		
		map.initializeMap(3);
		map.updateMap(0, "x");
		assertTrue(ai.checkVertical(move, map));
		map.updateMap(8, "x");
		assertTrue(ai.checkVertical(move, map));
	}
	
	@Test
	public void testCheckHorizontal() {
		map.initializeMap(3);
		Move move = new Move();
		move.setPlayer("o");
		move.setPosition("4");
		
		assertNotNull(ai.checkHorizontal(move, map));
		map.updateMap(4, "x");
		assertFalse(ai.checkHorizontal(move, map));
		
		map.initializeMap(3);
		map.updateMap(4, "o");
		assertTrue(ai.checkHorizontal(move, map));
		
		map.updateMap(5, "x");
		assertFalse(ai.checkHorizontal(move, map));
		
		map.initializeMap(3);
		map.updateMap(4, "o");
		map.updateMap(5, "o");
		assertTrue(ai.checkHorizontal(move, map));
		map.updateMap(6, "x");
		assertTrue(ai.checkHorizontal(move, map));
		map.updateMap(2, "x");
		assertTrue(ai.checkHorizontal(move, map));
	}
	
	@Test
	public void testCheckDiagonal() {
		map.initializeMap(3);
		Move move = new Move();
		move.setPlayer("o");
		move.setPosition("4");
		
		assertNotNull(ai.checkDiagonal(move, map));
		assertTrue(ai.checkDiagonal(move, map));
		
		map.updateMap(4, "x");
		assertFalse(ai.checkDiagonal(move, map));
	}
}
