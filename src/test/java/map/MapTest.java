package map;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

public class MapTest {
	
	Map testMap = new Map();
	
	@Test
	public void testInitializeMap() {
		
		testMap.initializeMap(0);
		assertEquals(new HashMap<String, String>(), testMap.getMap());
        assertEquals(0, testMap.getMapSize());
		
		testMap.initializeMap(1);
        assertEquals(1, testMap.getMapSize());
		
		testMap.initializeMap(3);
        assertEquals(3, testMap.getMapSize());
		
		testMap.initializeMap(4);
        assertEquals(4, testMap.getMapSize());
	}
	
	@Test
	public void testMapStuff() {
		assertTrue(true);
	}
	
	@Test
	public void testUpdateMap() {
		testMap.initializeMap(0);
		assertFalse(testMap.updateMap(1, "x"));
		
		testMap.initializeMap(1);
		assertTrue(testMap.updateMap(0,"x"));
		assertEquals("x", testMap.getMap().get("0"));
		
		testMap.initializeMap(1);
		assertFalse(testMap.updateMap(1,"x"));
		assertArrayEquals(new String[] {"0"}, testMap.getMapField());
		assertEquals(null, testMap.getMap().get("1"));
		
		testMap.initializeMap(3);
		assertTrue(testMap.updateMap(0,"x"));
		assertEquals("x", testMap.getMap().get("0"));
        assertFalse(testMap.updateMap(0,"o"));
        assertEquals("x", testMap.getMap().get("0"));
		
		assertFalse(testMap.updateMap(9,"x"));
		assertEquals(null, testMap.getMap().get("9"));
		
		assertTrue(testMap.updateMap(8,"o"));
		assertEquals("o", testMap.getMap().get("8"));
        assertFalse(testMap.updateMap(8, "x"));
        assertEquals("o", testMap.getMap().get("8"));
		
		testMap.initializeMap(4);
		assertTrue(testMap.updateMap(3,"x"));
		assertEquals("x", testMap.getMap().get("3"));
        assertFalse(testMap.updateMap(3, "o"));
        assertEquals("x", testMap.getMap().get("3"));
		
		assertFalse(testMap.updateMap(16,"o"));
		assertEquals(null, testMap.getMap().get("16"));
		
		assertTrue(testMap.updateMap(11,"o"));
		assertEquals("o", testMap.getMap().get("11"));
        assertFalse(testMap.updateMap(11, "x"));
        assertEquals("o", testMap.getMap().get("11"));
	}
}
