package Tutorial;

import Game.interface_adapters.GameController;
import Game.use_cases.GamePresenter;
import Menus.GameView;
import Game.use_cases.GameViewModel;

public class PuzzleOpener {
    public void open(Puzzle puzzle) {
        GameViewModel model = new GameViewModel();
        GameView view = new GameView(model);
        GamePresenter presenter = new GamePresenter(model);
        PuzzlesInteractor interactor = new PuzzlesInteractor(puzzle, presenter);
        view.setController(new GameController(interactor));
        interactor.initialisePosition();
        view.setTitle(puzzle.getName());
    }
}
