package Game.entities.Bot;

import Game.use_cases.Move;
import Game.entities.Board;

public interface Bot {
    Move calculateMove(Board board);

    int getPlayerId();
}
