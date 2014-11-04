package game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import output.impl.OutputConsole;

public class Setup {
	OutputConsole oc = new OutputConsole();
	
	public boolean initializeGame()  throws IOException {
		
		oc.writeToScreen("Please choose a game mode\n1.  Player vs. Computer\n2.  Player vs. Player");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String gameMode = br.readLine();
		
		if (gameMode.equals("2")) {
			//pvp
			oc.clearScreen();
			oc.writeToScreen("PVP");
			return true;
		}
		else {
			//pvc
			oc.clearScreen();
			oc.writeToScreen("PVC");
			return false;
		}
	}
	
	public void createMap(int mapSize) {
		
	}
}
