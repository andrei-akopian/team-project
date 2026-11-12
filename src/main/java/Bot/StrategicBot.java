package Bot;

import Game.Board;
import Game.Move;

/**
 * Strategic Bot uses a list of common strategies:
 * 1. If bot has a winning move, make it.
 * 2. If player will win on next turn, block him.
 * 3. If a fork opportunity exists, use it.
 * 4. If other player has a fork opportunity, counter it.
 * 5. Make a heuristically good move.
 */
public class StrategicBot extends BaseBot {
  public StrategicBot(int playerid) {
    super(playerid);
  }
  @Override
  public Move calculateMove(Board board) {
    throw new UnsupportedOperationException("Not supported yet.");
  }
}
