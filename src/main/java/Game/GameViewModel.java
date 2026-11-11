package Game;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class GameViewModel {

    private int row = 0;
    private int column = 0;
    private int player = 1;
    private int winner = 0;
    private final List<GameViewModelListener> listeners = new ArrayList<>();

    public void setValues(int row, int column, int player, int winner){
        this.row = row;
        this.column = column;
        this.player = player;
        this.winner = winner;
    }

    public void addListener(GameViewModelListener listener) {
        listeners.add(listener);
    }

    public void updateBoard(){
        for(GameViewModelListener listener:listeners){
            listener.updateBoard(row, column, player, winner);
        }
    }

}