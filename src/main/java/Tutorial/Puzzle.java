package Tutorial;
import Game.Move;

public class Puzzle {
    private final String name;
    private final String level;
    private final Move[] start;
    private final Move[] moves;

    public Puzzle(String name, String level, Move[] start, Move[] moves) {
        this.start = start;
        this.moves = moves;
        this.name = name;
        this.level = level;
    }

    public Move[] getStart() {
        return start.clone();
    }

    public Move[] getMoves() {
        return moves.clone();
    }

    public String getName() {
        return name;
    }

    public String getLevel() {
        return level;
    }
}