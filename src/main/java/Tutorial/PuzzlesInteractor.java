package Tutorial;
import Game.*;

public class PuzzlesInteractor implements GameInputBoundary {
    private final Game game = new Game();
    private final Puzzle puzzle;
    private final Move[] moves;
    private final GameOutputBoundary presenter;
    private int step = 0;

    public PuzzlesInteractor(Puzzle puzzle, GameOutputBoundary presenter) {
        this.puzzle = puzzle;
        this.moves = puzzle.getMoves();
        this.presenter = presenter;
    }

    public void initialisePosition() {
        for (Move m : puzzle.getStart()) { play(m); }
    }

    private void play(Move m) {
        int player = game.getTurn();
        game.playerInput(m);
        presenter.prepareView(new GameOutputData(m.row, m.column, player, game.getWinner()));
    }

    @Override
    public void execute(Move move) {
        if (step >= moves.length) { return; }
        if (move.row != moves[step].row || move.column != moves[step].column) { return; }
        play(move);
        step++;
        if (step < moves.length) {
            play(moves[step]);
            step++;
        }
    }

    @Override
    public void undo() { }
}