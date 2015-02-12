package map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import player.Move;

public class Map implements MapInterface {
	private String[] mapField;
	private int mapSize;
	private List<String> emptySpaces;
	private HashMap<String, String> map;
	
	public void initializeMap(int size) {
		map = new HashMap<String, String>();
		
		if (size == 0) {
			mapField = new String[0];
			return;
		}
		
		mapField = new String[size*size];
		emptySpaces = new ArrayList<String>();
		for (int populatedValue=0; populatedValue<mapField.length; populatedValue++) {
			mapField[populatedValue] = Integer.toString(populatedValue);
			emptySpaces.add(mapField[populatedValue]);
		}
		
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
		
		if ((position>=0) && position < mapField.length) {
			if (mapField[position].equals(Integer.toString(position))) {
				mapField[position] = player;
				emptySpaces.remove(Integer.toString(position));
			}
		}
		return false;
	}
	
	/*public String getSymbolFromPosition(int position) {
		
	}*/
	
	public HashMap<String, String> getMap() {
		return map;
	}
	
	public void setMap(HashMap<String, String> map) {
		this.map = map;
	}
	
	public String[] getMapField() {
		return mapField;
	}

	public int getMapSize() {
		return mapSize;
	}
	
	public List<String> getEmptySpaces() {
		return emptySpaces;
	}
	
}
