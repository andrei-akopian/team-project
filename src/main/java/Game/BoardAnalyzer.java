package Game;

public class BoardAnalyzer {
  public final Board board;

  public BoardAnalyzer(Board board) {
    this.board = board;
  }

  /**
   * @return Move if a winning move exists, null otherwise.
   */
  public Move findWinningMove(int player) {
    for (int row = 0; row < board.BOARD_SIZE; row++) {
      for (int column = 0; column < board.BOARD_SIZE; column++) {
        Move move = new Move(row, column);
        if (isMoveWinning(move, player)) {
          return move;
        }
      }
    }
    return null;
  }

  /**
   * Try a move without actually making it.
   *
   * @param move
   * @param player
   * @return
   */
  public boolean emulateMove(Move move, int player) {
    boolean success = board.makeMove(move, player);
    board.undo();
    return success;
  }

  /**
   * See if a move is a winning move without making it.
   *
   * @param move
   * @param player
   * @return
   */
  public boolean isMoveWinning(Move move, int player) {
    board.makeMove(move, player);
    boolean player_won = board.getWinner() == player;
    board.undo();
    return player_won;
  }
}
