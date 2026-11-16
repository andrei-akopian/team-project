package Bot;

import Game.Board;
import Game.BoardAnalyzer;
import Game.Move;

/**
 * Strategic Bot uses a list of common strategies:
 * 1. If bot has a winning move, make it.
 * 2. If player will win on next turn, block him.
 * 3. If a fork opportunity exists, use it.
 * 4. If other player has a fork opportunity, counter it.
 * 5. Make a heuristically good move.
 */
public class StrategicBot extends RandomBot {
  public StrategicBot(int playerid) {
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
    // 3. If a fork opportunity exists, use it.
    candidate = boardAnalyzer.findForkMove(getPlayerId());
    if (candidate != null) {
      return candidate;
    }
    // 4. If other player has a fork opportunity, counter it.
    candidate = boardAnalyzer.findForkMove(otherPlayerId());
    if (candidate != null) {
      return candidate;
    }
    // 5. Make a heuristically good move.
    return super.calculateMove(board);
  }
}
