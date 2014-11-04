package output.impl;

import map.Map;
import output.Output;

public class OutputConsole implements Output {

	public void clearScreen() {
		try {
			final String os = System.getProperty("os.name");
			
			if (os.contains("Windows")) {
				Runtime.getRuntime().exec("cls");
			}
			else {
				Runtime.getRuntime().exec("clear");
			}
		}
		catch (final Exception e) {
			// Handle any exceptions
		}
	}

	public void drawMap(Map map) {
		// TODO Auto-generated method stub
		for (int lineNumber = 0; lineNumber<map.getMapField().length; lineNumber++) {
			System.out.println(map.getMapField()[lineNumber]);
		}
		
	}

	public void writeToScreen(String text) {
		// TODO Auto-generated method stub
		System.out.println(text);
	}

}
