package Game.use_cases;

import Game.entities.Board;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

public class BoardExporter {
    public static ObjectMapper jsonMoveHistory(Board board) {
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<Move> moves = board.getMoveHistory();
        return mapper;
    }
}
