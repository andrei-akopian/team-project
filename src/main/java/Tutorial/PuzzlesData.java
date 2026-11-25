package Tutorial;

import Game.use_cases.Move;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
        addpuzzle5();
    }

    @Override
    public Map<String, List<Puzzle>> getPuzzles() {
        return puzzles;
    }

    private void add(Puzzle puzzle) {
        puzzles.get(puzzle.getLevel()).add(puzzle);
    }

    private void addpuzzle1() {
        Move[] start = new Move[8];
        for (int i = 0; i < 4; i++) {
            start[2 * i] = new Move(i, 7);
            start[2 * i + 1] = new Move(i, 8);
        }
        Move[] moves = {new Move(4, 7)};
        add(new Puzzle("Winning", "Beginner", start, moves));
    }

    private void addpuzzle2() {
        int[][] coords = {{5, 11}, {5, 10}, {6, 10}, {7, 10}, {8, 11}, {9, 10},
                {8, 9}, {9, 9}, {7, 9}, {7, 8}, {8, 8}, {6, 8}, {8, 7}, {7, 7},
                {8, 6}, {6, 7}, {8, 4}, {9, 6}, {10, 6}, {10, 7}};
        Move[] start = new Move[20];
        for (int i = 0; i < 20; i++) {
            start[i] = new Move(coords[i][0], coords[i][1]);
        }
        Move[] moves = {new Move(4, 12)};
        add(new Puzzle("Sneaky Sixes", "Beginner", start, moves));
    }

    private void addpuzzle3() {
        Move[] start = new Move[6];
        for (int i = 0; i < 3; i++) {
            start[2 * i] = new Move(6 + i, 9 - i);
            start[2 * i + 1] = new Move(4, 11 - i);
        }
        Move[] moves = {new Move(9, 6), new Move(10, 5), new Move(5, 10)};
        add(new Puzzle("Fork", "Intermediate", start, moves));
    }

    private void addpuzzle4() {
        int[][] coords = new int[14][2];
        for (int i = 0; i < 6; i++) {
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
        for (int i = 0; i < 14; i++) {
            start[i] = new Move(coords[i][0], coords[i][1]);
        }
        Move[] moves = {new Move(6, 6), new Move(8, 6), new Move(6, 4)};
        add(new Puzzle("Bluff", "Intermediate", start, moves));
    }

    private void addpuzzle5() {
        int[][] coords = new int[18][2];
        coords[0][0] = 6; coords[0][1] = 6;
        coords[1][0] = 5; coords[1][1] = 6;
        coords[2][0] = 5; coords[2][1] = 7;
        coords[3][0] = 4; coords[3][1] = 6;
        coords[4][0] = 5; coords[4][1] = 8;
        coords[5][0] = 7; coords[5][1] = 8;
        coords[6][0] = 5; coords[6][1] = 10;
        coords[7][0] = 6; coords[7][1] = 9;
        coords[8][0] = 8; coords[8][1] = 8;
        coords[9][0] = 7; coords[9][1] = 9;
        coords[10][0] = 9; coords[10][1] = 7;
        coords[11][0] = 8; coords[11][1] = 9;
        coords[12][0] = 9; coords[12][1] = 8;
        coords[13][0] = 10; coords[13][1] = 8;
        coords[14][0] = 4; coords[14][1] = 5;
        coords[15][0] = 6; coords[15][1] = 10;
        coords[16][0] = 8; coords[16][1] = 10;
        coords[17][0] = 4; coords[17][1] = 12;
        Move[] start = new Move[18];
        for (int i = 0; i < 18; i++) {
            start[i] = new Move(coords[i][0], coords[i][1]);
        }

        int[][] sol = new int[9][2];
        sol[0][0] = 9; sol[0][1] = 9;
        sol[1][0] = 5; sol[1][1] = 9;
        sol[2][0] = 4; sol[2][1] = 9;
        sol[3][0] = 5; sol[3][1] = 11;
        sol[4][0] = 3; sol[4][1] = 13;
        sol[5][0] = 9; sol[5][1] = 10;
        sol[6][0] = 7; sol[6][1] = 7;
        sol[7][0] = 5; sol[7][1] = 5;
        sol[8][0] = 10; sol[8][1] = 10;
        Move[] moves = new Move[9];
        for (int i = 0; i < 9; i++) {
            moves[i] = new Move(sol[i][0], sol[i][1]);
        }

        add(new Puzzle("Threats", "Advanced", start, moves));
    }
}