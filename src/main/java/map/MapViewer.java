package map;

import java.util.List;

public class MapViewer {
	private Map viewedMap;
	
	public boolean updateMap(int position, String player) {
		return viewedMap.updateMap(position, player);
	}
	
	public String[] getMapField() {
		return viewedMap.getMapField();
	}
	
	public String[][] getSquareMap() {
		
		int mapTotal = viewedMap.getMapSize();
		String[][] squareMap = new String[mapTotal][mapTotal];

		for(int position=0; position<(mapTotal * mapTotal); position++) {
			squareMap[position/mapTotal][position % mapTotal] = viewedMap.getMapField()[position];
		}
		
		return squareMap;
	}
	
	public int getMapSize() {
		return viewedMap.getMapSize();
	}
	
	public void setViewedMap(Map viewedMap) {
		this.viewedMap = viewedMap;
	}
	
	public List<String> getEmptySpaces() {
		return viewedMap.getEmptySpaces();
	}
}
