package player;

import map.MapViewer;

public interface Player {
	//public void makeMove(Move move);
	public boolean makeMove(MapViewer map);

	public void setPersonalSymbol(String string);
}