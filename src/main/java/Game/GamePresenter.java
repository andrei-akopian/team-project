package Game;

public class GamePresenter implements GameOutputBoundary {

    private final GameViewModel gameViewModel;

    public GamePresenter(GameViewModel gameViewModel) {
        this.gameViewModel = gameViewModel;
    }

    @Override
    public void prepareView(GameOutputData response) {

       gameViewModel.setValues(response.getRow(),response.getColumn(),response.getPlayer(),response.getWinner());
       gameViewModel.updateBoard();
    }
}