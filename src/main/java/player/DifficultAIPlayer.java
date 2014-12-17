package player;

import map.Map;

//import map.Map;

public class DifficultAIPlayer implements Player {

	private String personalSymbol;
	private Move move;
	//private Map referenceMap;
	
	public boolean makeMove(Map map) {
		move = new Move();
		move.setPlayer(personalSymbol);
		
		move.setPosition("0");
		
		//check for our win moves and make it
		
		//check for opponent's win moves and try to stop it
		//prioritize increasing possible win moves and decreasing possible lose moves
		
		return map.updateMap(Integer.parseInt(move.getPosition()), move.getPlayer());
		
	}
	
	public boolean checkVertical(Move move, Map map) {
		
		for (int columnIndex = Integer.parseInt(move.getPosition()) % map.getMapSize(); columnIndex < map.getMapField().length; columnIndex+= map.getMapSize()) {
			if (map.getMapField()[columnIndex].equals("x")) {
				return false;
			}
		}
		
		return true;
	}
	
	public boolean checkHorizontal(Move move, Map map) {
		int position = Integer.parseInt(move.getPosition());
		int mapLength = map.getMapSize();
		int thisRowIndex = (position - (position%mapLength))/mapLength;
		int nextRowIndex = thisRowIndex + 1;
		
		for (int rowIndex = thisRowIndex * mapLength; rowIndex < nextRowIndex*mapLength; rowIndex++) {
			if (map.getMapField()[rowIndex].equals("x")) {
				return false;
			}
		}
		
		return true;
	}
	
	public boolean checkDiagonal(Move move, Map map) {
		return true;
	}

	public String getPersonalSymbol() {
		return personalSymbol;
	}

	public void setPersonalSymbol(String personalSymbol) {
		this.personalSymbol = personalSymbol;
	}
	
	/*public void setReferenceMap(Map referenceMap) {
		this.referenceMap = referenceMap;
	}*/

}
