package Game;

import java.util.ArrayList;

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
        if (board.tileIsEmpty(move) && isMoveWinning(move, player)) {
          return move;
        }
      }
    }
    return null;
  }

  /**
   * @return Move if a winning move exists, null otherwise.
   */
  public Move findForkMove(int player) {
    // trivially, if winning move exists, no forking is necessary.
    Move candidate = findWinningMove(player);
    if (candidate != null) {
      return candidate;
    }
    // otherwise search for a proper fork
    for (int row = 0; row < board.BOARD_SIZE; row++) {
      for (int column = 0; column < board.BOARD_SIZE; column++) {
        Move move = new Move(row, column);
        if (board.tileIsEmpty(move) && tileIsFork(move, player)) {
          return move;
        }
      }
    }
    return null;
  }

  public boolean tileIsFork(Move move, int player) {
    board.makeMove(move, player);
    ArrayList<Move> moves = findAllWinningMoves(player);
    board.undo();
    return moves.size() >= 2;
  }

  /**
   * @return Return list of winning moves
   */
  public ArrayList<Move> findAllWinningMoves(int player) {
    ArrayList<Move> winningMoves = new ArrayList<>();
    for (int row = 0; row < board.BOARD_SIZE; row++) {
      for (int column = 0; column < board.BOARD_SIZE; column++) {
        Move move = new Move(row, column);
        if (board.tileIsEmpty(move) && isMoveWinning(move, player)) {
          winningMoves.add(move);
        }
      }
    }
    return winningMoves;
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
