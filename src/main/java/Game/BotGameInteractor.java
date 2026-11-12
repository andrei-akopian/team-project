package Game;

import Bot.Bot;
import Bot.ReactiveBot;
import Bot.StrategicBot;
import java.util.concurrent.TimeUnit;

public class BotGameInteractor implements GameInputBoundary {
  private final Game game;
  private final GameOutputBoundary gamePresenter;
  private final Bot bot;
  public BotGameInteractor(GameOutputBoundary gamePresenter) {
    this.gamePresenter = gamePresenter;
    this.game = new Game();
    this.bot = new StrategicBot(2);
  }

  @Override
  public void execute(Move move) {
    final int player = game.getTurn();
    game.playerInput(move);
    final int winner = game.getWinner();
    final GameOutputData gameOutputData = new GameOutputData(move.row, move.column,player,winner);
    gamePresenter.prepareView(gameOutputData);
    if (winner != 0) {
      return;
    } else {
      delay();
      botMove();
    }
  }

  private void delay() {
    try {
      TimeUnit.MILLISECONDS.sleep(250);
    } catch (InterruptedException e) {

    }
  }

  public void botMove() {
    final int player = game.getTurn();
    Move move = bot.calculateMove(game.getBoard());
    game.playerInput(move);
    final int winner = game.getWinner();
    final GameOutputData gameOutputData = new GameOutputData(move.row, move.column, player, winner);
    gamePresenter.prepareView(gameOutputData);
  }

  @Override
  public void undo() {
    // bot move
    Move undonemove = game.undo();
    if (undonemove == null) {
      return;
    }
    GameOutputData gameOutputData = new GameOutputData(undonemove.row, undonemove.column, 0, 0);
    gamePresenter.prepareView(gameOutputData);
    // player move
    undonemove = game.undo(); // player move
    if (undonemove == null) {
      return;
    }
    gameOutputData = new GameOutputData(undonemove.row, undonemove.column, 0, 0);
    gamePresenter.prepareView(gameOutputData);
  }
}
