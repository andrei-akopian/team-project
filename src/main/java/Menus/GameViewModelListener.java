package Menus;

import Game.use_cases.GameViewModel;

public interface GameViewModelListener {
    void onBoardUpdated(GameViewModel gameViewModel);
}
