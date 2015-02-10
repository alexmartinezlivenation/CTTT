package map;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;
import org.junit.runner.RunWith;

public class MapTest {
	
	Map testMap = new Map();
	
	@Test
	public void testInitializeMap() {
		testMap.initializeMap(0);
		assertArrayEquals(new String[] {}, testMap.getMapField());
		assertEquals(new HashMap<String, String>(), testMap.getMap());
		
		testMap.initializeMap(1);
		assertArrayEquals(new String[] {"0"}, testMap.getMapField());
		
		testMap.initializeMap(3);
		assertArrayEquals(new String[] {"0","1","2",
										"3","4","5",
										"6","7","8"}, testMap.getMapField());
		
		testMap.initializeMap(4);
		assertArrayEquals(new String[] {"0","1","2","3",
										"4","5","6","7",
										"8","9","10","11",
										"12","13","14","15"}, testMap.getMapField());
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
		
		assertFalse(testMap.updateMap(9,"x"));
		assertEquals(null, testMap.getMap().get("9"));
		
		assertTrue(testMap.updateMap(8,"o"));
		assertEquals("o", testMap.getMap().get("8"));
		
		testMap.initializeMap(4);
		assertTrue(testMap.updateMap(3,"x"));
		assertEquals("x", testMap.getMap().get("3"));
		
		assertFalse(testMap.updateMap(16,"o"));
		assertEquals(null, testMap.getMap().get("16"));
		
		assertTrue(testMap.updateMap(11,"o"));
		assertEquals("o", testMap.getMap().get("11"));
	}
}
