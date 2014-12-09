package output.impl;

import map.Map;
import output.Output;

public class OutputConsole implements Output {

	public void clearScreen() {
		final String ESC = "\033[";
		try {
			final String os = System.getProperty("os.name");
			
			if (os.contains("Windows")) {
				Runtime.getRuntime().exec("cls");
			}
			else {
				Runtime.getRuntime().exec("clear");
				System.out.print(ESC + "2J");
			}
		}
		catch (final Exception e) {
			// Handle any exceptions
		}
	}

	public void drawMap(Map map) {
		String[] localMap = map.getMapField();
	
		if (localMap.length == 0) {
			return;
		}
	
		int mapSize = (int) Math.sqrt(localMap.length);
		
		String row = " ";
		
		for (int position = 0; position < localMap.length; position++) {
			
			if (position != 0) {
				if (position%mapSize == 0) {
					System.out.println(row);
					row = "";
					for (int dashedPosition=0; dashedPosition<(4*mapSize-1); dashedPosition++) {
						row = row + "-";
					}
					System.out.println(row);
					row = " ";
				}
				else {
					row = row + " | ";
				}
			}
			
			row = row + localMap[position];
		}
		System.out.println(row);
	}
	
	public void writeToScreen(String text) {
		System.out.println(text);
	}

}
