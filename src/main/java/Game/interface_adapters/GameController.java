package Game.interface_adapters;

import Game.use_cases.GameInputBoundary;
import Game.use_cases.Move;

public class GameController {
    private final GameInputBoundary gameInteractor;

    public GameController(GameInputBoundary gameInteractor) {
        this.gameInteractor = gameInteractor;
    }

    public void execute(int row, int col) {
        final Move loginInputData = new Move(row, col);
        gameInteractor.execute(loginInputData);
    }

    public void undo() {
        gameInteractor.undo();
    }
}
