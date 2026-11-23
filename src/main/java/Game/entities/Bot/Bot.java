package Game.entities.Bot;
import Game.use_cases.Move;
import Game.entities.Board;

public interface Bot {
  public Move calculateMove(Board board);
  public int getPlayerId();
}
