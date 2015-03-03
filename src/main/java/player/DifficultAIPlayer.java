package player;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import player.impl.PlayerDisplayInterface;

import map.BoardViewer;


public class DifficultAIPlayer extends Player {

    public DifficultAIPlayer(PlayerDisplayInterface displayBridge) {
        super(displayBridge);
    }

	private String getRandomPosition(int maxRand) {
		Random randomGenerator = new Random();
		return Integer.toString(randomGenerator.nextInt(maxRand));
	}
	
	public boolean makeMove(BoardViewer board) {
		move = new Move();
		move.setPlayer(personalSymbol);
		
		//If winning move available, make it
        String index;
        index = rowWithWinningMove(board, personalSymbol);
        if (!index.equals("")) {
            move.setPosition(getRowEmptySpace(board, index));
            return board.updateBoard(move);
        }

        index = colWithWinningMove(board, personalSymbol);
        if (!index.equals("")) {
            move.setPosition(getColEmptySpace(board, index));
            return board.updateBoard(move);
        }

        index = digWithWinningMove(board, personalSymbol);
        if (!index.equals("")) {
            move.setPosition(getDigEmptySpace(board, index));
            return board.updateBoard(move);
        }

		//Search for opponent's winning move, and stop it
        index = rowWithLosingMove(board, personalSymbol);
        if (!index.equals("")) {
            move.setPosition(getRowEmptySpace(board, index));
            return board.updateBoard(move);
        }

        index = colWithLosingMove(board, personalSymbol);
        if (!index.equals("")) {
            move.setPosition(getColEmptySpace(board, index));
            return board.updateBoard(move);
        }

        index = digWithLosingMove(board, personalSymbol);
        if (!index.equals("")) {
            move.setPosition(getDigEmptySpace(board, index));
            return board.updateBoard(move);
        }

        //Else, make a random move
        int position = board.getBoardSize() * board.getBoardSize();
        move.setPosition(getRandomPosition(position));

		return board.updateBoard(move);
	}

    private String rowWithWinningMove(BoardViewer board, String symbol) {
        HashMap<String, String[]> row = board.getRowTable();

        for (Map.Entry<String, String[]> entry : row.entrySet()) {
            String rowIndex = entry.getKey();
            String[] symbolPower = entry.getValue();
            if (symbolPower[1] == null) {
                continue;
            }
            if (symbolPower[0].equals(symbol) && Integer.parseInt(symbolPower[1]) == board.getBoardSize() - 1) {
                return rowIndex;
            }
        }

        return "";

    }

    private String colWithWinningMove(BoardViewer board, String symbol) {
        HashMap<String, String[]> col = board.getColTable();

        for (Map.Entry<String, String[]> entry : col.entrySet()) {
            String colIndex = entry.getKey();
            String[] symbolPower = entry.getValue();
            if (symbolPower[1] == null) {
                continue;
            }
            if (symbolPower[0].equals(symbol) && Integer.parseInt(symbolPower[1]) == board.getBoardSize() - 1) {
                return colIndex;
            }
        }

        return "";
    }

    private String digWithWinningMove(BoardViewer board, String symbol) {
        HashMap<String, String[]> dig = board.getDigTable();

        for (Map.Entry<String, String[]> entry : dig.entrySet()) {
            String digIndex = entry.getKey();
            String[] symbolPower = entry.getValue();
            if (symbolPower[1] == null) {
                continue;
            }
            if (symbolPower[0].equals(symbol) && Integer.parseInt(symbolPower[1]) == board.getBoardSize() - 1) {
                return digIndex;
            }
        }

        return "";
    }

    private String rowWithLosingMove(BoardViewer board, String symbol) {
        HashMap<String, String[]> row = board.getRowTable();

        for (Map.Entry<String, String[]> entry : row.entrySet()) {
            String rowIndex = entry.getKey();
            String[] symbolPower = entry.getValue();
            if (symbolPower[1] == null) {
                continue;
            }
            if (!symbolPower[0].equals(symbol) && Integer.parseInt(symbolPower[1]) == board.getBoardSize() - 1) {
                return rowIndex;
            }
        }

        return "";

    }

    private String colWithLosingMove(BoardViewer board, String symbol) {
        HashMap<String, String[]> col = board.getColTable();

        for (Map.Entry<String, String[]> entry : col.entrySet()) {
            String colIndex = entry.getKey();
            String[] symbolPower = entry.getValue();
            if (symbolPower[1] == null) {
                continue;
            }
            if (!symbolPower[0].equals(symbol) && Integer.parseInt(symbolPower[1]) == board.getBoardSize() - 1) {
                return colIndex;
            }
        }

        return "";
    }

    private String digWithLosingMove(BoardViewer board, String symbol) {
        HashMap<String, String[]> dig = board.getDigTable();

        for (Map.Entry<String, String[]> entry : dig.entrySet()) {
            String digIndex = entry.getKey();
            String[] symbolPower = entry.getValue();
            if (symbolPower[1] == null) {
                continue;
            }
            if (!symbolPower[0].equals(symbol) && Integer.parseInt(symbolPower[1]) == board.getBoardSize() - 1) {
                return digIndex;
            }
        }

        return "";
    }

    private String getRowEmptySpace(BoardViewer board, String rowIndex) {
        int ri = Integer.parseInt(rowIndex);
        ri = ri * board.getBoardSize();

        for (int relativePosition=0; relativePosition < board.getBoardSize(); relativePosition++) {
            String position = Integer.toString(ri + relativePosition);
            if (!board.getBoard().containsKey(position)) {
                return position;
            }

        }

        return getRandomPosition(board.getBoardSize()^2);  //should never return this
    }

    private String getColEmptySpace(BoardViewer board, String colIndex) {
        int ci = Integer.parseInt(colIndex);

        for (int relativePosition=0; relativePosition < board.getBoardSize(); relativePosition++) {
            String position = Integer.toString(ci + relativePosition * board.getBoardSize());
            if (!board.getBoard().containsKey(position)) {
                return position;
            }

        }

        return getRandomPosition(board.getBoardSize()^2);  //should never return this
    }

    private String getDigEmptySpace(BoardViewer board, String digIndex) {
        if (digIndex.equals("\\")) {
            for (int relativePosition=0; relativePosition < board.getBoardSize(); relativePosition++) {
                String position = Integer.toString(relativePosition * (board.getBoardSize() + 1));
                if (!board.getBoard().containsKey(position)) {
                    return position;
                }

            }
        }
        else if (digIndex.equals("/")) {
            for (int relativePosition=0; relativePosition < board.getBoardSize(); relativePosition++) {
                String position = Integer.toString((relativePosition + 1) * (board.getBoardSize() - 1));
                if (!board.getBoard().containsKey(position)) {
                    return position;
                }

            }
        }

        return getRandomPosition(board.getBoardSize()^2);  //should never return this
    }

}




//find a row/column/diagonal with a winning move available
    //find the empty space in that row/column/diagonal
    //make that move

//find a row/column/diagonal with a losing move available
    //find the empty space in that row/column/diagonal
    //block it

//make a random move