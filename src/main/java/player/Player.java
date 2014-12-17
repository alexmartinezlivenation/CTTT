package player;

import map.Map;

public interface Player {
	//public void makeMove(Move move);
	public boolean makeMove(Map map);

	public void setPersonalSymbol(String string);
}
