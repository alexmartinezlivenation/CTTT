package map;

import static org.junit.Assert.*;

import org.junit.Test;

import player.Move;

public class MapTest {
	Map testMap = new Map();
	
	@Test
	public void testInitializeMap() {
		testMap.initializeMap(0);
		assertArrayEquals(new String[] {}, testMap.getMapField());
		
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
	public void testUpdateMap() {
		testMap.initializeMap(0);
		assertFalse(testMap.updateMap(1, "x"));
		
		testMap.initializeMap(1);
		assertTrue(testMap.updateMap(0,"x"));
		assertArrayEquals(new String[] {"x"}, testMap.getMapField());
		
		testMap.initializeMap(1);
		assertFalse(testMap.updateMap(1,"x"));
		assertArrayEquals(new String[] {"0"}, testMap.getMapField());
		
		testMap.initializeMap(3);
		assertTrue(testMap.updateMap(0,"x"));
		assertArrayEquals(new String[] {"x","1","2",
										"3","4","5",
										"6","7","8"}, testMap.getMapField());
		
		assertFalse(testMap.updateMap(9,"x"));
		assertArrayEquals(new String[] {"x","1","2",
										"3","4","5",
										"6","7","8"}, testMap.getMapField());
		
		assertTrue(testMap.updateMap(8,"o"));
		assertArrayEquals(new String[] {"x","1","2",
										"3","4","5",
										"6","7","o"}, testMap.getMapField());
		
		testMap.initializeMap(4);
		assertTrue(testMap.updateMap(3,"x"));
		assertArrayEquals(new String[] {"0","1","2","x",
										"4","5","6","7",
										"8","9","10","11",
										"12","13","14","15",}, testMap.getMapField());
		
		assertFalse(testMap.updateMap(16,"o"));
		assertArrayEquals(new String[] {"0","1","2","x",
										"4","5","6","7",
										"8","9","10","11",
										"12","13","14","15",}, testMap.getMapField());
		
		assertTrue(testMap.updateMap(11,"o"));
		assertArrayEquals(new String[] {"0","1","2","x",
										"4","5","6","7",
										"8","9","10","o",
										"12","13","14","15",}, testMap.getMapField());
	}
	
	@Test
	public void testUpdateMapOnOccupiedSpace() {
		testMap.initializeMap(3);
		testMap.updateMap(1,"x");
		testMap.updateMap(5,"o");
		
		assertFalse(testMap.updateMap(5,"x"));
		assertArrayEquals(new String[] {"0","x","2",
										"3","4","o",
										"6","7","8"}, testMap.getMapField());
		
		assertFalse(testMap.updateMap(5,"o"));
		assertArrayEquals(new String[] {"0","x","2",
										"3","4","o",
										"6","7","8"}, testMap.getMapField());
		
		//Testing larget map
				testMap.initializeMap(4);
				testMap.updateMap(6,"o");
				
				assertFalse(testMap.updateMap(6,"x"));
				assertArrayEquals(new String[] {"0","1","2","3",
												"4","5","o","7",
												"8","9","10","11",
												"12","13","14","15",}, testMap.getMapField());
	}
}
