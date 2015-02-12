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
        updateRowTable(cartesianPosition[1], cartesianPosition[0]);
        updateColTable(cartesianPosition[2], cartesianPosition[0]);
        updateDigTable(cartesianPosition);
    }

    private void updateRowTable(String tableIndex, String playerSymbol) {
        if (rowTable.containsKey(tableIndex)) {
            if (rowTable.get(tableIndex)[0].equals(playerSymbol)) {
                int symbolCount = Integer.parseInt(rowTable.get(tableIndex)[1]);
                rowTable.put(tableIndex, new String[]{playerSymbol, Integer.toString(symbolCount + 1)});
            }
            else {
                rowTable.put(tableIndex, new String[]{"", null});
            }
        }
        else {
            rowTable.put(tableIndex, new String[]{playerSymbol, "1"});
        }
    }

    private void updateColTable(String tableIndex, String playerSymbol) {
        if (colTable.containsKey(tableIndex)) {
            if (colTable.get(tableIndex)[0].equals(playerSymbol)) {
                int symbolCount = Integer.parseInt(colTable.get(tableIndex)[1]);
                colTable.put(tableIndex, new String[]{playerSymbol, Integer.toString(symbolCount + 1)});
            }
            else {
                colTable.put(tableIndex, new String[]{"", null});
            }
        }
        else {
            colTable.put(tableIndex, new String[]{playerSymbol, "1"});
        }
    }

    private void updateDigTable(String[] cartesianCoord) {
        if (cartesianCoord[1].equals(cartesianCoord[2])) {
            updateSingleDig("\\", cartesianCoord[0]);
        }

        if (Integer.parseInt(cartesianCoord[1]) == (viewedMap.getMapSize() - Integer.parseInt(cartesianCoord[2]) - 1) ) {
            updateSingleDig("/", cartesianCoord[0]);
        }
    }

    private void updateSingleDig(String diagonal, String playerSymbol) {
        if (digTable.containsKey(diagonal)) {
            if (digTable.get(diagonal)[0].equals(playerSymbol)) {
                int symbolCount = Integer.parseInt(digTable.get(diagonal)[1]) + 1;
                digTable.put(diagonal, new String[]{playerSymbol, Integer.toString(symbolCount)});
            }
        }
        else {
            digTable.put(diagonal, new String[]{playerSymbol, "1"});
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

    public HashMap<String, String[]> getColTable() {
        return colTable;
    }

    public HashMap<String, String[]> getDigTable() {
        return digTable;
    }
}