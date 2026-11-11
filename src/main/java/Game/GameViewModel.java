package Game;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class GameViewModel {
    private int row;
    private int column;
    private Color color;
    private int winner;
    private String statusMessage;

    private final List<GameViewModelListener> listeners = new ArrayList<>();

    public void setMoveResult(int row, int column, Color pieceColor, int winner, String statusMessage) {
        this.row = row;
        this.column = column;
        this.color = pieceColor;
        this.winner = winner;
        this.statusMessage = statusMessage;
    }

    public void addListener(GameViewModelListener listener) {
        listeners.add(listener);
    }

    public void updateBoard() {
        for (GameViewModelListener listener : listeners) {
            listener.onBoardUpdated(this);
        }
    }

    public int getColumn() {
        return column;
    }

    public Color getColor() {
        return color;
    }

    public int getRow() {
        return row;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public int getWinner() {
        return winner;
    }
}
