package Game;

public class GameInteractor implements GameInputBoundary {
    private final Game game;
    private final GameOutputBoundary gamePresenter;
    public GameInteractor(GameOutputBoundary gamePresenter) {
        this.gamePresenter = gamePresenter;
        this.game = new Game();
    }

    @Override
    public void execute(Move move) {
        game.playerInput(move);
        final GameOutputData gameOutputData = new GameOutputData(move.row, move.column, 0, 0);
        gamePresenter.prepareView(gameOutputData);
    }

    @Override
    public void undo() {
        Move undonemove = game.undo();
        GameOutputData gameOutputData = new GameOutputData(undonemove.row, undonemove.column, 0, 0);
        gamePresenter.prepareView(gameOutputData);
    }
}
