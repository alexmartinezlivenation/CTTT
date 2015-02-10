package player;

import static org.junit.Assert.*;

import map.Map;
import map.MapViewer;

import org.junit.Test;

public class DifficultAIPlayerTest {
	DifficultAIPlayer ai = new DifficultAIPlayer();
	Map map = new Map();
	MapViewer mapViewer = new MapViewer();
	
//	@Test
//	public void testmakeMove() {
//		map.initializeMap(3);
//		mapViewer.setViewedMap(map);
//		ai.setPersonalSymbol("o");
//		
//		//test for correct horizontal moves
//		map.updateMap(0, "x");
//		map.updateMap(1, "x");
//		assertTrue(ai.makeMove(mapViewer));
//		assertArrayEquals(new String[] {"x","x","o",
//										"3","4","5",
//										"6","7","8"}, map.getMapField());
//		
//		map.initializeMap(3);
//		map.updateMap(7, "x");
//		map.updateMap(8, "x");
//		assertTrue(ai.makeMove(mapViewer));
//		assertArrayEquals(new String[] {"0","1","2",
//										"3","4","5",
//										"o","x","x"}, map.getMapField());
//		
//		map.initializeMap(3);
//		map.updateMap(3, "x");
//		map.updateMap(5, "x");
//		assertTrue(ai.makeMove(mapViewer));
//		assertArrayEquals(new String[] {"0","1","2",
//										"x","o","x",
//										"6","7","8"}, map.getMapField());
//		
//		//test block vertical wins
//		map.initializeMap(3);
//		map.updateMap(0, "x");
//		map.updateMap(3, "x");
//		assertTrue(ai.makeMove(mapViewer));
//		assertArrayEquals(new String[] {"x","1","2",
//										"x","4","5",
//										"o","7","8"}, map.getMapField());
//		
//		map.initializeMap(3);
//		map.updateMap(4, "x");
//		map.updateMap(7, "x");
//		assertTrue(ai.makeMove(mapViewer));
//		assertArrayEquals(new String[] {"0","o","2",
//										"3","x","5",
//										"6","x","8"}, map.getMapField());
//		
//		map.initializeMap(3);
//		map.updateMap(2, "x");
//		map.updateMap(8, "x");
//		assertTrue(ai.makeMove(mapViewer));
//		assertArrayEquals(new String[] {"0","1","x",
//										"3","4","o",
//										"6","7","x"}, map.getMapField());
//		
//		//test block left diagonal wins
//		map.initializeMap(3);
//		map.updateMap(0, "x");
//		map.updateMap(4, "x");
//		assertTrue(ai.makeMove(mapViewer));
//		assertArrayEquals(new String[] {"x","1","2",
//										"3","x","5",
//										"6","7","o"}, map.getMapField());
//		
//		map.initializeMap(3);
//		map.updateMap(0, "x");
//		map.updateMap(8, "x");
//		assertTrue(ai.makeMove(mapViewer));
//		assertArrayEquals(new String[] {"x","1","2",
//										"3","o","5",
//										"6","7","x"}, map.getMapField());
//		
//		map.initializeMap(3);
//		map.updateMap(4, "x");
//		map.updateMap(8, "x");
//		assertTrue(ai.makeMove(mapViewer));
//		assertArrayEquals(new String[] {"o","1","2",
//										"3","x","5",
//										"6","7","x"}, map.getMapField());
//		
//		//test block right diagonal wins
//		map.initializeMap(3);
//		map.updateMap(2, "x");
//		map.updateMap(4, "x");
//		assertTrue(ai.makeMove(mapViewer));
//		assertArrayEquals(new String[] {"0","1","x",
//										"3","x","5",
//										"o","7","8"}, map.getMapField());
//		
//		map.initializeMap(3);
//		map.updateMap(2, "x");
//		map.updateMap(6, "x");
//		assertTrue(ai.makeMove(mapViewer));
//		assertArrayEquals(new String[] {"0","1","x",
//										"3","o","5",
//										"x","7","8"}, map.getMapField());
//		
//		map.initializeMap(3);
//		map.updateMap(4, "x");
//		map.updateMap(6, "x");
//		assertTrue(ai.makeMove(mapViewer));
//		assertArrayEquals(new String[] {"0","1","o",
//										"3","x","5",
//										"x","7","8"}, map.getMapField());
//		
//	}
}
