package Bot;

import Game.Board;
import Game.Move;

import java.util.Random;

public class RandomBot implements Bot {
  int playerid;
  public RandomBot(int playerid) {
    this.playerid = playerid;
  }

  @Override
  public Move calculateMove(Board board) {
    Move candidate = randomMove(board.BOARD_SIZE);
    while (board.getTile(candidate) != 0) {
      candidate = randomMove(board.BOARD_SIZE);
    }
    return candidate;
  }

  private static int randomInt(int min, int max){
    return new Random().nextInt((max - min) + 1) + min;
  }

  private static Move randomMove(int board_size){
    int row = randomInt(0, board_size);
    int column = randomInt(0, board_size);
    return new Move(row, column);
  }
}
