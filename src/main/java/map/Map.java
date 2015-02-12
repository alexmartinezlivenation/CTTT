package map;

import java.util.HashMap;

import player.Move;

public class Map implements MapInterface {
	private int mapSize;
	private HashMap<String, String> map;
	
	public void initializeMap(int size) {
		map = new HashMap<String, String>();
		
		mapSize = size;
	}
	
	public boolean updateMap(Move move) {
		return updateMap(Integer.parseInt(move.getPosition()), move.getPlayer());
	}
	
	public boolean updateMap(int position, String player) {
		if ((map.get(Integer.toString(position)) == null) && (position>=0) && (position < (mapSize*mapSize))) {
			map.put(Integer.toString(position), player);
			return true;
		}

		return false;
	}
	
	public HashMap<String, String> getMap() {
		return map;
	}
	
	public void setMap(HashMap<String, String> map) {
		this.map = map;
	}

	public int getMapSize() {
		return mapSize;
	}
	
}
