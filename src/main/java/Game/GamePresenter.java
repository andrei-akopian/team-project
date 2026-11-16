package Game;

import java.awt.Color;
public class GamePresenter implements GameOutputBoundary {

    private final GameViewModel gameViewModel;

    public GamePresenter(GameViewModel gameViewModel) {
        this.gameViewModel = gameViewModel;
    }

    @Override
    public void prepareView(GameOutputData response) {
        Color color = (response.getPlayer() == 1) ? Color.BLACK : Color.WHITE;
        String message;
        if (response.getWinner() != 0) {
            message = "Player " + response.getWinner() + " wins!";
        }
        else{
            message = "";
        }

        gameViewModel.setMoveResult(
                response.getRow(),
                response.getColumn(),
                color,
                response.getWinner(),
                message
        );
        gameViewModel.updateBoard();
    }
}