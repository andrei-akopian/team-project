package Tutorial;

import Game.Move;
import java.util.*;

public class PuzzlesData implements PuzzlesAccessInterface {
    private final Map<String, List<Puzzle>> puzzles = new LinkedHashMap<>();

    public PuzzlesData() {
        puzzles.put("Beginner", new ArrayList<>());
        puzzles.put("Intermediate", new ArrayList<>());
        puzzles.put("Advanced", new ArrayList<>());

        addpuzzle1();
    }

    @Override
    public Map<String, List<Puzzle>> getPuzzles() {
        return puzzles;
    }

    private void add(Puzzle puzzle){
        puzzles.get(puzzle.getLevel()).add(puzzle);
    }

    private void addpuzzle1(){
        Move[] start = new Move[8];
        for(int i = 0; i < 4; i++){
            start[2*i] = new Move(i, 7);
            start[2*i+1] = new Move(i, 8);
        }
        Move[] moves = { new Move(4, 7) };
        add(new Puzzle("Winning", "Beginner", start, moves));
    }
}