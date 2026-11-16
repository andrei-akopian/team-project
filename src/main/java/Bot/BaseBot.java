package Bot;

import Game.Board;
import Game.Move;

/**
 * The base class for a bot. It handles everything except making moves.
 */
public class BaseBot implements Bot {
  private int playerid;
  public BaseBot(int playerid) {
    this.playerid = playerid;
  }

  @Override
  public Move calculateMove(Board board) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public int getPlayerId() {
    return playerid;
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
