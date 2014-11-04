package output;

import map.Map;

public interface Output {
	public void clearScreen();
	
	public void drawMap(Map map);
	
	public void writeToScreen(String text);
}
