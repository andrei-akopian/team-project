package Menus;

import Game.interface_adapters.GameViewModel;

public interface GameViewModelListener {
    void onBoardUpdated(GameViewModel gameViewModel);
}
