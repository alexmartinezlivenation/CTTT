package map;

import player.Move;

import java.util.HashMap;

/**
 * Created by alex.martinez on 2/25/15.
 */
public class BoardViewer {
    private BoardInterface viewedBoard;
    private HashMap<String, String[]> rowTable = new HashMap<String, String[]>();
    private HashMap<String, String[]> colTable = new HashMap<String, String[]>();
    private HashMap<String, String[]> digTable = new HashMap<String, String[]>();

    public boolean updateBoard(Move move) {
        if (viewedBoard.updateBoard(move)) {
            String[] cartesianPosition = convertToCartesian(move);
            updateTables(cartesianPosition);
            return true;
        }

        return false;
    }

    private String[] convertToCartesian(Move move) {
        String[] cartesian = new String[3];
        cartesian[0] = move.getPlayer();

        int position = Integer.parseInt(move.getPosition());
        cartesian[1] = Integer.toString(position / viewedBoard.getBoardSize()); //row
        cartesian[2] = Integer.toString(position % viewedBoard.getBoardSize()); //column

        return cartesian;
    }

    private void updateTables(String[] cartesianPosition) {
        updateRowTable(cartesianPosition[1], cartesianPosition[0]);
        updateColTable(cartesianPosition[2], cartesianPosition[0]);
        updateDigTable(cartesianPosition);
    }

    private void updateRowTable(String rowIndex, String playerSymbol) {
        if (rowTable.containsKey(rowIndex)) {
            if (rowTable.get(rowIndex)[0].equals(playerSymbol)) {
                int symbolCount = Integer.parseInt(rowTable.get(rowIndex)[1]);
                rowTable.put(rowIndex, new String[]{playerSymbol, Integer.toString(symbolCount + 1)});
            }
            else {
                rowTable.put(rowIndex, new String[]{"", null});
            }
        }
        else {
            rowTable.put(rowIndex, new String[]{playerSymbol, "1"});
        }
    }

    private void updateColTable(String colIndex, String playerSymbol) {
        if (colTable.containsKey(colIndex)) {
            if (colTable.get(colIndex)[0].equals(playerSymbol)) {
                int symbolCount = Integer.parseInt(colTable.get(colIndex)[1]);
                colTable.put(colIndex, new String[]{playerSymbol, Integer.toString(symbolCount + 1)});
            }
            else {
                colTable.put(colIndex, new String[]{"", null});
            }
        }
        else {
            colTable.put(colIndex, new String[]{playerSymbol, "1"});
        }
    }

    private void updateDigTable(String[] cartesianCoord) {
        if (cartesianCoord[1].equals(cartesianCoord[2])) {
            updateSingleDig("\\", cartesianCoord[0]);
        }

        if (Integer.parseInt(cartesianCoord[1]) == (viewedBoard.getBoardSize() - Integer.parseInt(cartesianCoord[2]) - 1) ) {
            updateSingleDig("/", cartesianCoord[0]);
        }
    }

    private void updateSingleDig(String diagonal, String playerSymbol) {
        if (digTable.containsKey(diagonal)) {
            if (digTable.get(diagonal)[0].equals(playerSymbol)) {
                int symbolCount = Integer.parseInt(digTable.get(diagonal)[1]) + 1;
                digTable.put(diagonal, new String[]{playerSymbol, Integer.toString(symbolCount)});
            }
        }
        else {
            digTable.put(diagonal, new String[]{playerSymbol, "1"});
        }
    }

    public void clearTables() {
        rowTable.clear();
        colTable.clear();
        digTable.clear();
    }

    public int getBoardSize() {
        return viewedBoard.getBoardSize();
    }

    public void setViewedBoard(BoardInterface viewedBoard) {
        this.viewedBoard = viewedBoard;
    }

    public HashMap<String, String> getBoard() {
        return viewedBoard.getBoard();
    }

    public HashMap<String, String[]> getRowTable() {
        return rowTable;
    }

    public HashMap<String, String[]> getColTable() {
        return colTable;
    }

    public HashMap<String, String[]> getDigTable() {
        return digTable;
    }
}
