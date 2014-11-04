package game;

import java.io.IOException;



public class Game {
	public static void main(String[] args) {
		
		//create players and map
		Setup setup = new Setup();
		try {
			setup.initializeGame();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
