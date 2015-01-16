package player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import map.MapViewer;

//import map.Map;

public class DifficultAIPlayer implements Player {

	private String personalSymbol;
	private Move move;
	private Collection<Move> winMoves;
	//private Map referenceMap;
	
	public boolean makeMove(MapViewer map) {
		move = new Move();
		move.setPlayer(personalSymbol);
		
		int mapSize = map.getMapSize();
		
		//If can make a winning move, make it
		for (int columnIndex=0; columnIndex<mapSize; columnIndex++) {
			for (int rowIndex=0; rowIndex<mapSize; rowIndex++) {
				//check for horizontal O's win moves
				if (map.getMapField()[columnIndex*mapSize + ((rowIndex + 1) % mapSize)].equals("o")) {
					if (map.getMapField()[columnIndex*mapSize + ((rowIndex + 2) % mapSize)].equals("o")) {
						move.setPosition(Integer.toString(columnIndex*mapSize + rowIndex));
					}
				}
				//check for vertical O's win moves
				else if (map.getMapField()[((columnIndex + 1) % mapSize)*mapSize + rowIndex].equals("o")) {
					if (map.getMapField()[((columnIndex + 2) % mapSize)*mapSize + rowIndex].equals("o")) {
						move.setPosition(Integer.toString(columnIndex*mapSize + rowIndex));
					}
				}
			}
		}
		
		return map.updateMap(Integer.parseInt(move.getPosition()), move.getPlayer());
		
	}
	
