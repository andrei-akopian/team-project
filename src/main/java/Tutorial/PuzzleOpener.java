package Tutorial;

import Game.GameController;
import Game.GamePresenter;
import Game.GameView;
import Game.GameViewModel;

public class PuzzleOpener {
    public void open(Puzzle puzzle){
        GameViewModel model = new GameViewModel();
        GameView view = new GameView(model);
        GamePresenter presenter = new GamePresenter(model);
        PuzzlesInteractor interactor = new PuzzlesInteractor(puzzle, presenter);
        view.setController(new GameController(interactor));
        interactor.initialisePosition();
        view.setTitle(puzzle.getName());
    }
}
