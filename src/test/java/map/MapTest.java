package map;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

public class MapTest {
	
	Board testMap = new Board();
	
	@Test
	public void testInitializeBoard() {
		
		testMap.initializeBoard(0);
		assertEquals(new HashMap<String, String>(), testMap.getBoard());
        assertEquals(0, testMap.getBoardSize());
		
		testMap.initializeBoard(1);
        assertEquals(1, testMap.getBoardSize());
		
		testMap.initializeBoard(3);
        assertEquals(3, testMap.getBoardSize());
		
		testMap.initializeBoard(4);
        assertEquals(4, testMap.getBoardSize());
	}
	
	@Test
	public void testUpdateBoard() {
		testMap.initializeBoard(0);
		assertFalse(testMap.updateBoard(1, "x"));
		
		testMap.initializeBoard(1);
		assertTrue(testMap.updateBoard(0,"x"));
		assertEquals("x", testMap.getBoard().get("0"));
		
		testMap.initializeBoard(1);
		assertFalse(testMap.updateBoard(1,"x"));
		assertEquals(null, testMap.getBoard().get("1"));
		
		testMap.initializeBoard(3);
		assertTrue(testMap.updateBoard(0,"x"));
		assertEquals("x", testMap.getBoard().get("0"));
        assertFalse(testMap.updateBoard(0,"o"));
        assertEquals("x", testMap.getBoard().get("0"));
		
		assertFalse(testMap.updateBoard(9,"x"));
		assertEquals(null, testMap.getBoard().get("9"));
		
		assertTrue(testMap.updateBoard(8,"o"));
		assertEquals("o", testMap.getBoard().get("8"));
        assertFalse(testMap.updateBoard(8, "x"));
        assertEquals("o", testMap.getBoard().get("8"));
		
		testMap.initializeBoard(4);
		assertTrue(testMap.updateBoard(3,"x"));
		assertEquals("x", testMap.getBoard().get("3"));
        assertFalse(testMap.updateBoard(3, "o"));
        assertEquals("x", testMap.getBoard().get("3"));
		
		assertFalse(testMap.updateBoard(16,"o"));
		assertEquals(null, testMap.getBoard().get("16"));
		
		assertTrue(testMap.updateBoard(11,"o"));
		assertEquals("o", testMap.getBoard().get("11"));
        assertFalse(testMap.updateBoard(11, "x"));
        assertEquals("o", testMap.getBoard().get("11"));
	}
}
