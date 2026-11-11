package Game;

public interface GameViewModelListener {
    void updateBoard(int row, int col, int player, int winner);
}
