package output;

import java.util.HashMap;

import output.impl.DisplayInterface;
import map.MapViewer;

/*
 * Implementation of abstract bridge pattern
 */
public class OutputImpl extends Output {
	
	public OutputImpl(DisplayInterface displayBridge) {
		super(displayBridge);
	}

	public void drawMap(MapViewer map) {
		int size = map.getMapSize();
		String currentLine = " ";
		String currentPosition;
		
		for (int position=0; position<(size*size); position++) {
			if (isBetweenLines(position, size)) {
				outputDashedLine(size);
			}
			
			currentPosition = getCurrentPosition(map.getMap(), position);
			
			if (isEndOfLine(position, size)) {
				currentLine = currentLine + currentPosition + " ";
				writeToScreen(currentLine);
				currentLine = " ";
			}
			else {
				currentLine = currentLine + currentPosition + " | ";
			}
		}
	}
	
	private boolean isBetweenLines(int position, int size) {
		return ((position%size) == 0 && (position!=0));
	}
	
	private boolean isEndOfLine(int position, int size) {
		return ((position%size) == (size-1));
	}
	
	private String getCurrentPosition(HashMap<String, String> storedMap, int position) {
		if (storedMap.get(Integer.toString(position)) == null) {
			return Integer.toString(position);
		}
		else {
			return storedMap.get(Integer.toString(position));
		}
	}
	
	private void outputDashedLine(int size) {
		String currentLine = "---";
		for (int j=1; j<size; j++) {
			currentLine = currentLine + "----";
		}
		writeToScreen(currentLine);
		currentLine=" ";
	}
	
}