	public boolean makeMoveUsingStates(MapViewer map) {
		
		winMoves = Collections.EMPTY_SET;
		
		move = new Move();
		move.setPlayer(personalSymbol);
		
		//If winning move available, make it
		
		if(winMoves.isEmpty() == false) {
			move = (Move) winMoves.toArray()[0];
			//return true;
		}
		
		//Search for opponent's winning move, and stop it
		
		String[][] mapAnalyzer = map.getSquareMap();
		
		List<String> emptySpaces = map.getEmptySpaces();
		
		//Find out which rows, diagonals and columns have 1 empty space
		List<String> emptyRows = new ArrayList<String>();
		List<String> emptyColumns = new ArrayList<String>();
		List<String> emptyDiagonals = new ArrayList<String>();
		
		boolean isEmpty=true;
		
		//create list of rows with only 1 empty space
		for (int row=0; row<map.getMapSize(); row++) {
			isEmpty=true;
			for (int column=0; column<map.getMapSize(); column++) {
				if (emptySpaces.contains(mapAnalyzer[row][column])) {
					for (int columnSearch=column+1; columnSearch<map.getMapSize(); columnSearch++) {
						if (emptySpaces.contains(mapAnalyzer[row][columnSearch])) {
							isEmpty=false;
							break;
						}
					}
					if (isEmpty) {
						emptyRows.add(Integer.toString(row));
					}
					else {
						break;
					}
				}
			}
		}
		
		//create list of empty columns with only 1 empty space
		for (int column=0; column<map.getMapSize(); column++) {
			isEmpty=true;
			for (int row=0; row<map.getMapSize(); row++) {
				if (emptySpaces.contains(mapAnalyzer[row][column])) {
					for (int rowSearch=row+1; rowSearch<map.getMapSize(); rowSearch++) {
						if (emptySpaces.contains(mapAnalyzer[rowSearch][column])) {
							isEmpty=false;
							break;
						}
					}
					if (isEmpty) {
						emptyColumns.add(Integer.toString(column));
					}
					else {
						break;
					}
				}
			}
		}
		
		//create list of empty diagonals
		for (int leftDiagonal=0; leftDiagonal<map.getMapSize(); leftDiagonal++) {
			isEmpty=true;
			if (emptySpaces.contains(mapAnalyzer[leftDiagonal][leftDiagonal])) {
				for (int DiagonalSearch=leftDiagonal+1; DiagonalSearch<map.getMapSize(); DiagonalSearch++) {
					if (emptySpaces.contains(mapAnalyzer[DiagonalSearch][DiagonalSearch])) {
						isEmpty=false;
						break;
					}
				}
				if (isEmpty) {
					emptyDiagonals.add("0");
				}
				else {
					break;
				}
			}
		}
		
		for (int rightDiagonal=0; rightDiagonal<map.getMapSize(); rightDiagonal++) {
			isEmpty=true;
			if (emptySpaces.contains(mapAnalyzer[rightDiagonal][map.getMapSize() - rightDiagonal])) {
				for (int DiagonalSearch=rightDiagonal+1; DiagonalSearch<map.getMapSize(); DiagonalSearch++) {
					if (emptySpaces.contains(mapAnalyzer[DiagonalSearch][map.getMapSize() - DiagonalSearch])) {
						isEmpty=false;
						break;
					}
				}
				if (isEmpty) {
					emptyDiagonals.add("1");
				}
				else {
					break;
				}
			}
		}
		
		//From those, analyze for opponent's win moves

		//analyze rows for opponent's winning move
		/*for (int row=0; row<map.getMapSize(); row++) {
			for (int column=0; column<map.getMapSize(); column++) {
				if (!emptySpaces.contains(mapAnalyzer[row][column]) && !mapAnalyzer[row][column].equals(personalSymbol)) {
					for (int columnSearch = column+1; columnSearch<map.getMapSize(); columnSearch++) {
						if (!mapAnalyzer[row][column].equals(mapAnalyzer[row][columnSearch])) {
							break;
						}
						else {
							move.setPosition(mapAnalyzer[row][column]);
							return map.updateMap(Integer.parseInt(move.getPosition()), move.getPlayer());
						}
					}
					break;
				}
			}
		}*/
		
		//analyze rows to prevent win move (i.e. make sure only opponent has pieces here)
		boolean blockNeeded=true;
		String emptyPosition="";
		
		for (String emptyRow : emptyRows) {
			blockNeeded=true;
			int row = Integer.parseInt(emptyRow);
			for (int column=0; column<map.getMapSize(); column++) {
				if (!emptySpaces.contains(mapAnalyzer[row][column]) && !mapAnalyzer[row][column].equals(personalSymbol)) {
					for (int columnSearch = column+1; columnSearch<map.getMapSize(); columnSearch++) {
						if (emptySpaces.contains(mapAnalyzer[row][columnSearch])) {
							emptyPosition = mapAnalyzer[row][columnSearch];
							continue;
						}
						else if (!mapAnalyzer[row][column].equals(mapAnalyzer[row][columnSearch])) {
							blockNeeded=false;
							break;
						}
					}
					
					if (blockNeeded) {
						move.setPosition(emptyPosition);
						return map.updateMap(Integer.parseInt(move.getPosition()), move.getPlayer());
					}
					else {
						break;
					}
				}
				emptyPosition = mapAnalyzer[row][column];
			}
		}
		
		//analyze columns to prevent win move (i.e. make sure only opponent has pieces here)
		emptyPosition="";
		
		for (String emptyCol : emptyColumns) {
			blockNeeded=true;
			int column = Integer.parseInt(emptyCol);
			for (int row=0; row<map.getMapSize(); row++) {
				if (!emptySpaces.contains(mapAnalyzer[row][column]) && !mapAnalyzer[row][column].equals(personalSymbol)) {
					for (int rowSearch = row+1; rowSearch<map.getMapSize(); rowSearch++) {
						if (emptySpaces.contains(mapAnalyzer[rowSearch][column])) {
							emptyPosition = mapAnalyzer[rowSearch][column];
							continue;
						}
						else if (!mapAnalyzer[row][column].equals(mapAnalyzer[rowSearch][column])) {
							blockNeeded=false;
							break;
						}
					}
					
					if (blockNeeded) {
						move.setPosition(emptyPosition);
						return map.updateMap(Integer.parseInt(move.getPosition()), move.getPlayer());
					}
					else {
						break;
					}
				}
				emptyPosition = mapAnalyzer[row][column];
			}
		}
		
		//analyze left diagonal (by left meaning top-left)
		if (emptyDiagonals.contains("0")) {
			
		}
		
		
		return false;
	}
	
