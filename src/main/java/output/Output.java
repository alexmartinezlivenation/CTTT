package output;

import map.MapViewer;
import output.impl.DisplayInterface;

/*
 * abstraction in bridge pattern
 */
public abstract class Output {
	protected DisplayInterface displayBridge;
	
	public Output(DisplayInterface displayBridge) {
		this.displayBridge = displayBridge;
	}
	
	public void clearScreen() {
		displayBridge.clearScreen();
	}
	
	public void writeToScreen(String text) {
		displayBridge.writeToScreen(text);
	}
	
	abstract public void drawMap(MapViewer map);
}
