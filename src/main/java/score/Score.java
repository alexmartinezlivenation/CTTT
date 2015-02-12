package score;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import map.MapViewer;

public class Score {
	private int turnCounter;
	
	public boolean isWinConditionMet(MapViewer map) {
        return (tableContainsWin(map.getRowTable(), map.getMapSize()) || tableContainsWin(map.getColTable(), map.getMapSize()) || tableContainsWin(map.getDigTable(), map.getMapSize()));
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
	
	public boolean isTie(MapViewer map) {
		if (turnCounter == map.getMapField().length) {
			return true;
		}
		else {
			return false;
		}
	}
}
