package Tutorial;

import Game.use_cases.Move;
import java.util.*;

public class PuzzlesData implements PuzzlesAccessInterface {
    private final Map<String, List<Puzzle>> puzzles = new LinkedHashMap<>();

    public PuzzlesData() {
        puzzles.put("Beginner", new ArrayList<>());
        puzzles.put("Intermediate", new ArrayList<>());
        puzzles.put("Advanced", new ArrayList<>());

        addpuzzle1();
        addpuzzle2();
        addpuzzle3();
        addpuzzle4();
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

    private void addpuzzle2() {
        int[][] coords = { {5, 11}, {5, 10}, {6, 10}, {7, 10}, {8, 11}, {9, 10},
                {8, 9}, {9, 9}, {7, 9}, {7, 8}, {8, 8}, {6, 8}, {8, 7}, {7, 7},
                {8, 6}, {6, 7}, {8, 4}, {9, 6}, {10, 6}, {10, 7} };
        Move[] start = new Move[20];
        for(int i = 0; i < 20; i++){
            start[i] = new Move(coords[i][0], coords[i][1]);
        }
        Move[] moves = {new Move(4, 12)};
        add(new Puzzle("Sneaky Sixes", "Beginner", start, moves));
    }

    private void addpuzzle3() {
        Move[] start = new Move[6];
        for(int i = 0; i < 3; i++){
            start[2*i] = new Move(6 + i, 9 - i);
            start[2*i+1] = new Move(4, 11 - i);
        }
        Move[] moves = {new Move(9, 6), new Move(10, 5), new Move(5, 10)};
        add(new Puzzle("Fork", "Intermediate", start, moves));
    }

    private void addpuzzle4(){
        int[][] coords = new int[14][2];
        for(int i = 0; i < 6; i++) {
            if (i < 2) {
                coords[2 * i + 1] = new int[]{i, 3 + i};
            } else {
                coords[2 * i + 1] = new int[]{1 + i, 4 + i};
            }
        }
        coords[13] = new int[]{7, 7};
        coords[0] = new int[]{6, 5};
        coords[2] = new int[]{4, 6};
        coords[4] = new int[]{5, 6};
        coords[6] = new int[]{7, 6};
        coords[8] = new int[]{6, 7};
        coords[10] = new int[]{6, 8};
        coords[12] = new int[]{7, 10};
        Move[] start = new Move[14];
        for(int i = 0; i < 14; i++){
            start[i] = new Move(coords[i][0], coords[i][1]);
        }
        Move[] moves = {new Move(6, 6), new Move(8, 6), new Move(6, 4)};
        add(new Puzzle("Bluff", "Intermediate", start, moves));
    }
}