package player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import map.MapViewer;

//import map.Map;

public class DifficultAIPlayer implements Player {

	private String personalSymbol;
	private Move move;
	private Collection<Move> winMoves;
	
	public boolean makeSimpleMove(MapViewer map) {
		move = new Move();
		move.setPlayer(personalSymbol);
		
		if (winMoveAvailable(map)) {
			move.setPosition(getWinMove(map));
			return map.updateMap(move);
		}
		else if (loseMoveAvailable(map)) {
			move.setPosition(getLoseMove(map));
			return map.updateMap(move);
		}
		else {
			move.setPosition(getRandomPosition());
			//Random randomGenerator = new Random();
			//move.setPosition(Integer.toString(randomGenerator.nextInt(9)));
			return map.updateMap(move);
		}
	}
	
	private boolean winMoveAvailable(MapViewer map) {
		return false;
	}
	
	private boolean loseMoveAvailable(MapViewer map) {
		return false;
	}
	
	private String getWinMove(MapViewer map) {
		return "";
	}
	
	private String getLoseMove(MapViewer map) {
		return "";
	}
	
	private String getRandomPosition() {
		Random randomGenerator = new Random();
		return Integer.toString(randomGenerator.nextInt(9));
	}
	
	public boolean makeMove(MapViewer map) {
		move = new Move();
		move.setPlayer(personalSymbol);
		
		winMoves = Collections.EMPTY_SET;
		
		//If winning move available, make it
		if(winMoves.isEmpty() == false) {
			move = (Move) winMoves.toArray()[0];
			return map.updateMap(move);
		}
		
		//Search for opponent's winning move, and stop it
		
		String[][] mapAnalyzer = map.getSquareMap();
		List<String> emptySpaces = map.getEmptySpaces();
		int mapSize = map.getMapSize();
		
		//Find out which rows, diagonals and columns have 1 empty space
		
		List<Integer> rowsWithOneEmptySpace = populateRowsWithOneEmptySpace(mapSize, emptySpaces, mapAnalyzer);
		List<Integer> columnsWithOneEmptySpace = populateColumnsWithOneEmptySpace(mapSize, emptySpaces, mapAnalyzer);
		List<Integer> diagonalsWithOneEmptySpace = populateDiagonalsWithOneEmptySpace(mapSize, emptySpaces, mapAnalyzer);
		
		//analyze rows to prevent opponent's win move (i.e. make sure only opponent has pieces here)
		boolean blockNeeded=true;
		String emptyPosition="";
		
		for (int row : rowsWithOneEmptySpace) {
			blockNeeded=true;
			for (int column=0; column<mapSize; column++) {
				if (!emptySpaces.contains(mapAnalyzer[row][column]) && !mapAnalyzer[row][column].equals(personalSymbol)) {
					for (int columnSearch = column+1; columnSearch<mapSize; columnSearch++) {
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
						return map.updateMap(move);
					}
					else {
						break;
					}
				}
				emptyPosition = mapAnalyzer[row][column];
			}
		}
		
		//analyze columns to prevent win move (i.e. make sure only opponent has pieces here)
		
		for (int column : columnsWithOneEmptySpace) {
			blockNeeded=true;
			for (int row=0; row<mapSize; row++) {
				if (!emptySpaces.contains(mapAnalyzer[row][column]) && !mapAnalyzer[row][column].equals(personalSymbol)) {
					for (int rowSearch = row+1; rowSearch<mapSize; rowSearch++) {
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
						return map.updateMap(move);
					}
					else {
						break;
					}
				}
				emptyPosition = mapAnalyzer[row][column];
			}
		}
		
		//analyze left diagonal (by left meaning top-left)
		if (diagonalsWithOneEmptySpace.contains(0)) {
			blockNeeded=true;
			for (int leftDiagonal=0; leftDiagonal<mapSize; leftDiagonal++) {
				if (!emptySpaces.contains(mapAnalyzer[leftDiagonal][leftDiagonal]) && !mapAnalyzer[leftDiagonal][leftDiagonal].equals(personalSymbol)) {
					for (int diagonalSearch=leftDiagonal+1; diagonalSearch<mapSize; diagonalSearch++) {
						if (emptySpaces.contains(mapAnalyzer[diagonalSearch][diagonalSearch])) {
							emptyPosition = mapAnalyzer[diagonalSearch][diagonalSearch];
							continue;
						}
						else if (!mapAnalyzer[leftDiagonal][leftDiagonal].equals(mapAnalyzer[diagonalSearch][diagonalSearch])) {
							blockNeeded=false;
							break;
						}
					}
					if (blockNeeded) {
						move.setPosition(emptyPosition);
						return map.updateMap(move);
					}
					else {
						break;
					}
				}
				emptyPosition = mapAnalyzer[leftDiagonal][leftDiagonal];
			}
		}
		
		//analyze right diagonal (by right meaning top-right)
		if (diagonalsWithOneEmptySpace.contains(1)) {
			blockNeeded=true;
			for (int rightDiagonal=0; rightDiagonal<mapSize; rightDiagonal++) {
				if (!emptySpaces.contains(mapAnalyzer[rightDiagonal][mapSize - rightDiagonal - 1]) && !mapAnalyzer[rightDiagonal][mapSize - rightDiagonal - 1].equals(personalSymbol)) {
					for (int diagonalSearch=rightDiagonal+1; diagonalSearch<mapSize; diagonalSearch++) {
						int colDiagonalSearch = mapSize-diagonalSearch-1;
						if (emptySpaces.contains(mapAnalyzer[diagonalSearch][colDiagonalSearch])) {
							emptyPosition = mapAnalyzer[diagonalSearch][colDiagonalSearch];
							continue;
						}
						else if (!mapAnalyzer[rightDiagonal][mapSize - rightDiagonal - 1].equals(mapAnalyzer[diagonalSearch][colDiagonalSearch])) {
							blockNeeded=false;
							break;
						}
					}
					if (blockNeeded) {
						move.setPosition(emptyPosition);
						return map.updateMap(move);
					}
					else {
						break;
					}
				}
				emptyPosition = mapAnalyzer[rightDiagonal][mapSize - rightDiagonal - 1];
			}
		}
		
		return false;
	}
	
