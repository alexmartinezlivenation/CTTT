package map;

import player.Move;

import java.util.HashMap;

/**
 * Created by alex.martinez on 2/25/15.
 */
public interface BoardInterface {
    public void initializeBoard(int size);
    public boolean updateBoard(Move move);
    public HashMap<String, String> getBoard();
    public int getBoardSize();
}