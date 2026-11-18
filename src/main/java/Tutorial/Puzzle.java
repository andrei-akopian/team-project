package Tutorial;
import Game.*;

import javax.swing.*;

public class Puzzle {
    private final Board start;
    private final Move[] moves;
    public Puzzle(Board start, Move[] moves) {
        this.start = start;
        this.moves = moves;
    }
    public Board getStart() {
        return start.copy();
    }
    public Move[] getMoves() {
        return moves.clone();
    }

    static void main() {
        SwingUtilities.invokeLater(() -> {

            GameViewModel gameViewModel = new GameViewModel();
            GameView view = new GameView(gameViewModel);

            GamePresenter presenter = new GamePresenter(gameViewModel);

            GameInputBoundary interactor =
                    new GameInteractor(presenter);

            GameController controller =
                    new GameController(interactor);

            view.setController(controller);
            for(int i = 0; i < 4; i++){
                controller.execute(i, 7);
                controller.execute(i, 8);
            }
            view.setVisible(true);
        });
    }
}