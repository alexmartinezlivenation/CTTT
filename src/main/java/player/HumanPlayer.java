package player;

import map.BoardViewer;
import player.impl.PlayerDisplayInterface;

/**
 * Created by alex.martinez on 2/24/15.
 */
public class HumanPlayer extends Player {
    public HumanPlayer(PlayerDisplayInterface displayBridge) {
        super(displayBridge);
    }

    public boolean makeMove(BoardViewer board) {
        move = new Move();
        String input = playerDisplayBridge.getInput();

        move.setPlayer(personalSymbol);
        move.setPosition(input);

        return board.updateBoard(move);
    }
}
