package map;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import player.Move;

class columnContainer {
	private String symbol;
	private List<String> columns;
	
	public columnContainer(String symbol, List<String> columns) {
		this.symbol = symbol;
		this.columns = columns;
	}
	
	public String getSymbol() {
		return symbol;
	}
	
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	
	public List<String> getColumns() {
		return columns;
	}
	
	public void addColumn(String column) {
		columns.add(column);
	}
}

public class MapViewer {
	private Map viewedMap;
	private HashMap<String, columnContainer> gridMap;
	private Collection<String> owners;
	
	public boolean updateMap(Move move) {
		String[] cartesianPosition = convertToCartesian(move.getPosition());
		ColumnContainer cc = null;
		
		if (!gridMap.containsKey(cartesianPosition)) {
			gridMap.put(cartesianPosition[0], new ColumnContainer(move.getPlayer(), Arrays.asList(cartesianPosition[1])));
		}
		else {
			gridMap.put(cartesianPosition[0], value);
		}
		
		return viewedMap.updateMap(move);
	}
	
	private String[] convertToCartesian(String position) {
		return new String[2];
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
}

//position, symbol

//symbol, row, column, diagonal, number
//	could create class, takes input(symbol, position), saves it as (symbol, rcd, spacesTake)

//could convert position into (x,y) coord and work with that

//2 classes:
//	row:	column, symbol
//  symbol:	row/column/diagonal, number, amount