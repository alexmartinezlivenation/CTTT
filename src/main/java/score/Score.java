package score;

import java.util.HashMap;

import map.BoardViewer;

public class Score {
	private int turnCounter;
	
	public boolean isWinConditionMet(BoardViewer board) {
        return (tableContainsWin(board.getRowTable(), board.getBoardSize()) || tableContainsWin(board.getColTable(), board.getBoardSize()) || tableContainsWin(board.getDigTable(), board.getBoardSize()));
	}

    private boolean tableContainsWin(HashMap<String, String[]> table, int mapSize) {
        if (table.isEmpty()) {
            return false;
        }
        for (String[] symbolPower : table.values()) {
            if (symbolPower[1] == null) {
                continue;
            }
            if (Integer.parseInt(symbolPower[1]) == mapSize) {
                return true;
            }
        }

        return false;
    }

	public int getTurnCounter() {
		return turnCounter;
	}

	public void setTurnCounter(int turnCounter) {
		this.turnCounter = turnCounter;
	}


    //TODO: test this!
	public boolean isTie(BoardViewer board) {
		return (turnCounter == (board.getBoardSize() * board.getBoardSize()));
	}
}
