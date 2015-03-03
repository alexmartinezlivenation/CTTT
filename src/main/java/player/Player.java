package player;

import map.BoardViewer;
import player.impl.PlayerDisplayInterface;

public abstract class Player {

    protected PlayerDisplayInterface playerDisplayBridge;
    protected String personalSymbol;
    protected Move move;

    public Player(PlayerDisplayInterface playerDisplayBridge) {
        this.playerDisplayBridge = playerDisplayBridge;
    }

	public void setPersonalSymbol(String personalSymbol) {
        this.personalSymbol = personalSymbol;
    }

    public String getPersonalSymbol() {
        return personalSymbol;
    }

    abstract public boolean makeMove(BoardViewer board);
}