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
				return true;
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

	public void setMapField(String[] mapField) {
		this.mapField = mapField;
	}

	public int getMapSize() {
		return mapSize;
	}
	
	public List<String> getEmptySpaces() {
		return emptySpaces;
	}
	
}

/*
 * Idea: to use a hashmap or some sort of collection to only keep track of the rows/columns/diagonals that have 1+ symbols in them.
 * 
 * Properties:  The row/column/diagonal is 'owned' by a symbol if:
 * 					+it contains at least one copy of that symbol
 * 					+there is only one type of symbol in it (i.e. only 'x' symbols and no 'o' symbols)
 * 					+there is at least one empty space left in it
 * 
 * 				A row/column/diagonal is 'un-ownable' if:
 * 					+it has no empty spaces
 * 					+it contains more than one type of unique symbol (i.e. an 'x' and an 'o')
 * 
 * 				A row/column/diagonal is 'free' if:
 * 					+it has only empty spaces
 * 
 * 3 properties to keep track of:
 * 				type: 	if it is row, column, or diagonal
 * 				number:	the number of the row or column, or w/e number scheme we decide to use for the diagonals
 * 				owner:	the player that is uncontested for control.  If there is no owner, then leave the field blank?
 * 
 * Ways to do this:
 * 				-keep track of each row, column, diagonal as it gets owned, and track it all in a single mapping that includes the owner somehow.
 * 				-Use 2 maps: one for ownership and one for moves.
 * 				-
 * 
 * row, column, symbol
 * 
 * owner, row/column/diagonal, number
 */