	public boolean checkVertical(Move move, MapViewer map) {
		
		for (int columnIndex = Integer.parseInt(move.getPosition()) % map.getMapSize(); columnIndex < map.getMapField().length; columnIndex+= map.getMapSize()) {
			if (map.getMapField()[columnIndex].equals("x")) {
				return false;
			}
		}
		
		return true;
	}
	
	public boolean checkHorizontal(Move move, MapViewer map) {
		int position = Integer.parseInt(move.getPosition());
		int mapLength = map.getMapSize();
		int thisRowIndex = (position - (position%mapLength))/mapLength;
		int nextRowIndex = thisRowIndex + 1;
		
		for (int rowIndex = thisRowIndex * mapLength; rowIndex < nextRowIndex*mapLength; rowIndex++) {
			if (!map.getMapField()[rowIndex].equals(move.getPlayer())) {
				if (!map.getMapField()[rowIndex].equals(Integer.toString(rowIndex))) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	public boolean checkDiagonal(Move move, MapViewer map) {
		return true;
	}

	public String getPersonalSymbol() {
		return personalSymbol;
	}

	public void setPersonalSymbol(String personalSymbol) {
		this.personalSymbol = personalSymbol;
	}
	
	/*public void setReferenceMap(Map referenceMap) {
		this.referenceMap = referenceMap;
	}*/

}

//check for our win moves and make it

		//check for opponent's win moves and try to stop it
		//count the number of potential win moves that the opponent can make, and try to limit that
		/*
		 * Map 1: count r,c, d
		 * Map 2: X map
		 * Map 3: O map
		 */
		
		/*
		 * x| | 
		 * -----
		 *  |o|
		 * -----
		 *  | |x
		 */
		
		/*
		 * 3|2|2				To do this, will need 2 functions:
		 * -----				calculateEmptyValue(position)
		 * 1|3|x				calculateMoveValue(playerSymbol, position)
		 * -----
		 * 3|2|2
		 */
		
		/*X-map
		 * x|1|2
		 * -----
		 * 1|-|1
		 * -----
		 * 2|1|x
		 */
		
		/*O-map
		 * -|1|1
		 * -----
		 * 1|o|1
		 * -----
		 * 1|1|-
		 */
		
		/*O+1-map
		 * x| | 
		 * -----
		 *  |o|
		 * -----
		 *  | |x
		 */
		
		//if x has >1 moves with two ways to win, then o should choose a move to force x to not take any of those options
		
		/*
		 * -|1|-
		 * -----
		 * 1|o|1
		 * -----
		 * -|1|-
		 */
		
		//Example 2:
		
		/*
		 * x| | 
		 * -----
		 *  |x| 
		 * -----
		 *  | |o
		 */
		
		/*
		 * x|2|2
		 * -----
		 * 2|x|1
		 * -----
		 * 2|1|o
		 */
		
		/*
		 * x|0|1
		 * -----
		 * 0|x|1
		 * -----
		 * 1|1|o
		 */
		
		//What if we tried to predict a move ahead?
		
		/*X-map:
		 * x|2|2
		 * -----
		 * 2|x|1
		 * -----
		 * 2|1|o
		 */
		
		/*O-map
		 * -|0|1
		 * -----
		 * 0|-|1
		 * -----
		 * 1|1|o
		 */
		
		//New line of thought: after checking for immediate wins and losses, use X-map to predict X's best moves.
		//Then choose a move as O that will force X to use one of the worse predicted moves, and benefit O
		
		//Psuedocode:
		//	1. Check for immediate O wins
		//		If move available, break;
		//  2. Check for immediate X wins
		//		If move available, break;
		//  3. Create map for X's next move
		//		Check for win-opening moves for X
		//  4. Create map for O's next move
		//		Check for win-opening moves for O
		//		If X-map and O-map provide enough information to make a move, break;
		//  5. Create map for empty rows/columns/diagonals
		//		Use only if X-map and O-map doesn't provide enough information