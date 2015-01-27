package map;

import player.Move;

public interface MapInterface {
	public void initializeMap(int size);
	public boolean updateMap(Move move);
}
