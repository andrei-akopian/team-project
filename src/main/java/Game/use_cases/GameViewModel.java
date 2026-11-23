package Game.use_cases;

import Menus.GameViewModelListener;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class GameViewModel {
    private int row;
    private int column;
    private int player;
    private Color color;
    private int winner;
    private String statusMessage;

    private final List<GameViewModelListener> listeners = new ArrayList<>();

    public void setMoveResult(int row, int column, int player, Color color, int winner, String statusMessage) {
        this.row = row;
        this.column = column;
        this.player = player;
        this.color = color;
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

    public int getPlayer() {
        return player;
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