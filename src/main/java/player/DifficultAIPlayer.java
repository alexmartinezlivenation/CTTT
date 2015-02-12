package player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import map.MapViewer;

//import map.Map;

public class DifficultAIPlayer implements Player {

	private String personalSymbol;
	private Move move;
	
	public boolean makeSimpleMove(MapViewer map) {
		move = new Move();
		move.setPlayer(personalSymbol);

        return false;
	}
	
	private String getRandomPosition() {
		Random randomGenerator = new Random();
		return Integer.toString(randomGenerator.nextInt(9));
	}
	
	public boolean makeMove(MapViewer map) {
		move = new Move();
		move.setPlayer(personalSymbol);
		
		//If winning move available, make it
		
		//Search for opponent's winning move, and stop it
		
		//Find out which rows, diagonals and columns have 1 empty space
		
		//analyze rows to prevent opponent's win move (i.e. make sure only opponent has pieces here)
		
		//analyze columns to prevent win move (i.e. make sure only opponent has pieces here)

		
		//analyze left diagonal (by left meaning top-left)
		
		//analyze right diagonal (by right meaning top-right)
		
		return false;
	}

	public String getPersonalSymbol() {
		return personalSymbol;
	}

	public void setPersonalSymbol(String personalSymbol) {
		this.personalSymbol = personalSymbol;
	}

}