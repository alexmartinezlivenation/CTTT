package score;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import map.MapViewer;

public class Score {
	private int turnCounter;
	
	public boolean isWinConditionMet(MapViewer map) {
		HashMap<String, String> newMap = map.getMap();
		HashMap<String, String[]> rowTable = map.getRowTable();

        if (rowTable.isEmpty()) {
            return false;
        }

		for (String[] symbolPower : rowTable.values()) {
            if (symbolPower[1] == null) {
                return false;
            }
			if (Integer.parseInt(symbolPower[1]) == map.getMapSize()) {
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