	private List<Integer> populateRowsWithOneEmptySpace(int mapSize, List<String> emptySpaces, String[][] mapAnalyzer) {
		boolean isEmpty = true;
		List<Integer> emptyRows = new ArrayList<Integer>();
		
		for (int row=0; row<mapSize; row++) {
			isEmpty=true;
			for (int column=0; column<mapSize; column++) {
				if (emptySpaces.contains(mapAnalyzer[row][column])) {
					for (int columnSearch=column+1; columnSearch<mapSize; columnSearch++) {
						if (emptySpaces.contains(mapAnalyzer[row][columnSearch])) {
							isEmpty=false;
							break;
						}
					}
					if (isEmpty) {
						emptyRows.add(row);
					}
					else {
						break;
					}
				}
			}
		}
		return emptyRows;
	}
	
	private List<Integer> populateColumnsWithOneEmptySpace(int mapSize, List<String> emptySpaces, String[][] mapAnalyzer) {
		boolean isEmpty = true;
		List<Integer> emptyColumns = new ArrayList<Integer>();
		
		for (int column=0; column<mapSize; column++) {
			isEmpty=true;
			for (int row=0; row<mapSize; row++) {
				if (emptySpaces.contains(mapAnalyzer[row][column])) {
					for (int rowSearch=row+1; rowSearch<mapSize; rowSearch++) {
						if (emptySpaces.contains(mapAnalyzer[rowSearch][column])) {
							isEmpty=false;
							break;
						}
					}
					if (isEmpty) {
						emptyColumns.add(column);
					}
					else {
						break;
					}
				}
			}
		}
		return emptyColumns;
	}
	
	private List<Integer> populateDiagonalsWithOneEmptySpace(int mapSize, List<String> emptySpaces, String[][] mapAnalyzer) {
		boolean isEmpty = true;
		List<Integer> emptyDiagonals = new ArrayList<Integer>();
		
		for (int leftDiagonal=0; leftDiagonal<mapSize; leftDiagonal++) {
			isEmpty=true;
			if (emptySpaces.contains(mapAnalyzer[leftDiagonal][leftDiagonal])) {
				for (int DiagonalSearch=leftDiagonal+1; DiagonalSearch<mapSize; DiagonalSearch++) {
					if (emptySpaces.contains(mapAnalyzer[DiagonalSearch][DiagonalSearch])) {
						isEmpty=false;
						break;
					}
				}
				if (isEmpty) {
					emptyDiagonals.add(0);
				}
				else {
					break;
				}
			}
		}
		
		for (int rightDiagonal=0; rightDiagonal<mapSize; rightDiagonal++) {
			isEmpty=true;
			if (emptySpaces.contains(mapAnalyzer[rightDiagonal][mapSize - rightDiagonal - 1])) {
				for (int DiagonalSearch=rightDiagonal+1; DiagonalSearch<mapSize; DiagonalSearch++) {
					if (emptySpaces.contains(mapAnalyzer[DiagonalSearch][mapSize - DiagonalSearch - 1])) {
						isEmpty=false;
						break;
					}
				}
				if (isEmpty) {
					emptyDiagonals.add(1);
				}
				else {
					break;
				}
			}
		}
		
		return emptyDiagonals;
	}

	public String getPersonalSymbol() {
		return personalSymbol;
	}

	public void setPersonalSymbol(String personalSymbol) {
		this.personalSymbol = personalSymbol;
	}

}