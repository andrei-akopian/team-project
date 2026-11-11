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
        final int player = game.getTurn();
        game.playerInput(move);
        final int winner = game.getWinner();
        final GameOutputData gameOutputData = new GameOutputData(move.row, move.column, player, winner);
        gamePresenter.prepareView(gameOutputData);
    }
}
