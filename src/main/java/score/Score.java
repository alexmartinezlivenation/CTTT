package score;

import map.Map;

public class Score {
	public boolean isWinConditionMet(Map map) {
		String[] grid = map.getMapField();
		
		if (grid[0].equals(grid[3]) && grid[0].equals(grid[6])) {
			return true;
		}
		else if (grid[0].equals(grid[1]) && grid[0].equals(grid[2])) {
			return true;
		}
		else if (grid[8].equals(grid[5]) && grid[8].equals(grid[2])) {
			return true;
		}
		else if (grid[8].equals(grid[7]) && grid[8].equals(grid[6])) {
			return true;
		}
		else if (grid[4].equals(grid[0]) && grid[4].equals(grid[8])) {
			return true;
		}
		else if (grid[4].equals(grid[2]) && grid[4].equals(grid[6])) {
			return true;
		}
		else if (grid[4].equals(grid[1]) && grid[4].equals(grid[7])) {
			return true;
		}
		else if (grid[4].equals(grid[3]) && grid[4].equals(grid[5])) {
			return true;
		}
		
		return false;
	}
}
