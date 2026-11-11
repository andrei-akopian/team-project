package Bot;

import Game.Board;
import Game.BoardAnalyzer;
import Game.Move;

/**
 * A bot with the following strategy
 * 1. If bot is about to win, it makes the move.
 * 2. If the other player is about to win, block it.
 * 3. If there is an opportunity to fork, fork.
 * 4. Make some other good move.
 */
public class SlowBot extends RandomBot {
  public SlowBot(int playerid) {
    super(playerid);
  }

  @Override
  public Move calculateMove(Board board) {
    BoardAnalyzer boardAnalyzer = new BoardAnalyzer(board);
    // 1. If bot is about to win, it makes the move
    Move candidate = boardAnalyzer.findWinningMove(playerid);
    if (candidate != null) {
      return candidate;
    }
    // 2. If the other player is about to win, block it.
    candidate = boardAnalyzer.findWinningMove(otherPlayerId());
    if (candidate != null) {
      return candidate;
    }
    // 3. If there is an opportunity to fork, fork.
    // TODO implement
    // 4. Make some other reasonable move.
    // TODO implement
    return super.calculateMove(board);
  }

  public int otherPlayerId() {
    if (playerid == 1) {
      return 2;
    } else if (playerid == 2) {
      return 1;
    }
    return 0;
  }
}
