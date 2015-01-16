package output;

import map.MapViewer;

public interface Output {
	public void clearScreen();
	
	public void drawMap(MapViewer map);
	
	public void writeToScreen(String text);
}
