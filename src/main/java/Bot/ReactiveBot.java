package Bot;

import Game.Board;
import Game.BoardAnalyzer;
import Game.Move;

/**
 * A bot with the following strategy
 * 1. If bot is about to win, it makes the move.
 * 2. If the other player is about to win, block it.
 * 3. Make a random move.
 */
public class ReactiveBot extends RandomBot {
  public ReactiveBot(int playerid) {
    super(playerid);
  }

  @Override
  public Move calculateMove(Board board) {
    BoardAnalyzer boardAnalyzer = new BoardAnalyzer(board);
    // 1. If bot is about to win, it makes the move
    Move candidate = boardAnalyzer.findWinningMove(getPlayerId());
    if (candidate != null) {
      return candidate;
    }
    // 2. If the other player is about to win, block it.
    candidate = boardAnalyzer.findWinningMove(otherPlayerId());
    if (candidate != null) {
      return candidate;
    }
    return super.calculateMove(board);
  }
}
