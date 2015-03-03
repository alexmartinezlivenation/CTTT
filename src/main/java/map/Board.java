package map;

import player.Move;

import java.util.HashMap;

/**
 * Created by alex.martinez on 2/25/15.
 */
public class Board implements BoardInterface {
    private int boardSize;
    private HashMap<String, String> board;

    public void initializeBoard(int size) {
        board = new HashMap<String, String>();

        boardSize = size;
    }

    public boolean updateBoard(Move move) {
        return updateBoard(Integer.parseInt(move.getPosition()), move.getPlayer());
    }

    public boolean updateBoard(int position, String player) {
        if ((board.get(Integer.toString(position)) == null) && (position>=0) && (position < (boardSize*boardSize))) {
            board.put(Integer.toString(position), player);
            return true;
        }

        return false;
    }

    public HashMap<String, String> getBoard() {
        return board;
    }

    public void setBoard(HashMap<String, String> board) {
        this.board = board;
    }

    public int getBoardSize() {
        return boardSize;
    }
}