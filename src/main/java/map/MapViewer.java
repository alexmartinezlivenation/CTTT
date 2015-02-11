package map;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import player.Move;

public class MapViewer {
	private Map viewedMap;
	private HashMap<String, String[]> rowTable = new HashMap<String, String[]>();
	private HashMap<String, String[]> colTable = new HashMap<String, String[]>();
	private HashMap<String, String[]> digTable = new HashMap<String, String[]>();
	
	public boolean updateMap(Move move) {
		String[] cartesianPosition = convertToCartesian(move);
		updateTables(cartesianPosition);
		
		return viewedMap.updateMap(move);
	}
	
	private String[] convertToCartesian(Move move) {
		String[] cartesian = new String[3];
		cartesian[0] = move.getPlayer();
		
		int position = Integer.parseInt(move.getPosition());
		cartesian[1] = Integer.toString(position / viewedMap.getMapSize());
		cartesian[2] = Integer.toString(position % viewedMap.getMapSize());
		
		return cartesian;
	}
	
	private void updateTables(String[] cartesianPosition) {
        updateTable(rowTable, cartesianPosition[1], cartesianPosition[0]);
        updateTable(colTable, cartesianPosition[2], cartesianPosition[0]);
	}

    private void updateTable(HashMap<String, String[]> table, String tableIndex, String playerSymbol) {
        if (table.containsKey(tableIndex)) {
            if (table.get(tableIndex)[0].equals(playerSymbol)) {
                int symbolCount = Integer.parseInt(table.get(tableIndex)[1]);
                table.put(tableIndex, new String[]{playerSymbol, Integer.toString(symbolCount + 1)});
            }
            else {
                table.put(tableIndex, new String[]{"", null});
            }
        }
        else {
            table.put(tableIndex, new String[]{playerSymbol, "1"});
        }
    }
	
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
	
	public HashMap<String, String> getMap() {
		return viewedMap.getMap();
	}
	
	public HashMap<String, String[]> getRowTable() {
		return rowTable;
	}
}